package com.example.tmap04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.tmap04.ui.theme.Tmap04Theme

class DisplayInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val personName = intent.getStringExtra("personName") ?: ""
        val personDateOfBirth = intent.getStringExtra("personDateOfBirth") ?: ""

        setContent {
            Tmap04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayInfo(personName, personDateOfBirth)
                }
            }
        }
    }
}

@Composable
fun DisplayInfo(personName: String, personDateOfBirth: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Person Name: $personName",
            style = TextStyle(fontSize = 5.em),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Date of birth: $personDateOfBirth",
            style = TextStyle(fontSize = 5.em),
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun DisplayInfoPreview() {
    DisplayInfo("Natalie Hrusova", "2001-12-29")
}
