package com.pavel.m_banking.ui.newTransaction

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowTransactionsTitle() {
    Text(
        text = "Transaction",
        modifier = Modifier.padding(start = 16.dp, top = 54.dp),
        color = Color.White,
        fontSize = 25.sp
    )
}