package com.jjapp.gastosdivididos.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Error20
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Error30
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Neutral10
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Neutral20
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Neutral30
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Purple30
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Purple80
import com.jjapp.gastosdivididos.ui.theme.ColorPalette.Purple90

private val DarkColorScheme = darkColorScheme(
    primary = Purple30,
    secondary = Neutral30,
    tertiary = Purple80,
    background = Neutral10,
    surface = Neutral20,
    error = Error20,
    onPrimary = Purple90,
    onSecondary = Neutral10,
    onErrorContainer = Error30,
    onError = Error30,
)

@Composable
fun GastosDivididosTheme(content: @Composable () -> Unit) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}