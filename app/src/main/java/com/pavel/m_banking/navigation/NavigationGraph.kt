package com.pavel.m_banking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pavel.m_banking.ui.account.AccountScreen
import com.pavel.m_banking.ui.account.AccountViewModel
import com.pavel.m_banking.ui.newTransaction.TransactionScreen
import com.pavel.m_banking.ui.newTransaction.TransactionViewModel

const val ACCOUNT_SCREEN = "accountScreen"
const val TRANSACTION_SCREEN = "transactionScreen"

@Composable
fun NavigationGraph(
    navigationController: NavHostController,
    viewModel: AccountViewModel
) {
    NavHost(navController = navigationController, startDestination = ACCOUNT_SCREEN) {
        composable(ACCOUNT_SCREEN) {
            AccountScreen(navigationController, viewModel)
        }
        composable(TRANSACTION_SCREEN) {
            TransactionScreen(navigationController, viewModel = TransactionViewModel())
        }
    }
}