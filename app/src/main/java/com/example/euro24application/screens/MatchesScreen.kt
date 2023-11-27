package com.example.euro24application.screens


import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.euro24application.R
import com.example.euro24application.ui.theme.*

@Composable
fun MatchesScreen()
{

    Column(//Background
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Background)
    )  {
        //Spacer behind header
        Spacer(modifier = Modifier.height(95.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(800.dp)
                .padding(20.dp)
                .background(color = Gray4, shape = RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MatchRow("Bosnia & Herzegovina", R.drawable.bih, "3 : 0", R.drawable.isl, "Iceland")
            MatchRow("Slovakia", R.drawable.svk, "2 : 0", R.drawable.bih, "Bosnia & Herzegovina")
            MatchRow("Portugal", R.drawable.por, "17.06.23", R.drawable.bih, "Bosnia & Herzegovina")
            MatchRow("Bosnia & Herzegovina", R.drawable.bih, "20.06.23", R.drawable.lux, "Luxembourg")
            MatchRow("Iceland", R.drawable.isl, "20.06.23", R.drawable.bih, "Bosnia & Herzegovina")
            MatchRow("Lichtenstein", R.drawable.lie, "11.09.23", R.drawable.bih, "Bosnia & Herzegovina")
            MatchRow("Iceland", R.drawable.isl, "13.10.23", R.drawable.bih, "Bosnia & Herzegovina")
            MatchRow("Bosnia & Herzegovina", R.drawable.bih, "16.10.23", R.drawable.lux, "Portugal")

        }
    }
    Header(title = "Matches")
}

@Composable
fun MatchRow(homeTeamName: String, @DrawableRes homeTeamImage: Int, score: String, @DrawableRes awayTeamImage: Int, awayTeamName: String)
{
    Row(
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.LightGray)
            .border(1.dp,color=Color.Gray),
        //.background(Color.White, shape = RoundedCornerShape(20.dp)),
        //horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        //Spacer(modifier = Modifier.width(10.dp))
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
            .weight(1f)){
                Text(text = homeTeamName,fontSize = 11.sp,color = Color.Black, textAlign = TextAlign.End)
            }
        val borderWidth = 1.dp
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f))
        {
            Image(
                painter = painterResource(homeTeamImage),
                contentDescription = null,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .border(
                        BorderStroke(borderWidth, Color.White),
                        CircleShape
                    )
                    .clip(CircleShape)
            ) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
            .weight(1f))
            {
                Text(text = score, fontSize = 15.sp,color = Color.Black, modifier = Modifier
            ) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
            .weight(1f)) {
            Image(
                painter = painterResource(awayTeamImage),
                contentDescription = null,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .border(
                        BorderStroke(borderWidth, Color.White),
                        CircleShape
                    )
                    .clip(CircleShape)
            )}
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
            .weight(1f)
        )
        {
            Text(text = awayTeamName,fontSize = 11.sp,color = Color.Black, textAlign = TextAlign.Start)
        }}
}

@Preview(showBackground = true)
@Composable
fun MatchesScreenPreview() {
    Euro24ApplicationTheme {
        MatchesScreen()
    }
}
