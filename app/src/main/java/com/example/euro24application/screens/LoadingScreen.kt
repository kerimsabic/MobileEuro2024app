package com.example.euro24application.screens


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.euro24application.R
import kotlinx.coroutines.delay
import com.example.euro24application.ui.theme.*


@Composable
fun AnimatedLoadingScreen(navController: NavHostController)
{
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(3000)
    )

    //Navigate to home screen after delay
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000L)
        navController.navigate(Screen.MainScreen.route)
    }
    LoadingScreen(alpha = alphaAnim.value)
}



@Composable
fun LoadingScreen(alpha: Float)
{
    val imageLogo = painterResource(R.drawable.uefa_euro_2024_emblem)
    val imageText = painterResource(R.drawable.euro2024_text)



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Blue2),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Image(
            painter = imageLogo,
            contentDescription = null,
            modifier = Modifier
                .width(350.dp)
                .height(150.dp)
                .padding(0.dp)
                .alpha(alpha = alpha)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = imageText,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .width(250.dp)
                .height(150.dp)
                .padding(0.dp)
                .alpha(alpha = alpha)
        )
    }
}