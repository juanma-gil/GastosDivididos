package com.jjapp.gastosdivididos.utils

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

object Extensions {
    fun BigDecimal.formatCurrency() = run {
        val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
        format.format(this)
    }
}