package com.programmersbox.mtg

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import kotlinx.android.synthetic.main.activity_card_info.*

class CardInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_info)

        val gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            /*override fun onLongPress(e: MotionEvent) {
                if (view.zoomImage.isReady) {
                    //val sCoord: PointF = view.zoomImage.viewToSourceCoord(e.x, e.y)!!
                    //val pixel = bitmap.getPixel(sCoord.x.toInt(), sCoord.y.toInt())

                }
            }*/
        })

        //imageCard.setImage(ImageSource.bitmap(bitmap))
        imageCard.setOnTouchListener { _, motionEvent -> gestureDetector.onTouchEvent(motionEvent) }

        Glide
            .with(this)
            .asBitmap()
            .load(intent.getStringExtra("card_image"))
            .override(Target.SIZE_ORIGINAL)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    imageCard.setImage(ImageSource.bitmap(resource))
                }
            })
    }
}