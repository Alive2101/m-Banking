package com.pavel.m_banking.ui.newTransaction

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pavel.m_banking.navigation.ACCOUNT_SCREEN

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowTransactionButton(
    navigationController: NavHostController,
    accountName: String,
    viewModel: TransactionViewModel = hiltViewModel(),
    companyName: String,
    transactionNumber: String,
    status: String,
    amount: String
) {
    val allFieldsFilled =
        companyName.isNotEmpty() && transactionNumber.isNotEmpty()
                && status.isNotEmpty() && amount.isNotEmpty()

    Button(
        onClick = {
            navigationController.navigate(ACCOUNT_SCREEN)
            viewModel.addNewTransactions(
                accountName,
                companyName,
                transactionNumber,
                status,
                amount
            )
        },
        enabled = allFieldsFilled,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(1.dp, Color.Black, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue
        )
    ) {
        Text(
            text = "Okay",
            style = TextStyle(color = Color.White)
        )
    }
}