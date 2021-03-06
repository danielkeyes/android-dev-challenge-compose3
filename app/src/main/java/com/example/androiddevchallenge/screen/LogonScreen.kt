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
package com.example.androiddevchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.SolidButton
import com.example.androiddevchallenge.homeScreenRoute
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LogonScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
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
                onValueChange = { /*TODO*/ }
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "",
                placeholder = { Text(text = "Email Address") },
                leadingIcon = { Icon(Icons.Outlined.Password, "") },
                onValueChange = { /*TODO*/ }
            )
            SolidButton(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                text = "Log In",
                onClick = {
                    navController.navigate(homeScreenRoute)
                }
            )
        }
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
