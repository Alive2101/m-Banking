package com.pavel.m_banking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pavel.m_banking.ui.account.AccountScreen
import com.pavel.m_banking.ui.allTransaction.AllTransactionScreen
import com.pavel.m_banking.ui.infoTrannsaction.InfoTransactionScreen
import com.pavel.m_banking.ui.newTransaction.TransactionScreen

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
        composable(
            "$TRANSACTION_SCREEN/{accountName}", arguments = listOf(navArgument("accountName") {
                type = NavType.StringType
            })
        ) {
            TransactionScreen(
                navigationController,
                it.arguments?.getString("accountName", "0") ?: ""
            )
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