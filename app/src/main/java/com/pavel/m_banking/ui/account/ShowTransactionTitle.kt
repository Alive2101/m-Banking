package com.pavel.m_banking.ui.account

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowTransactionTitle() {
    Row {
        Text(
            text = "Recent Transactions", fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "VIEW ALL",
            color = Color.Blue,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 40.dp, top = 8.dp)
        )
    }
}