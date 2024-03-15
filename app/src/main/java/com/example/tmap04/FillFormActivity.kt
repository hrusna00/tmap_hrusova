package com.example.tmap04

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.tmap04.ui.theme.Tmap04Theme
import java.util.Calendar

class FillFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tmap04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FillData();
                }
            }
        }
    }
}

@Preview
@Composable
fun FillData() {
    val context = LocalContext.current
    var personName by remember { mutableStateOf(TextFieldValue()) }
    var personDateOfBirth by remember  { mutableStateOf(TextFieldValue()) }
    var consent by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = personName,
            onValueChange = { personName = it },
            label = { Text("Name") },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = personDateOfBirth,
            onValueChange = { personDateOfBirth = it},
            label = { Text("Date of birth") },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = consent,
                onCheckedChange = { consent = it },
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(
                text = "Agree to terms",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 12.dp)
            )
        }
        Button(
            onClick = {
                val intent = Intent(context, DisplayInfoActivity::class.java).apply {
                    putExtra("personName", personName.text)
                    putExtra("personDateOfBirth", personDateOfBirth.text)
                }
                context.startActivity(intent)
            },
            enabled = consent
        ) {
            Text("Submit")
        }
    }
}