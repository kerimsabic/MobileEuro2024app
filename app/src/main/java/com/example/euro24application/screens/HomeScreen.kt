package com.example.euro24application.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.euro24application.R
import com.example.euro24application.ui.theme.*


@Composable
fun Header(title: String)
{
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Surface(modifier = Modifier.fillMaxSize(), color = Header1){
                Text(
                    text = title,
                    fontSize = 40.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
                        .align(alignment = Alignment.CenterVertically)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(color = Color.White)
        ){}
    }
}


@Composable
fun HomeScreen()
{
    val images = listOf(
        painterResource(R.drawable.home_firstimage),
        painterResource(R.drawable.home_image01),
        painterResource(R.drawable.home_image02),
        painterResource(R.drawable.home_image03),
        painterResource(R.drawable.home_image04),
        painterResource(R.drawable.euro2024_text),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(0.dp)
            .background(color = Background)
    )  {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
        ){}
        Text(
            text = stringResource(id = R.string.home_title),
            fontSize = 30.sp,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 0.dp)
        )
        Text(
            text = stringResource(id = R.string.home_time),
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 0.dp)
        )
        Image(
            painter = images[4],
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        Text(
            text = "Where will Euro 2024 be held?",
            fontSize = 20.sp,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.home_text1),
            fontSize = 15.sp,
            lineHeight = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(
            text = "What are the Euro 2024 host cities?",
            fontSize = 20.sp,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Image(
            painter = images[1],
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.home_text2),
            fontSize = 15.sp,
            lineHeight = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(
            text = "Where and when will the final of UEFA EURO 2024 be played?",
            fontSize = 20.sp,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.home_text3),
            fontSize = 15.sp,
            lineHeight = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(
            text = "What is the qualifying format?",
            fontSize = 20.sp,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.home_text4),
            fontSize = 15.sp,
            lineHeight = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Image(
            painter = images[3],
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ){}
    }
    Header("Home")
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Euro24ApplicationTheme {
        HomeScreen()
    }
}