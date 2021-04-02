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

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.SolidButton
import com.example.androiddevchallenge.logonScreenRoute
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.clear
import com.example.androiddevchallenge.ui.theme.yellow

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.welcome_bg),
        modifier = Modifier.fillMaxSize(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize(),
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

        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                .height(48.dp)
                .constrainAs(buttons) {
                    bottom.linkTo(parent.bottom)
                }
        ) {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                val context = LocalContext.current
                SolidButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    text = "GET STARTED",
                    onClick = { /*TODO*/ }
                )
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    border = BorderStroke(width = 2.dp, color = yellow),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = clear,
                        contentColor = yellow
                    ),
                    onClick = { navController.navigate(logonScreenRoute) }
                ) {
                    Text(text = "LOG IN", style = MaterialTheme.typography.button, color = yellow)
                }
            }
        }
    }
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
