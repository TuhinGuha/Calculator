package com.example.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun calculatorUIPreview(){
    calculatorUI()
}


@Composable
fun calculatorUI(){
    var input1 by rememberSaveable { mutableStateOf(0.00) }
    var input2 by rememberSaveable { mutableStateOf(0.00) }
    var operation by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf(0.00) }

    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Spacer(modifier = Modifier.padding(16.dp))
        Row (horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){

            OutlinedTextField(value = input1.toString(),
                onValueChange = {input1=it.toDoubleOrNull() ?:0.00},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(.2f),
                label = {
                    Text(text = "First Input",
                        fontWeight = FontWeight.Bold)
                },
                colors =OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color(224,176,255),
                    unfocusedBorderColor = Color.Cyan,
                    unfocusedLabelColor = Color(224,176,255)
                )
            )

            Text(
                text = operation,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .width(4.dp),
                style = MaterialTheme.typography.headlineMedium,
                color = Color(224,176,255)
            )

            OutlinedTextField(value = input2.toString(),
                onValueChange = {input2=it.toDoubleOrNull() ?:0.00},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(.2f),
                label = {
                    Text(text = "Second Input",
                        fontWeight = FontWeight.Bold)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color(224,176,255),
                    unfocusedBorderColor = Color.Cyan,
                    unfocusedLabelColor = Color(224,176,255)
                )
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Row {
            Button(onClick = {
                operation="+"
                result=(input1+input2)
            },
                colors = ButtonDefaults.buttonColors(
                   containerColor = Color.Cyan
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp),
            ) {
                Icon(imageVector = Icons.Rounded.Add,
                    contentDescription ="",
                    tint = Color.White)
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Button(onClick = {
                operation="-"
                result=(input1-input2)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp)
            ) {
                Text(text = " - ",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium)
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Row {
            Button(onClick = {
                operation="x"
                result=(input1*input2)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp)
            ) {
                Icon(imageVector = Icons.Rounded.Clear,
                    contentDescription ="",
                    tint = Color.White)
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Button(onClick = {
                operation="/"
                result=(input1/input2)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp)
            ) {
                Text(text = " / ",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium)
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Result: ${result}",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(224,176,255)
        )
    }
}