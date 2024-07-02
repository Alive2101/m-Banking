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
import androidx.hilt.navigation.compose.hiltViewModel
import com.pavel.m_banking.model.Account

@Composable
fun AccountItem(
    account: Account,
    viewModel: AccountViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.clickable {
        viewModel.findAccountByName(account.accountName)
    }) {
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Text(
                text = account.accountName,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = account.accountNumber,
                color = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
        Row(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = account.cardNumber,
                color = Color.Gray
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