package com.pavel.m_banking.ui.account

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
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus

@Composable
fun TransactionItem(transaction: Transaction) {
    Column {
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Text(
                text = transaction.companyName,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = transaction.summa,
                color = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
        Row(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = transaction.recivingDate,
                color = Color.Gray
            )
        }
        val text = transaction.status
        val textColor =
            when (text) {
                TransactionStatus.EXECUTED -> Color.Green
                TransactionStatus.IN_PROGRESS -> Color.Yellow
                else -> Color.Red
            }

        Row(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = text.toString(),
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