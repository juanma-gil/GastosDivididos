package com.jjapp.gastosdivididos.data.models

import androidx.room.Entity
import com.jjapp.gastosdivididos.R
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Expense(
    val iconId: Int = R.drawable.ic_bill,
    val date: LocalDateTime = LocalDateTime.now(),
    val primaryText: String = "Gasto default",
    val secondaryText: String = "1 persona",
    val value: BigDecimal = BigDecimal.ZERO,
)
