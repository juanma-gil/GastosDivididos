package com.jjapp.gastosdivididos.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jjapp.gastosdivididos.ui.theme.GastosDivididosTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GastosDivididosTheme {
                 Surface(color = MaterialTheme.colorScheme.background){

                 }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GastosDivididosTheme {
        Surface(color = colorScheme.background) {

        }
    }
}
