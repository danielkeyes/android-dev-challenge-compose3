package com.example.androiddevchallenge.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.clear
import com.example.androiddevchallenge.ui.theme.yellow

@Composable
fun ClearOutlinedButton(
    text: String,
    onClick: () -> Unit,
    color: Color?,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    OutlinedButton(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = color ?: Color.Unspecified),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = clear,
        ),
        onClick = { onClick() }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = text, style = MaterialTheme.typography.button, color = color ?: Color.Unspecified)
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun SolidButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = MaterialTheme.colors.primary,
    textColor: Color = Color.Unspecified,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(50),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
        )    ) {
        Text(text = text, style = MaterialTheme.typography.button, color = textColor)
    }
}

@Preview
@Composable
fun PreviewClearOutlinedButton() {
    Column() {
        ClearOutlinedButton(text = "Button", onClick = { /*TODO*/ }, color = yellow)
        ClearOutlinedButton(
            text = "Expand",
            icon = Icons.Filled.ExpandMore,
            onClick = { /*TODO*/ },
            color = Color.White
        )
    }
}
