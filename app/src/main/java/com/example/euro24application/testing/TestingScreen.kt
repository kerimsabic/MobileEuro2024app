package com.example.euro24application.testing

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*


@Composable
fun TestingScreen()
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray),

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.Blue)
        ){
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                .height(50.dp)
                .width(200.dp)
                .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
            ){
                Text(
                    text = "Effozza",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier
                        .width(100.dp)
                )
            }

        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.Blue)
        ){
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp)
                    .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
            ){
                Text(
                    text = "Efa",
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .width(100.dp)
                        .height(50.dp)

                )
            }

        }
    }

}


@Preview
@Composable
fun PreviewTestingScreen() {
    TestingScreen()
}