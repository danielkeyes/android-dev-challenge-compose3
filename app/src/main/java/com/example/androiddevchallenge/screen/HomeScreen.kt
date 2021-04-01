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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.typography

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "Positions")
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                // TODO make into buttons
                Text(text = "Account")
                Text(text = "Watchlist")
                Text(text = "Profile")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Balance", style = typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$73,589.01", style = typography.h1)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "+412.35 today", style = typography.subtitle1, color = green)
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "TRANSACT")
            }
            Spacer(modifier = Modifier.height(16.dp))
            val myItems = listOf<renameMe>(
                renameMe("Week", true),
                renameMe("ETFs"),
                renameMe("Stocks"),
                renameMe("Funds"),
                renameMe("Funds"),
                renameMe("Funds"),
                renameMe("Funds"),
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(myItems) { item ->
                    Button(onClick = {}) {
                        Text(text = item.text)
                    }
                }
            }
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.home_illos),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomeScreenPreview() {
    MyTheme {
        HomeScreen(rememberNavController())
    }
}

data class renameMe(val text: String, val hasOptions: Boolean = false)
