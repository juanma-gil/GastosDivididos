package com.jjapp.gastosdivididos.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults.iconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjapp.gastosdivididos.R
import com.jjapp.gastosdivididos.data.models.Expense
import com.jjapp.gastosdivididos.ui.composables.IconAndText
import com.jjapp.gastosdivididos.ui.composables.PrimaryAndSecondaryText
import com.jjapp.gastosdivididos.ui.theme.ColorPalette
import com.jjapp.gastosdivididos.ui.theme.GastosDivididosTheme
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
            Column {
                HomeHeader({}, {})
                ExpenseCard(expense = Expense())
            }
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
            .wrapContentHeight()
            .padding(horizontal = 24.dp),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeHeader(onValueChange: (String) -> Unit, calendarOnClick: () -> Unit) {
    val filterChips = listOf(
        stringResource(id = R.string.home_filter_today),
        stringResource(id = R.string.home_filter_week),
        stringResource(id = R.string.home_filter_month),
        stringResource(id = R.string.home_filter_year)
    )

    Column {
        TitleHomeHeader(calendarOnClick)
        OutlinedTextField(
            value = "",
            onValueChange = onValueChange,
            label = { Text(stringResource(id = R.string.home_tf_label)) },
            placeholder = { Text(stringResource(id = R.string.home_tf_placeholder)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ColorPalette.Purple80,
                focusedLabelColor = ColorPalette.Purple80
            )
        )
        Row(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 2.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            filterChips.forEach { filter ->
                FilterChip(
                    label = { Text(filter) },
                    selected = false,
                    onClick = {},
                    modifier = Modifier.padding(end = 8.dp),
                    leadingIcon = {
                        // TODO
//                        if (true) {
//                            Icon(
//                                imageVector = Icons.Filled.Check,
//                                contentDescription = null
//                            )
//                        }
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = ColorPalette.Purple80,
                        labelColor = ColorPalette.Neutral10,
                        selectedContainerColor = ColorPalette.Purple30,
                        selectedLabelColor = ColorPalette.Purple90,
                        selectedLeadingIconColor = ColorPalette.Purple90,
                    )
                )
            }
        }
        Divider(Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun HomeHeaderPreview() {
    GastosDivididosTheme {
        HomeHeader({}, {})
    }
}

@Composable
fun TitleHomeHeader(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = R.string.home_title),
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(
            onClick = onClick,
            colors = iconButtonColors(
                containerColor = ColorPalette.Purple80,
                contentColor = ColorPalette.Purple30
            ),
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null,
            )
        }
    }
}