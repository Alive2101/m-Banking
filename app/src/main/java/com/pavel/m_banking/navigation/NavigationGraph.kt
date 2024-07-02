package com.pavel.m_banking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pavel.m_banking.ui.account.AccountScreen
import com.pavel.m_banking.ui.account.AccountViewModel
import com.pavel.m_banking.ui.allTransaction.AllTransactionScreen
import com.pavel.m_banking.ui.allTransaction.AllTransactionViewModel
import com.pavel.m_banking.ui.infoTrannsaction.InfoTransactionScreen
import com.pavel.m_banking.ui.infoTrannsaction.InfoTransactionViewModel
import com.pavel.m_banking.ui.newTransaction.TransactionScreen
import com.pavel.m_banking.ui.newTransaction.TransactionViewModel

const val ACCOUNT_SCREEN = "accountScreen"
const val TRANSACTION_SCREEN = "transactionScreen"
const val ALL_TRANSACTION_SCREEN = "allTransactionScreen"
const val INFO_TRANSACTION_SCREEN = "infoTransactionScreen"


@Composable
fun NavigationGraph(
    navigationController: NavHostController,
) {
    NavHost(navController = navigationController, startDestination = ACCOUNT_SCREEN) {
        composable(ACCOUNT_SCREEN) {
            AccountScreen(navigationController)
        }
        composable(TRANSACTION_SCREEN) {
            TransactionScreen(navigationController)
        }
        composable(ALL_TRANSACTION_SCREEN) {
            AllTransactionScreen(navigationController)
        }
        composable(
            "$INFO_TRANSACTION_SCREEN/{id}", arguments = listOf(navArgument("id")
            {
                type = NavType.StringType
            })
        ) {
            InfoTransactionScreen(
                it.arguments?.getString("id", "0") ?: "",
                navigationController
            )
        }
    }
}