package com.pavel.m_banking.ui.newTransaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun TransactionScreen(
    navigationController: NavHostController,
    viewModel: TransactionViewModel
) {
    var appliedIn by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Row {
            ShowTransactionsTitle()
        }

        Row {
            ShowTransactionsNames("Transaction was applied in")
        }

        Row {
            ShowTransactionsField(
                value = appliedIn,
                onValueChange = { appliedIn = it }
            )
        }

        Row {
            ShowTransactionsNames("Transaction number")
        }

        Row {
            ShowTransactionsField(
                value = number,
                onValueChange = { number = it }
            )
        }

        Row {
            ShowTransactionsNames("Date")
        }

        Row {
            ShowTransactionsField(
                value = date,
                onValueChange = { date = it }
            )
        }

        Row {
            ShowTransactionsNames("Transaction status")
        }

        Row {
            ShowTransactionsField(
                value = status,
                onValueChange = { status = it }
            )
        }

        Row {
            ShowTransactionsNames("Amount")
        }

        Row {
            ShowTransactionsField(
                value = amount,
                onValueChange = { amount = it }
            )
        }

        Row {
            ShowTransactionButton(
                navigationController,
                viewModel,
                appliedIn,
                number,
                date,
                status,
                amount
            )
        }
    }
}

