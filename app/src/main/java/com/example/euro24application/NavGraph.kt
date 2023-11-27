package com.example.euro24application

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.euro24application.data.MyDatabase
import com.example.euro24application.model.Datasource
import com.example.euro24application.model.Resources
import com.example.euro24application.screens.*
import com.example.euro24application.screens.LoginScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

//Rename to NavGraph
@Composable
fun NavGraph(navController: NavHostController, db: MyDatabase)
{
    val myScope = CoroutineScope(Dispatchers.Default)
    val userDao = db.userDao()

    val playersList = remember { Datasource().loadResource() }

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route)
    {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Matches.route){
            MatchesScreen()
        }
        composable(route = BottomBarScreen.Groups.route){
            GroupsScreen(navController)
        }
        composable(route = Screen.PlayersScreen.route ){
            PlayersScreen(playersList = Datasource().loadResource(), navController)
        }
        composable(route = Screen.MainScreen.route ){
            HomeScreen()
        }
        composable(route = Screen.RegisterScreen.route ){
            RegisterScreen(navController = navController, userDao = userDao, scope = myScope)
        }

        composable(route = BottomBarScreen.Profile.route ){
            LoginScreen(navController = navController, userDao = userDao, scope = myScope)
        }
        composable(route = Screen.LogInScreen.route ){
            LoginScreen(navController = navController, userDao = userDao, scope = myScope)
        }


        playersList.forEach { resources ->
            composable(route = Screen.PlayerDetailsScreen.route) {
                val player = navController.previousBackStackEntry?.savedStateHandle?.get<Resources>("player")
                player?.let{
                    DetailedPlayer(navController = navController, selectedPlayer = player)
                }
            }
        }
    }
}