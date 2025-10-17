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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            text = "${texts[textIndex]} (Вы нажали $clickCount раз)",
            style = MaterialTheme.typography.headlineSmall
        )
        Button(
            onClick = {
                clickCount++
                textIndex = (textIndex + 1) % texts.size
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Поменять текст")
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
