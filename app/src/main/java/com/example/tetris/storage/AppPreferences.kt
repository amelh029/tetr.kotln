package com.example.tetris.storage

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(ctx: Context){

    var data: SharedPreferences = ctx.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    fun saveHingScore(hingScore:Int){
        data.edit().putInt("HING_SCORE", 0).apply()
    }
    fun getHingScore():Int{
        return data.getInt("HING_SCORE", 0)
    }
    fun clearHingScore(){
        data.edit().putInt("HING_SCORE", 0).apply()
    }

}