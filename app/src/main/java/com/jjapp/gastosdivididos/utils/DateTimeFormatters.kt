package com.jjapp.gastosdivididos.utils

import java.time.format.DateTimeFormatter
import java.util.Locale

object DateTimeFormatters {
    val ddmmyyyy: DateTimeFormatter
        get() = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.getDefault())
    val ddmmyy: DateTimeFormatter
        get() = DateTimeFormatter.ofPattern("dd-MM-yy", Locale.getDefault())
}