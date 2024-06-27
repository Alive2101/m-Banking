package com.pavel.m_banking.ui.allTransaction.filterByDate

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowFilterTitle() {
    Text(
        text = "Filter by date",
        fontSize = 24.sp,
        color = Color.White,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}