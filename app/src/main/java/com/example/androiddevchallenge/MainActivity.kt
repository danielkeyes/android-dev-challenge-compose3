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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screen.HomeScreen
import com.example.androiddevchallenge.screen.LogonScreen
import com.example.androiddevchallenge.screen.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

const val logonScreenRoute = "logonScreenRoute"
const val welcomeScreenRoute = "welcomeScreenRoute"
const val homeScreenRoute = "homeScreenRoute"

class MainActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
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
@ExperimentalMaterialApi
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.surface) {
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

@ExperimentalMaterialApi
@Preview
@Composable
fun MyAppPreview() {
    MyTheme {
        MyApp()
    }
}
