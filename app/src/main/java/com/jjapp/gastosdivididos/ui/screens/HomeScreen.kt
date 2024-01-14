package com.jjapp.gastosdivididos.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjapp.gastosdivididos.data.models.Expense
import com.jjapp.gastosdivididos.ui.composables.IconAndText
import com.jjapp.gastosdivididos.ui.composables.PrimaryAndSecondaryText
import com.jjapp.gastosdivididos.ui.theme.ColorPalette
import com.jjapp.gastosdivididos.ui.theme.GastosDivididosTheme
import com.jjapp.gastosdivididos.utils.DateTimeFormatters
import com.jjapp.gastosdivididos.utils.Extensions.formatCurrency

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GastosDivididosTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = ColorPalette.Neutral10
                ) {
                    ExpenseCard(expense = Expense())
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    GastosDivididosTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = ColorPalette.Neutral10
        ) {
            ExpenseCard(expense = Expense())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseCard(expense: Expense, onClick: () -> Unit = {}) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = ColorPalette.Purple80,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconAndText(
                    date = expense.date,
                    iconId = expense.iconId,
                )
                Spacer(modifier = Modifier.padding(20.dp))
                PrimaryAndSecondaryText(
                    primaryText = expense.primaryText,
                    secondaryText = expense.secondaryText
                )
            }
            Text(text = expense.value.formatCurrency(), style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview
@Composable
fun ExpenseCardPreview() {
    GastosDivididosTheme {
        ExpenseCard(expense = Expense())
    }
}