package com.example.euro24application


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.euro24application.data.MyDatabase
import com.example.euro24application.screens.AnimatedLoadingScreen
import com.example.euro24application.screens.Screen
import com.example.euro24application.ui.theme.Euro24ApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = MyDatabase.getInstance(this)
        setContent {
            Euro24ApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}


@Composable
fun Navigation()
{
    val db = MyDatabase.getInstance(LocalContext.current)
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoadingScreen.route
    ){
        composable("loading_screen"){
            AnimatedLoadingScreen(navController)
        }
        composable("main_screen"){
            MainScreen(db)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val db = MyDatabase.getInstance(LocalContext.current)
    Euro24ApplicationTheme {
        //MainScreen()
    }
}