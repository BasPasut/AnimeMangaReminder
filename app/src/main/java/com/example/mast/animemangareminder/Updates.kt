package com.example.mast.animemangareminder

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.text.method.MovementMethod
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_updates.*
import android.text.method.ScrollingMovementMethod
import android.view.View
import com.example.mast.animemangareminder.Repository.AnimeRepo
import com.example.mast.animemangareminder.Repository.OnlineAnimeRepo
import kotlinx.android.synthetic.main.activity_main.*


class Updates : AppCompatActivity() , AnimeView {

    var presenter = AnimePresenter(this, OnlineAnimeRepo())

    override fun notifyAnime(text: String) {
        update_text.setText(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updates)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        presenter.start()
        update_text.movementMethod = ScrollingMovementMethod()
        checkColor()
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    fun checkColor() {
        var color = intent.getBooleanExtra("theme",false)
        val root = update_text.getRootView()
        if(color){
            root.setBackgroundColor(Color.BLACK)
            update_text.setTextColor(Color.WHITE)
        }
        else{
            root.setBackgroundColor(Color.WHITE)
            update_text.setTextColor(Color.BLACK)
        }
        color = !color
    }
}
