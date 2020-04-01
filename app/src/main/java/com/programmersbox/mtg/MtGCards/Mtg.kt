package com.programmersbox.mtg.MtGCards

// result generated from /json

data class All_parts1060158574(val `object`: String?, val id: String?, val component: String?, val name: String?, val type_line: String?, val uri: String?)

data class All_parts1810206087(val `object`: String?, val id: String?, val component: String?, val name: String?, val type_line: String?, val uri: String?)

data class All_parts220813941(val `object`: String?, val id: String?, val component: String?, val name: String?, val type_line: String?, val uri: String?)

data class All_parts681357199(val `object`: String?, val id: String?, val component: String?, val name: String?, val type_line: String?, val uri: String?)

data class All_parts728111776(val `object`: String?, val id: String?, val component: String?, val name: String?, val type_line: String?, val uri: String?)

data class Base(val `object`: String?, val total_cards: Number?, val has_more: Boolean?, val next_page: String?, val data: List<MtGCard>?)

data class Card_faces1023173479(val `object`: String?, val name: String?, val mana_cost: String?, val type_line: String?, val oracle_text: String?, val watermark: String?, val artist: String?, val artist_id: String?)

data class Card_faces1088414481(val `object`: String?, val name: String?, val mana_cost: String?, val type_line: String?, val oracle_text: String?, val power: String?, val toughness: String?, val artist: String?, val artist_id: String?)

data class Card_faces613423884(val `object`: String?, val name: String?, val mana_cost: String?, val type_line: String?, val oracle_text: String?, val power: String?, val toughness: String?, val artist: String?, val artist_id: String?)

data class MtGCard(val `object`: String?, val id: String?, val oracle_id: String?, val multiverse_ids: List<Any>?, val name: String?, val printed_name: String?, val lang: String?, val released_at: String?, val uri: String?, val scryfall_uri: String?, val layout: String?, val highres_image: Boolean?, val image_uris: Image_uris?, val mana_cost: String?, val cmc: Number?, val type_line: String?, val printed_type_line: String?, val oracle_text: String?, val printed_text: String?, val power: String?, val toughness: String?, val colors: List<String>?, val color_identity: List<String>?, val legalities: Legalities?, val games: List<String>?, val reserved: Boolean?, val foil: Boolean?, val nonfoil: Boolean?, val oversized: Boolean?, val promo: Boolean?, val reprint: Boolean?, val variation: Boolean?, val set: String?, val set_name: String?, val set_type: String?, val set_uri: String?, val set_search_uri: String?, val scryfall_set_uri: String?, val rulings_uri: String?, val prints_search_uri: String?, val collector_number: String?, val digital: Boolean?, val rarity: String?, val card_back_id: String?, val artist: String?, val artist_ids: List<String>?, val illustration_id: String?, val border_color: String?, val frame: String?, val frame_effects: List<String>?, val full_art: Boolean?, val textless: Boolean?, val booster: Boolean?, val story_spotlight: Boolean?, val edhrec_rank: Number?, val prices: Prices?, val related_uris: Related_uris?, val purchase_uris: Purchase_uris?)

data class Image_uris(val small: String?, val normal: String?, val large: String?, val png: String?, val art_crop: String?, val border_crop: String?)

data class Legalities(val standard: String?, val future: String?, val historic: String?, val pioneer: String?, val modern: String?, val legacy: String?, val pauper: String?, val vintage: String?, val penny: String?, val commander: String?, val brawl: String?, val duel: String?, val oldschool: String?)

data class Preview(val source: String?, val source_uri: String?, val previewed_at: String?)

data class Prices(val usd: Any?, val usd_foil: String?, val eur: String?, val tix: Any?)

data class Purchase_uris(val tcgplayer: String?, val cardmarket: String?, val cardhoarder: String?)

data class Related_uris(val gatherer: String?, val tcgplayer_decks: String?, val edhrec: String?, val mtgtop8: String?)
