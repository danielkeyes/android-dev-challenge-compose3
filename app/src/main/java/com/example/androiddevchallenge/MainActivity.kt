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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

// TODO
// Button color
// TextField Styling
// Dark Light mode
// Compose navigation for onClick of button
// ....

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
        LogonScreen()
    }
}

@Composable
fun LogonScreen() {

    Column {
        Box(modifier = Modifier.wrapContentHeight()) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .fillMaxWidth(),
                text = "Welcome back", color = Color.White, style = typography.h2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp),
        ) {
            TextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "",
                placeholder = { Text(text = "Email Address")},
                leadingIcon = { Icon(Icons.Outlined.Email, "") },
                onValueChange = { /*TODO*/ })
            TextField(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "",
                placeholder = { Text(text = "Email Address")},
                leadingIcon = { Icon(Icons.Outlined.Password, "") },
                onValueChange = { /*TODO*/ })
            Button(modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape( 50),
                onClick = {

            }) {
                Text(
                    text = "Log In",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
