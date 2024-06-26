package com.pavel.m_banking.ui.account

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pavel.m_banking.R
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.ui.theme.Gray500

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