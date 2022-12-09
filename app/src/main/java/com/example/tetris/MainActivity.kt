package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.example.tetris.storage.AppPreferences

class MainActivity : AppCompatActivity() {

    var tvHighScore: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById<TextView>(R.id.tv_hing_score)

        btnNewGame.setOnClickListener(this::onBtnNewGameClick)

    }
    private fun onBtnNewGameClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
    private fun onBtnResetScoreClick(view:View){
        val preferences = AppPreferences(this)
        preferences.clearHingScore()
        Snackbar.make(view, "Score successfully reset", Snackbar.LENGTH_SHORT)
            .show()
        tvHighScore?.text = "Hing score: ${preferences.getHingScore()}"

    }

    private fun onBtnExitClick(view: View){
        System.exit(0)
    }
}