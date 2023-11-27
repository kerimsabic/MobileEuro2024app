package com.example.euro24application



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.example.euro24application.data.User
import com.example.euro24application.data.UserDao
import com.example.euro24application.screens.Screen
import com.example.euro24application.ui.theme.Blue2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,

    scope: CoroutineScope,
    navController: NavController,
    userDao: UserDao,
) {



    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current


    Column (
        modifier
            .fillMaxSize()
            .background(color = Blue2),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.uefa_euro_2024_emblem),
            contentDescription = null,
            modifier = Modifier.height(100.dp)
        )
        Text(text = "EURO2024", fontSize = 30.sp, color = Color.White)
        Spacer(modifier = modifier.height(5.dp))
        Column (
            modifier
                .fillMaxWidth()
                .weight(2f)
                .background(color = Blue2),
                //.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .background(color = Blue2)
            ) {
                Text(
                    text = "Name:",
                    fontSize = 20.sp,

                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(5.dp),
                    color = Color.White
                )
                TextField(
                    value = name,
                    placeholder = { Text("Name Surname") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                        FocusDirection.Down)}),
                    singleLine = true,
                    onValueChange = {name = it},
                    modifier = modifier
                        .clip(RoundedCornerShape(20.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray,


                        )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = modifier.background(color= Blue2)
            ) {
                Text(
                    text = "Email:",
                    fontSize = 20.sp,

                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(5.dp),
                    color = Color.White
                )
                TextField(
                    value = email,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    placeholder = { Text("...@gmail.com") },
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)}),
                    singleLine = true,
                    onValueChange = {email = it},
                    modifier = modifier
                        .clip(RoundedCornerShape(20.dp))
                        .height(60.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        placeholderColor = Color.Gray
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = modifier.background(color= Blue2)
            ) {
                Text(
                    text = "Password:",
                    fontSize = 20.sp,

                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(5.dp),
                    color = Color.White
                )
                TextField(
                    value = password,
                    placeholder = { Text("Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onNext = { focusManager.clearFocus()}),
                    singleLine = true,
                    onValueChange = {password = it},
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = modifier
                        .clip(RoundedCornerShape(20.dp))
                        .height(55.dp)
                        .width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor =Color.Black,
                        placeholderColor = Color.Gray,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.width(800.dp),contentAlignment = Alignment.Center){
                Button(

                    onClick = {
                        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                            scope.launch {
                                val newUser = User(
                                    fullName = name,
                                    email = email,
                                    password = password
                                )
                                userDao.insert(newUser)

                            }
                            navController.navigate(Screen.LogInScreen.route)
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(20),
                ) {
                    Text("Register", fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
}