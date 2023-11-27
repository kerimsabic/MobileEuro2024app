package com.example.euro24application

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.euro24application.data.MyDatabase
import com.example.euro24application.ui.theme.Euro24ApplicationTheme
import com.example.euro24application.ui.theme.*


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(db: MyDatabase)
{
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController)},
    ) {
        NavGraph(navController = navController,db)
    }
}

@Composable
fun BottomBar(navController: NavController)
{
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Matches,
        BottomBarScreen.Groups,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    BottomAppBar(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)) {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
    ) {

    NavigationBarItem(
        label = {
            Text(
                text = screen.title,
                Modifier
                    .padding(bottom = 0.dp, top = 0.dp)
                    .height(20.dp),
                textAlign = TextAlign.Center,
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "NavigationIcon",
                Modifier.size(25.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Header1,
            selectedTextColor = Header1,
            indicatorColor = Gray2,
        )
    )
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Euro24ApplicationTheme {
        //MainScreen()
    }
}