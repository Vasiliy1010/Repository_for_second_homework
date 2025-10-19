package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextSwitcherApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TextSwitcherApp(modifier: Modifier = Modifier) {
    val texts = listOf("Иван", "Петр", "Сергей")
    var textIndex by remember { mutableStateOf(0) }
    var clickCount by remember { mutableStateOf(0) }


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Меняющийся текст: ${texts[textIndex]}",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "(Вы нажали $clickCount раз)",
            color = Color.Red,
            style = MaterialTheme.typography.headlineMedium
        )
        Button(
            onClick = {
                clickCount++
                textIndex = (textIndex + 1) % texts.size
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Нажмите, чтобы поменять текст")
        }
        Button(
            onClick = {
                clickCount = 0
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Нажмите, чтобы cбросить число нажатий")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextSwitcherPreview() {
    MyApplicationTheme {
        TextSwitcherApp()
    }
}
