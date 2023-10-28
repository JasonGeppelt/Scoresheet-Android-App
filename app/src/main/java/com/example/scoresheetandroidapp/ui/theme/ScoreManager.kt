package com.example.scoresheetandroidapp.ui.theme

import android.content.Context

object ScoreManager {
    private const val SCORE_PREFS_NAME = "ScorePrefs"

    fun saveScoreForPlayer(playerNumber: Int, score: Int, context: Context) {
        val prefs = context.getSharedPreferences(SCORE_PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt("player$playerNumber", score)
        editor.apply()
    }

    fun getScoreForPlayer(playerNumber: Int, context: Context): Int {
        val prefs = context.getSharedPreferences(SCORE_PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getInt("player$playerNumber", 0)
    }
}
