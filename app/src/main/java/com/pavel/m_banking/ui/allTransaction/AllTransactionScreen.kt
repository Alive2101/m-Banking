package com.pavel.m_banking.ui.allTransaction

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllTransactionScreen(
    accountName: String,
    navigationController: NavHostController,
    viewModel: AllTransactionViewModel = hiltViewModel()
) {
    viewModel.getAllTransactions(accountName)
    val transactionList = viewModel.transactions.observeAsState()

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Row {
            ShowTitleAllTransaction(navigationController, viewModel,accountName)
        }

        ShowAllTransaction(navigationController,transactionList.value)
    }
}
