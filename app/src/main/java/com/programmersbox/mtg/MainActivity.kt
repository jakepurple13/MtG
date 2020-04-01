package com.programmersbox.mtg

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.programmersbox.dragswipe.DragSwipeAdapter
import com.programmersbox.flowutils.RecyclerViewScroll
import com.programmersbox.flowutils.clicks
import com.programmersbox.flowutils.collectOnUi
import com.programmersbox.flowutils.scrollReached
import com.programmersbox.helpfulutils.requestPermissions
import com.programmersbox.loggingutils.Loged
import com.programmersbox.loggingutils.f
import com.programmersbox.mtg.MtGCards.MtGApi
import com.programmersbox.mtg.MtGCards.MtGCard
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_item.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var pageNumber = 1

    private lateinit var adapter: MtGAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(
            Manifest.permission.INTERNET
        ) {
            if (!it.isGranted) Toast.makeText(this, "You need this", Toast.LENGTH_SHORT).show()
        }

        adapter = MtGAdapter(mutableListOf(), this@MainActivity)
        mtgRv.adapter = adapter

        addCards()

        mtgRv
            .scrollReached()
            .collectOnUi {
                when (it) {
                    RecyclerViewScroll.START -> Loged.r("Start")
                    RecyclerViewScroll.END -> addCards().also { Loged.r("End") }
                }
            }
    }

    private fun addCards() {
        GlobalScope.launch {
            pageNumber++
            val info = MtGApi { page { this.pageNumber = this@MainActivity.pageNumber } }
            info?.let { Loged.f("${it.size} cards") }
            runOnUiThread { info?.let { adapter.addItems(it) } }
        }
    }
}

class MtGAdapter(dataList: MutableList<MtGCard>, private val context: Context) : DragSwipeAdapter<MtGCard, ViewHolder>(dataList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, parent, false))

    override fun ViewHolder.onBind(item: MtGCard, position: Int) {
        Glide
            .with(context)
            .load(item.image_uris?.small)
            .override(Target.SIZE_ORIGINAL)
            .into(cardImage)
        cardTitle.text = item.name
        itemView
            .clicks()
            .collectOnUi {
                context.startActivity(Intent(context, CardInfoActivity::class.java).apply {
                    putExtra("card_image", item.image_uris?.large)
                })
            }
    }

}


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val cardImage = itemView.cardImage
    val cardTitle = itemView.cardTitle
}