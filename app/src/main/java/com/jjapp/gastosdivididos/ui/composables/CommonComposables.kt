package com.jjapp.gastosdivididos.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjapp.gastosdivididos.R
import com.jjapp.gastosdivididos.ui.theme.GastosDivididosTheme
import com.jjapp.gastosdivididos.ui.theme.ColorPalette

@Composable
fun MainButton(
    onClick: () -> Unit = {},
    text: String = "",
    color: Color = MaterialTheme.colorScheme.primary,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = buttonColors(
            containerColor = color,
        ),
        enabled = enabled
    ) {
        Text(text = text)
    }
}

@Composable
fun AddButton(onClick: () -> Unit = {}) {
    ElevatedButton(onClick = onClick, colors = buttonColors(containerColor = ColorPalette.Purple50)) {
        val text = stringResource(id = R.string.add_btn_txt)
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = text,
            tint = Color.White
        )
        Text(text = text)
    }
}

@Preview
@Composable
fun MainButtonPreview() {
    GastosDivididosTheme {
        Column {
            MainButton(onClick = {}, text = "Continue", color = ColorPalette.Purple30, enabled = true)
            AddButton(onClick = {})
        }
    }
}