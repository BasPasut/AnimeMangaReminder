package com.example.mast.animemangareminder.Repository

import android.os.AsyncTask
import org.json.JSONArray
import java.net.URL
import java.util.ArrayList

class OnlineAnimeRepo : AnimeRepo() {

    val animeList = ArrayList<Anime>()

    override fun loadAllAnime() {

        object : AsyncTask<String, Void, String>(){

            override fun doInBackground(vararg params: String?): String {
                var json = URL("http://www.printmov.com/THAL/anime.json").readText()
                return json
            }

            override fun onPostExecute(result: String) {
                val jsonObj = JSONArray(result.substring(result.indexOf("["), result.lastIndexOf("]") + 1))
                for (i in 0..jsonObj!!.length() - 1) {
                    val currentJson = jsonObj.getJSONObject(i)
                    val artist = Anime(currentJson.getInt("id")
                            , currentJson.getString("title")
                            , currentJson.getString("URL")
                            , currentJson.getString("description")
                            , currentJson.getInt("current_ep")
                            , currentJson.getString("image_url")
                            , currentJson.getString("type"))
                    getAnime().add(artist)
                }
                setChanged()
                notifyObservers()
            }

        }.execute()

    }

    override fun getAnime(): ArrayList<Anime> {
        return animeList
    }

}