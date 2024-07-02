package com.pavel.m_banking.ui.allTransaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.ui.account.TransactionItem
import com.pavel.m_banking.ui.theme.Gray500

@Composable
fun ShowAllTransaction(navigationController: NavController, transaction: List<Transaction>?) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .width(343.dp)
            .fillMaxHeight()
            .background(Gray500, RoundedCornerShape(8.dp))
    ) {
        LazyColumn {
            items(transaction ?: arrayListOf()) { info ->
                TransactionItem(navigationController,info)
            }
        }
    }
}