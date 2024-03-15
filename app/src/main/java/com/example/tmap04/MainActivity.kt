package com.example.tmap04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.tmap04.ui.theme.Tmap04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tmap04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GoToForm()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "destroyed")
    }
}

@Composable
fun GoToForm() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text (
            text = "Welcome!",
            style = TextStyle(fontSize = 12.em),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text (
            text = "Click 'Start' to enter your personal information",
            style = TextStyle(fontSize = 4.em),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = {
            val intent = Intent(context, FillFormActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Start")
        }
    }
}
