package com.example.scoresheetandroidapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.scoresheetandroidapp.ui.theme.ScoreManager

@Composable
fun ScoreTracker(context: Context) {
    Column {
        repeat(6) { index ->
            PlayerScore(index + 1, context)
        }
    }
}

@Composable
fun PlayerScore(playerNumber: Int, context: Context) {
    var score by remember { mutableIntStateOf(ScoreManager.getScoreForPlayer(playerNumber, context)) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Text("Player $playerNumber", modifier = Modifier.width(100.dp))
        TextField(
            value = score.toString(),
            onValueChange = { newScore ->
                val updatedScore = newScore.toIntOrNull() ?: 0
                score = updatedScore
                ScoreManager.saveScoreForPlayer(playerNumber, updatedScore, context)
            },
            label = { Text("Score") },
            modifier = Modifier.padding(8.dp)
        )
    }
}
