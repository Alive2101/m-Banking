package com.pavel.m_banking.ui.infoTrannsaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pavel.m_banking.ui.newTransaction.ShowTransactionsField
import com.pavel.m_banking.ui.newTransaction.ShowTransactionsNames
import com.pavel.m_banking.ui.newTransaction.ShowTransactionsTitle

@Composable
fun InfoTransactionScreen(
    id: String,
    navigationController: NavController,
    viewModel: InfoTransactionViewModel
) {
    viewModel.filterTransactionsByName(id)

    val transactions = viewModel.transactionsInfo.observeAsState(emptyList())

    var appliedIn by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    transactions.value.forEach { transaction ->
        Column(
            modifier = Modifier
                .background(Color.Black)
                .padding(16.dp)
        ) {
            ShowTransactionsTitle()

            ShowTransactionsNames("Transaction was applied in")

            ShowTransactionsField(
                value = transaction.companyName,
                onValueChange = { appliedIn = it }
            )

            ShowTransactionsNames("Transaction number")

            ShowTransactionsField(
                value = transaction.summa,
                onValueChange = { number = it }
            )

            ShowTransactionsNames("Date")

            ShowTransactionsField(
                value = transaction.recivingDate,
                onValueChange = { date = it }
            )

            ShowTransactionsNames("Transaction status")

            ShowTransactionsField(
                value = transaction.status.toString(),
                onValueChange = { status = it }
            )

            ShowTransactionsNames("Amount")

            ShowTransactionsField(
                value = transaction.companyName,
                onValueChange = { amount = it }
            )

            InfoTransactionButton(
                navigationController,
            )
        }
    }
}