package com.example.euro24application.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.euro24application.model.Resources
import com.example.euro24application.ui.theme.Background
import com.example.euro24application.ui.theme.*



@Composable
fun DetailedPlayer(navController: NavController,selectedPlayer: Resources)
{
    Column(
        modifier = Modifier
            .background(color = Background)
            .fillMaxSize()
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(color = Background),
        ) {
            Surface(modifier = Modifier.fillMaxWidth(), color = Header1){
                Row(modifier = Modifier
                    .fillMaxHeight()
                    .padding(20.dp),
                    //horizontalArrangement = Arrangement.Center
                ) {
                    val borderWidth = 1.dp
                    Image(
                        painter = painterResource(id = selectedPlayer.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.CenterVertically)
                            .border(
                                BorderStroke(borderWidth, Color.White),
                                CircleShape
                            )
                            .clip(CircleShape)

                    )
                    Spacer(modifier = Modifier.width(10.dp))

                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(color = Color.White)
        ){}
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = selectedPlayer.name),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 40.sp,
                modifier = Modifier
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = selectedPlayer.imageInfo), contentDescription = null, modifier = Modifier
                    .size(400.dp)
                    .padding(10.dp))
        }
        Row(modifier=Modifier.padding(10.dp)) {
            Button(
                onClick = { navController.navigate(Screen.PlayersScreen.route) },
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Text(text = "Back")
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))

}