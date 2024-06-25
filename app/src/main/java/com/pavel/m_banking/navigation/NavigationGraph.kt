package com.pavel.m_banking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pavel.m_banking.ui.theme.account.AccountScreen

const val ACCOUNT_SCREEN = "accountScreen"

@Composable
fun NavigationGraph(
    navigationController: NavHostController
) {
    NavHost(navController = navigationController, startDestination = ACCOUNT_SCREEN) {
        composable(ACCOUNT_SCREEN) {
            AccountScreen(navigationController)
        }
    }
}