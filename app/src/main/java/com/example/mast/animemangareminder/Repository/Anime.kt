package com.example.mast.animemangareminder.Repository

class Anime (val id: Int,
              val title: String = "",
              val url: String = "",
              val description: String = "",
              val current_ep: Int = 0,
              val image_url: String = "",
              val type: String = "") {

    override fun toString(): String {
        return title
    }

}