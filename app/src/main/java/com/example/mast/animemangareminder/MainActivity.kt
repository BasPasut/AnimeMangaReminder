package com.example.mast.animemangareminder

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mast.animemangareminder.Repository.OnlineAnimeRepo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , AnimeView {

    var presenter = AnimePresenter(this, OnlineAnimeRepo())
    var color = false

    override fun notifyAnime(text: String) {
        AlertDialog.Builder(this)
                .setTitle("New Update~!")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("ok", null).show()
        updateList_btn.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.start()
        switchColor(theme_btn)
    }

    fun switchColor(view : View) {
        val root = browserView.getRootView()
        if(color){
            root.setBackgroundColor(Color.BLACK)
            textview.setTextColor(Color.WHITE)
            theme_btn.setTextColor(Color.WHITE)
            theme_btn.setBackgroundColor(Color.DKGRAY)
            updateList_btn.setTextColor(Color.WHITE)
            updateList_btn.setBackgroundColor(Color.DKGRAY)
        }
        else{
            root.setBackgroundColor(Color.WHITE)
            textview.setTextColor(Color.BLACK)
            theme_btn.setTextColor(Color.BLACK)
            theme_btn.setBackgroundColor(Color.LTGRAY)
            updateList_btn.setTextColor(Color.BLACK)
            updateList_btn.setBackgroundColor(Color.LTGRAY)
        }
        color = !color
    }

    fun travel(view : View){
        var temp = ""
        when(view){
            browserView -> {
                temp = "http://www.orztoon.com"
            }
            browserView2 -> {
                temp = "http://www.mangasubthai.com/"
            }
        }
        var intent : Intent
        intent = Intent (Intent.ACTION_VIEW, Uri.parse(temp))
        startActivity(intent)
    }

    fun viewUpdates(view : View){
        val intent = Intent(this, Updates::class.java)
        intent.putExtra("theme",!color)
        startActivity(intent)
    }


}
