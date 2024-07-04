package com.pavel.m_banking.ui.account

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AccountScreen(
    navigationController: NavHostController,
    viewModel: AccountViewModel = hiltViewModel()
) {
    viewModel.getAccountAndTransactions()
    val transactionList = viewModel.transactions.observeAsState()
    val accountData = viewModel.accountData.observeAsState()
    val accountList = viewModel.accountList.observeAsState()

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        ShowPageTitle()
        ShowAccountData(accountData.value, accountList.value, viewModel)
        ShowTransactionTitle(navigationController, accountData.value)
        ShowTransactions(navigationController, transactionList.value)
    }

    ShowNavigation(navigationController, accountData.value)
}
