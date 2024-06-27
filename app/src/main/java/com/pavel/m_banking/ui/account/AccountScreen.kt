package com.pavel.m_banking.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun AccountScreen(
    navigationController: NavHostController,
    viewModel: AccountViewModel
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
        ShowAccountData(accountData.value,accountList.value,viewModel)
        ShowTransactionTitle(navigationController)
        ShowTransactions(navigationController, transactionList.value)
    }

    ShowNavigation(navigationController)
}
