package com.example.euro24application.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.euro24application.R
import com.example.euro24application.model.Team
import com.example.euro24application.ui.theme.*

@Composable
fun GroupsScreen(navController: NavController)
{
    val teams = remember {
        listOf(
            Team(1,"Bosnia and Hercegovina",2,10,6,R.drawable.bih),
            Team(2,"Portugal",2,2,4,R.drawable.por),
            Team(3,"Luxemburg",2,1, 3,R.drawable.lux),
            Team(4,"Icleand",2,4,3,R.drawable.isl),
            Team(5,"Slovakia",2,-6,1,R.drawable.svk),
            Team(6,"Lichtenshein",2,-11,0,R.drawable.lie),
        )
    }
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
                .height(100.dp)
        ){}
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(20.dp)
        ) {
            Card(shape = RectangleShape) {
                Row(
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Qualification Group J",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        fontSize = 18.sp,
                    )
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,) {

                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "P",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "GD",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "PTS",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,

                            )
                    }}
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(teams) { team ->
                    TeamItem(team = team, navController)
                }
            }

        }

    }
    Header(title = "Groups")
}
@Composable
fun TeamItem(team: Team, navController: NavController) {
    Card(
        shape = RectangleShape,
        modifier = Modifier.clickable {
            //Save info
            //navController.currentBackStackEntry?.savedStateHandle?.set("player", player)
            navController.navigate(Screen.PlayersScreen.route)
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Column() {
            Text(
                text = team.position.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(20.dp))
            }
            Column() {
                val borderWidth = 1.dp
                Image(
                    painter = painterResource(id = team.flag),
                    contentDescription = null ,
                    modifier = Modifier
                        .size(40.dp)
                        .border(
                            BorderStroke(borderWidth, Color.White),
                            CircleShape
                        )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier.width(180.dp).height(20.dp)
            ){
                Text(
                    text = team.name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = team.played.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(8.dp),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = team.goalDif.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = team.points.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(8.dp),
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(1.dp))
}

@Preview(showBackground = true)
@Composable
fun GroupsPreview() {
    //GroupsScreen()
}

