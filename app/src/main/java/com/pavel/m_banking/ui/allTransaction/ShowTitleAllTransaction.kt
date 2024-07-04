package com.pavel.m_banking.ui.allTransaction

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pavel.m_banking.R
import com.pavel.m_banking.navigation.ACCOUNT_SCREEN
import com.pavel.m_banking.ui.allTransaction.filterByDate.FilterByDateScreen


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTitleAllTransaction(
    navigationController: NavHostController,
    viewModel: AllTransactionViewModel = hiltViewModel(),
    accountName: String
) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Box {
        Image(
            imageVector =
            ImageVector.vectorResource(id = R.drawable.ic_menu_for_all_transaction_screen),
            contentDescription = "arrow",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 25.dp, end = 12.dp)
                .clickable {
                    showBottomSheet = true
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
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
            containerColor = Color.Black
        ) {

            FilterByDateScreen(viewModel,accountName)
        }
    }
}

