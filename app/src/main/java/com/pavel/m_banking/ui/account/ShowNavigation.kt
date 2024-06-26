package com.pavel.m_banking.ui.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pavel.m_banking.R
import com.pavel.m_banking.navigation.TRANSACTION_SCREEN

@Composable
fun ShowNavigation(navigationController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_navigation_add_new_transaction),
            contentDescription = "navigation",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .clickable {
                    navigationController.navigate(TRANSACTION_SCREEN)
                }
        )
    }
}