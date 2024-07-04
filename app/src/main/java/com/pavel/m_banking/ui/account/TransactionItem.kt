package com.pavel.m_banking.ui.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.navigation.INFO_TRANSACTION_SCREEN

@Composable

fun TransactionItem(
    navigationController: NavController,
    transaction: Transaction
) {
    Column(modifier = Modifier.clickable {
        navigationController.navigate("$INFO_TRANSACTION_SCREEN/${transaction.transactionNumber}")
    }) {
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Text(
                text = transaction.companyName,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = transaction.amount,
                color = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
        Row(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = transaction.receivingDate,
                color = Color.Gray
            )
        }
        val text = transaction.status
        val textColor = Color.White

        Row(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = text,
                color = textColor
            )
        }
        Divider(
            modifier = Modifier
                .width(311.dp)
                .padding(start = 30.dp, top = 16.dp),
            color = Color(0xFF404040)
        )
    }
}