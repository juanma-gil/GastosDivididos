package com.jjapp.gastosdivididos.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjapp.gastosdivididos.R
import com.jjapp.gastosdivididos.data.models.Expense
import com.jjapp.gastosdivididos.ui.theme.GastosDivididosTheme
import com.jjapp.gastosdivididos.ui.theme.ColorPalette
import com.jjapp.gastosdivididos.utils.DateTimeFormatters
import java.time.LocalDateTime

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
    ElevatedButton(
        onClick = onClick,
        colors = buttonColors(containerColor = ColorPalette.Purple50)
    ) {
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
            MainButton(
                onClick = {},
                text = "Continue",
                color = ColorPalette.Purple30,
                enabled = true
            )
            AddButton(onClick = {})
        }
    }
}

@Composable
fun IconAndText(date: LocalDateTime, iconId: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(iconId)
        Image(
            painter = image,
            contentDescription = null,
            colorFilter = ColorFilter.tint(ColorPalette.Neutral30),
            modifier = Modifier
                .padding(bottom = 4.dp)
                .size(32.dp)
        )
        val dateText = date.format(DateTimeFormatters.ddmmyy)
        Text(text = dateText, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun PrimaryAndSecondaryText(primaryText: String, secondaryText: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = primaryText, style = MaterialTheme.typography.bodyLarge)
        Text(text = secondaryText, style = MaterialTheme.typography.bodyMedium)
    }
}