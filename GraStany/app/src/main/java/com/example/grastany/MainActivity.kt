package com.example.grastany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.grastany.ui.theme.GraStanyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraStanyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    licz()
                }
            }
        }
    }
}

@Composable
fun licz(){

    var liczba_klikniec = 0

    Column {
        Text(text = "liczba kliknieć $liczba_klikniec")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "kliknij mnie")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraStanyTheme {

    }
}