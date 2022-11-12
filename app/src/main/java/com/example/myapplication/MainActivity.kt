package com.example.myapplication

// Kotlin Imports
import  java.util.Timer

// Android Imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                // Simple Comment Change
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Vert()
                }
            }
        }
    }
}

@Composable
fun Vert(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Settings")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Schedule")
        }
        
    }
}


@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Vert()
    }
}