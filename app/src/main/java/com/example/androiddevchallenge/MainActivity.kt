/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.clear
import com.example.androiddevchallenge.ui.theme.gray700
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.yellow

// TODO
// Button color
// TextField Styling
// Dark Light mode
// Compose navigation for onClick of button
// ....

const val logonScreenRoute = "logonScreenRoute"
const val welcomeScreenRoute = "welcomeScreenRoute"
const val homeScreenRoute = "homeScreenRoute"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = welcomeScreenRoute) {
            composable(welcomeScreenRoute) {
                WelcomeScreen(navController = navController)
            }
            composable(logonScreenRoute) {
                LogonScreen(navController = navController)
            }
            composable(homeScreenRoute) {
                HomeScreen(navController = navController)
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        painter = painterResource(id = R.drawable.welcome_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        val (logo, buttons) = createRefs()

        Image(
            modifier = Modifier.constrainAs(logo) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "We Trade Logo"
        )

        Box(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
            .height(48.dp)
            .constrainAs(buttons) {
                bottom.linkTo(parent.bottom)
            }) {

            Row() {
                val context = LocalContext.current
                Button(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(end = 4.dp),
                    shape = RoundedCornerShape(50),
                    onClick = { Toast.makeText(context,"Get Started button not implemented",Toast.LENGTH_SHORT).show() }) {
                        Text(text = "GET STARTED", style = MaterialTheme.typography.button)
                }
                // TODO change button outline to yellow, need to find how to
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(start = 4.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = clear, contentColor = yellow),
                    onClick = { navController.navigate(logonScreenRoute) }) {
                        Text(text = "LOG IN", style = MaterialTheme.typography.button, color = yellow)
                }
            }
        }
    }
}

@Composable
fun LogonScreen(navController: NavHostController) {
    Column (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
        Box {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            Text(
                modifier = Modifier
                    .padding(top = 152.dp)
                    .fillMaxWidth(),
                text = "Welcome back",
                color = Color.White,
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "",
                placeholder = { Text(text = "Email Address") },
                leadingIcon = { Icon(Icons.Outlined.Email, "") },
                onValueChange = { /*TODO*/ })
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "",
                placeholder = { Text(text = "Email Address") },
                leadingIcon = { Icon(Icons.Outlined.Password, "") },
                onValueChange = { /*TODO*/ })
            Button(modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(50),
                onClick = {
                    navController.navigate(homeScreenRoute)
                }) {
                Text(
                    text = "Log In",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        content = {
            Text("BodyContent")
        },
        bottomBar = {
            BottomAppBar(backgroundColor = if (isSystemInDarkTheme()) gray700 else Color.White) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Positions",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface,
                )
            }
        }
    )
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenLightPreview() {
    MyTheme {
        WelcomeScreen(rememberNavController())
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(rememberNavController())
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LogonScreenLightPreview() {
    MyTheme {
        LogonScreen(rememberNavController())
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LogonScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        LogonScreen(rememberNavController())
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview() {
    MyTheme {
        HomeScreen(rememberNavController())
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen(rememberNavController())
    }
}

//@Preview("Light Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun LightPreview() {
//    MyTheme {
//        MyApp()
//    }
//}
//
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}
