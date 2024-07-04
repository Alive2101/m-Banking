package com.pavel.m_banking.ui.newTransaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun TransactionScreen(
    navigationController: NavHostController,
    accountName: String,
    viewModel: TransactionViewModel = hiltViewModel()
) {
    var companyName by remember { mutableStateOf("") }
    var transactionNumber by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
    ) {
        ShowTransactionsTitle()

        ShowTransactionsNames("Transaction was applied in")

        ShowTransactionsField(
            value = companyName,
            onValueChange = { companyName = it }
            )

        ShowTransactionsNames("Transaction number")

        ShowTransactionsField(
            value = transactionNumber,
            onValueChange = { transactionNumber = it }
        )

        ShowTransactionsNames("Transaction status")

        ShowTransactionsField(
            value = status,
            onValueChange = { status = it }
        )

        ShowTransactionsNames("Amount")

        ShowTransactionsField(
            value = amount,
            onValueChange = { amount = it }
        )

        ShowTransactionButton(
            navigationController,
            accountName,
            viewModel,
            companyName,
            transactionNumber,
            status,
            amount
        )
    }
}