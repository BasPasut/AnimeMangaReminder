package com.example.mast.animemangareminder

import android.os.AsyncTask
import android.os.Environment
import com.example.mast.animemangareminder.Repository.Anime
import com.example.mast.animemangareminder.Repository.AnimeRepo
import com.example.mast.animemangareminder.Repository.OnlineAnimeRepo
import org.json.JSONArray
import java.io.File
import java.io.InputStream
import java.io.PrintWriter
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

class AnimePresenter (val view : AnimeView, val repo : AnimeRepo) : Observer {

    var animes = ArrayList<Anime>()
    var oldSave = ArrayList<Anime>()

    fun start(){
        repo.addObserver(this)
        repo.loadAllAnime()
    }

    override fun update(o: Observable?, arg: Any?) {
        if(o is AnimeRepo) {
            animes.addAll((o as AnimeRepo).getAnime())
            view.notifyAnime(this.toString())
        }
    }

    override fun toString(): String {
        var temp: String = "Anime update list:\n"
        var i = 0;
        for(anime in animes){
            if(anime.type.equals("anime")){
                temp += (++i).toString() + ". " + anime.title +" is at ep."+ anime.current_ep + "\n"
            }
        }
        temp += "\nManga update list:\n"
        i = 0;
        for(anime in animes){
            if(anime.type.equals("manga")){
                temp += (++i).toString() + ". " + anime.title +" is at ep."+ anime.current_ep + "\n"
            }
        }
        return temp
    }

    fun getAnime(): ArrayList<Anime>{
        return animes
    }

}