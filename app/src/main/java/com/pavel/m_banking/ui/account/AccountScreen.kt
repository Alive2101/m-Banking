package com.pavel.m_banking.ui.account

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pavel.m_banking.R
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus
import com.pavel.m_banking.navigation.TRANSACTION_SCREEN
import com.pavel.m_banking.ui.theme.Gray500

@Composable
fun AccountScreen(
    navigationController: NavHostController,
    viewModel: AccountViewModel
) {
    viewModel.getAccountAndTransactions()
    val transactionList = viewModel.transactions.observeAsState()
    val accountData = viewModel.accountData.observeAsState()
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        ShowPageTitle()
        ShowAccountData(accountData.value)
        ShowTransactionTitle()
        ShowTransactions(transactionList.value)
    }
    ShowNavigation(navigationController)
}
@Composable
fun ShowTransactions(transaction: List<Transaction>?) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .width(343.dp)
            .height(390.dp)
            .background(Gray500, RoundedCornerShape(8.dp))
    ) {
        LazyColumn {
            items(transaction ?: arrayListOf()) { info ->
                TransactionItem(info)
            }
        }
    }
}

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

@Composable
fun ShowAccountData(accountData: Account?) {
    val ctx = LocalContext.current
    Box(
        modifier = Modifier
            .padding(16.dp)
            .width(343.dp)
            .height(92.dp)
            .background(Gray500, RoundedCornerShape(8.dp))
            .clickable {
                Toast
                    .makeText(ctx, "click", Toast.LENGTH_LONG)
                    .show()
            }
    ) {
        Column {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_card_for_account_screen),
                contentDescription = "card",
            )
        }
        Column(modifier = Modifier.padding(start = 92.dp, top = 16.dp)) {
            Row {
                Text(
                    text = accountData?.accountName ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
            Row {
                Text(
                    text = accountData?.accountNumber ?: "",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
            Row {
                Text(
                    text = accountData?.cardNumber ?: "",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
        Column(modifier = Modifier.align(Alignment.CenterEnd)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_for_account_screen),
                contentDescription = "arrow",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 5.dp)
            )
        }
    }
}
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
            if (text == TransactionStatus.EXECUTED) Color.Green else Color.Red
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
@Composable
fun ShowPageTitle() {
    Text(
        text = "Account",
        modifier = Modifier.padding(start = 16.dp, top = 54.dp),
        color = Color.White,
        fontSize = 25.sp
    )
}