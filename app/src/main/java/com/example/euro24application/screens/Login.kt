package com.example.euro24application.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.euro24application.CurrentUser
import com.example.euro24application.R
import com.example.euro24application.data.UserDao
import com.example.euro24application.ui.theme.Blue2

import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    userDao: UserDao,
    scope: CoroutineScope
) {


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    var noUser by remember { mutableStateOf(false) }


    Column(
        modifier
            .fillMaxSize()
            .background(Blue2),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.uefa_euro_2024_emblem),
            contentDescription =null,
            modifier = Modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = "Welcome to EURO24", fontSize = 25.sp, color = Color.White)
        Column (
            modifier
                .fillMaxWidth()
                .weight(2f)
                .background(color = Blue2),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (noUser) {
                Text(text = "User doesn't exist", fontSize = 15.sp, color = Color(0xFFCD0000))
            }
            Spacer(modifier = modifier.height(35.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier.background(color = Blue2)
            ) {
                Text(
                    text = "Email:",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(5.dp).background(color = Blue2)
                )
                TextField(
                    value = email,
                    placeholder = { Text("...@gmail.com") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(
                            FocusDirection.Down
                        )
                    }),
                    singleLine = true,
                    onValueChange = { email = it },
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray,
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier.background(color = Blue2)
            ) {
                Text(
                    text = "Password:",
                    fontSize = 15.sp,

                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(5.dp).background(color = Blue2)
                )
                TextField(
                    value = password,
                    placeholder = { Text("Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.clearFocus() }),
                    singleLine = true,
                    onValueChange = { password = it },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray,
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.background(color = Blue2).fillMaxWidth()
            ) {
                Box(modifier = Modifier.width(800.dp),contentAlignment = Alignment.Center) {
                    Button(
                        onClick = {
                            if (email.isNotEmpty() && password.isNotEmpty()) {
                                scope.launch {
                                    CurrentUser.instance =
                                        userDao.getUserByCredentials(email = email, password = password)
                                }
                                if (CurrentUser.instance == null) {
                                    noUser = true
                                }
                                if (CurrentUser.instance != null) {
                                    noUser = false

                                }
                                if(noUser == false){
                                    navController.navigate(Screen.MainScreen.route)
                                }

                            }
                        },
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                    ) {
                        Text("Log in", fontSize = 20.sp, color = Color.White)
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                Box(modifier = Modifier.width(800.dp),contentAlignment = Alignment.Center) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.RegisterScreen.route)
                        },
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),


                    ) {
                        Text("Sign Up", fontSize = 20.sp, color = Color.White)
                    }
                }
            }
        }
    }

}