package com.example.grastany

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grastany.ui.theme.GraStanyTheme
import kotlin.random.Random

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
                    //Count()
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){

    var iloscskarbow by remember {
        mutableIntStateOf(0)
    }
    var kierunek by remember {
        mutableStateOf("Zachód")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Znaleziono skarbów: $iloscskarbow")
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Text("Kierunek: $kierunek")
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            kierunek = "Zachód"
            if (Random.nextBoolean()){
                iloscskarbow += 1
            }
        }) {
            Text(text = "Płyń za Zachód")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            kierunek = "Wschód"
            if (Random.nextBoolean()){
                iloscskarbow += 1
            }
        }) {
            Text(text = "Płyń za Wschód")
        }
        Button(onClick = {
            kierunek = "Północ"
            if (Random.nextBoolean()){
                iloscskarbow += 1
            }
        }) {
            Text(text = "Płyń za Północ")
        }
        Button(onClick = {
            kierunek = "Południe"
            if (Random.nextBoolean()){
                iloscskarbow += 1
            }
        }) {
            Text(text = "Płyń za Południe")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Aktualnie płyniesz w kierunku: $kierunek")
    }
}

@Composable
fun Count(){

    var clickCounter by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Amount of clicks $clickCounter")
        Button(onClick = {
            clickCounter += 1
            Log.i("click", "$clickCounter")
        }) {
            Text(text = "Click me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaptainGamePreview() {
    GraStanyTheme {
        CaptainGame()
    }
}