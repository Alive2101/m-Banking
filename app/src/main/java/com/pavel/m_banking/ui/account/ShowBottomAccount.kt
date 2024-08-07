package com.pavel.m_banking.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.ui.theme.Gray500

@Composable
fun ShowBottomAccount(
    account: List<Account>?,
    viewModel: AccountViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .width(343.dp)
            .height(390.dp)
            .background(Gray500, RoundedCornerShape(8.dp))
    ) {
        LazyColumn {
            items(account ?: arrayListOf()) { info ->
                AccountItem(info, viewModel)
            }
        }
    }
}