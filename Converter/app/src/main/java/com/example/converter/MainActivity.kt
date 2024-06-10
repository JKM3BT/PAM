package com.example.converter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.converter.ui.theme.ConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter("Android")
                }
            }
        }
    }
}

@Composable
fun UnitConverter(name: String, modifier: Modifier = Modifier) {

    val cent = "Centimeters"
    val inches = "Inches"
    val foots = "Foots"

    val conversionFactors = mapOf(
        Pair(cent, inches) to 0.393701,
        Pair(inches, cent) to 2.54,
        Pair(foots, inches) to 12.00,
        Pair(foots, cent) to 30.48,
        Pair(cent, foots) to 0.0328084,
        Pair(inches, foots) to 0.0833333
    )

    var inputUnit by remember { mutableStateOf(cent)}
    var outputUnit by remember { mutableStateOf(cent)}
    var inExpended by remember { mutableStateOf(false)}
    var outExpended by remember { mutableStateOf(false)}

    var inputNumber by remember {
        mutableStateOf("")
    }
    var result by remember {mutableStateOf("0")}

    fun convertUnits(){
        val inputNumberDouble = inputNumber.toDoubleOrNull()?:0.0
        val key = Pair(inputUnit,outputUnit)
        val factor: Double = conversionFactors[key] ?: 1.0
        val resultDouble = inputNumberDouble * factor
        result = resultDouble.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = inputNumber, onValueChange = {inputNumber=it;convertUnits()})

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Box {
                Button(onClick = {inExpended=true}) {
                    Text(text = inputUnit)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "arrow")
                }
                DropdownMenu(expanded = inExpended, onDismissRequest = {inExpended=false}) {
                    DropdownMenuItem(text = { Text(cent)},
                        onClick = {
                            inputUnit=cent
                            inExpended=false
                            convertUnits()
                        })
                    DropdownMenuItem(text = {Text(inches)},
                        onClick = {
                            inputUnit=inches
                            inExpended=false
                            convertUnits()
                        })
                    DropdownMenuItem(text = {Text(foots)},
                        onClick = {
                            inputUnit=foots
                            inExpended=false
                            convertUnits()
                        })
                }
            }

                Spacer(modifier = Modifier.height(15.dp))

            Box {
                Button(onClick = {outExpended=true}) {
                    Text(text = outputUnit)
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "arrow"
                    )
                }
                DropdownMenu(expanded = outExpended, onDismissRequest = {outExpended=false}) {
                    DropdownMenuItem(text = { Text(cent)},
                        onClick = {
                            outputUnit=cent
                            outExpended=false
                            convertUnits()
                        })
                    DropdownMenuItem(text = {Text(inches)},
                        onClick = {
                            outputUnit=inches
                            outExpended=false
                            convertUnits()
                        })
                    DropdownMenuItem(text = {Text(foots)},
                        onClick = {
                            outputUnit=foots
                            outExpended=false
                            convertUnits()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Result: $result")
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConverterTheme {
        UnitConverter("Android")
    }
}