package com.example.spendmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spendmanager.ui.theme.SpendManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpendManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpendManager()
                }
            }
        }
    }
}

@Composable
fun SpendManager() {
    var sum by remember {
        mutableDoubleStateOf(0.00)
    }
    var item by remember {
        mutableStateOf("")
    }

    fun sumUpPlus() : Double{
        sum += item.toDouble()
        item = ""
        return sum
    }

    fun sumUpMinus() : Double {
        if (sum > 0.00) {
            sum -= item.toDouble()
        }
        if (sum < 0.00){
            sum = 0.00
        }
        item = ""
        return sum
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Spend Manager")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = item, onValueChange = { item = it})

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = {sumUpPlus()}) {
                Text(text = "Dodaj do sumy")
                Icon(imageVector = Icons.Default.Done, contentDescription = "plus")
            }

            Button(onClick = {sumUpMinus()}) {
                Text(text = "Odejmij od sumy")
                Icon(imageVector = Icons.Default.Close, contentDescription = "Minus")
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Łączna suma: ")

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "$sum zł")
    }
}

@Preview(showBackground = true)
@Composable
fun SpendManagerPreview() {
    SpendManagerTheme {
        SpendManager()
    }
}