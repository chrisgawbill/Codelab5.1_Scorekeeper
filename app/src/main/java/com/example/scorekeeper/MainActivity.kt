package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var mScore1:Int = 0
    var mScore2:Int = 0
    lateinit var mScoreText1:TextView
    lateinit var mScoreText2:TextView

    var STATE_SCORE_1:String = "Team 1 Score"
    var STATE_SCORE_2:String = "Team 2 Score"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)

        if(savedInstanceState != null){
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
        }
    }
    fun clickHandler(view: View){
        when(view.id){
            R.id.increaseTeam1 -> {
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            R.id.decreaseTeam1 -> {
                mScore1--
                mScoreText1.text = mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
            R.id.decreaseTeam2 ->{
                mScore2--
                mScoreText2.text = mScore2.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        var nightMode = AppCompatDelegate.getDefaultNightMode()
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.day_mode)
        }else{
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.night_mode){
            var nightMode = AppCompatDelegate.getDefaultNightMode()
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }
}