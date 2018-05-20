package com.example.mast.animemangareminder.Repository

import java.util.*

abstract class AnimeRepo : Observable(){

    abstract fun loadAllAnime()
    abstract fun getAnime(): ArrayList<Anime>

}