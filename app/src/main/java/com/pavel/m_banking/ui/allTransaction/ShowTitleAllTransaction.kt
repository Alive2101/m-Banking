package com.pavel.m_banking.ui.allTransaction

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavHostController
import com.pavel.m_banking.R
import com.pavel.m_banking.navigation.ACCOUNT_SCREEN


@Composable
fun ShowTitleAllTransaction(navigationController: NavHostController) {
    val ctx = LocalContext.current

    Box {
        Image(
            imageVector =
            ImageVector.vectorResource(id = R.drawable.ic_menu_for_all_transaction_screen),
            contentDescription = "arrow",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 25.dp, end = 12.dp)
                .clickable {
                    Toast
                        .makeText(ctx, "click", Toast.LENGTH_LONG)
                        .show()
                }
        )

        Image(
            imageVector =
            ImageVector.vectorResource(id = R.drawable.ic_arrow_for_all_transaction_screen),
            contentDescription = "arrow",
            modifier = Modifier
                .padding(top = 25.dp, start = 12.dp)
                .clickable {
                    navigationController.navigate(ACCOUNT_SCREEN)
                }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "All transaction",
                fontSize = 17.sp,
                color = Color.White
            )
        }
    }
}