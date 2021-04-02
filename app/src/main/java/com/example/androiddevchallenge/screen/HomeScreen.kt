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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.ClearOutlinedButton
import com.example.androiddevchallenge.components.SolidButton
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.typography

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val sheetPeakHeight  = 64.dp

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = { 
            Positions(positions = PositionsHelper().getPositions())
        },
        sheetPeekHeight = sheetPeakHeight,
        sheetShape = RectangleShape,
        sheetBackgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = sheetPeakHeight)
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().paddingFromBaseline(64.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                // TODO make into buttons
                Text(text = "Account")
                Text(text = "Watchlist")
                Text(text = "Profile")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Balance", modifier = Modifier.paddingFromBaseline(32.dp), style = typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$73,589.01",modifier = Modifier.paddingFromBaseline(48.dp), style = typography.h1)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "+412.35 today",modifier = Modifier.paddingFromBaseline(16.dp), style = typography.subtitle1, color = green)
            Spacer(modifier = Modifier.height(32.dp))
            SolidButton(
                modifier = Modifier.fillMaxWidth().height(48.dp),
                text = "TRANSACT",
                onClick = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.height(16.dp))
            val myItems = listOf<Filter>(
                Filter("Week", true),
                Filter("ETFs"),
                Filter("Stocks"),
                Filter("Funds"),
                Filter("Funds"),
                Filter("Funds"),
                Filter("Funds"),
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(myItems) { item ->
                    val buttonModifier = Modifier.height(40.dp)
                    if (item.hasOptions){
                        ClearOutlinedButton(text = item.text, modifier = buttonModifier, icon = Icons.Filled.ExpandMore, onClick = {  }, color = Color.White )
                    } else {
                        ClearOutlinedButton(text = item.text, modifier = buttonModifier, onClick = {  }, color = Color.White )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(192.dp),
                painter = painterResource(id = R.drawable.home_illos),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            Spacer(modifier = Modifier.height(32.dp))
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

data class Filter(val text: String, val hasOptions: Boolean = false)
