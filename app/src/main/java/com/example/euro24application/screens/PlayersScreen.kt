package com.example.euro24application.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.euro24application.model.Resources
import com.example.euro24application.ui.theme.Euro24ApplicationTheme
import com.example.euro24application.ui.theme.*



@Composable
fun PlayersScreen(playersList:List<Resources>, navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Background),
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Canvas(modifier = Modifier.fillMaxSize()){
            val height = size.height / 10F
            drawRoundRect(
                color = Color.White,
                topLeft = Offset(x = 0F, y = height-20f),
                size = Size(size.width, size.height / 20f),
                cornerRadius = CornerRadius(30F)
            )
            drawRect(
                color = Header1,
                size = Size(size.width, height)
            )
        }
    }
    Box{
        Text(
            text = "Players",
            fontSize = 35.sp,
            color = Color.White,
            modifier = modifier
                .padding(top = 20.dp, start = 20.dp)
        )
    }
    LazyColumn(modifier = Modifier
        .background(Color.Black)
        .padding(top = 95.dp, bottom = 80.dp)){

        val grouped = playersList.groupBy { it.teamId == 1 }


            items(playersList) { player ->
                PlayerCard(player = player, navController = navController)
            }


        /*grouped.forEach { initial, playersList ->
            items(playersList, key = {item -> item.teamId}) { player ->
                PlayerCard(player = player, navController = navController)
            }
        }*/


    }
    Header(title = "Players")
}

@Composable
fun PlayerCard(player: Resources, navController: NavController) {

    Box(modifier=Modifier.clickable {
        //Save info
        navController.currentBackStackEntry?.savedStateHandle?.set("player", player)
        navController.navigate(Screen.PlayerDetailsScreen.route)
    }
    ) {
        Card(shape = RectangleShape, modifier = Modifier.border(1.dp, color = Gray4)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
                    .background(color = Gray4)
            ) {
                val borderWidth = 2.dp
                Image(
                    painter = painterResource(id = player.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .border(
                            BorderStroke(borderWidth, Color.White),
                            CircleShape
                        )
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(
                        text = stringResource(id = player.name),
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PlayersPreview() {
    Euro24ApplicationTheme {
        //MainScreen()
    }
}