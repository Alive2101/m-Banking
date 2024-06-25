package com.pavel.m_banking.ui.theme.account

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import androidx.navigation.NavHostController
import com.pavel.m_banking.R

@Composable
fun AccountScreen(
    navigationController: NavHostController
) {
    val ctx = LocalContext.current
    val gray = Color(0xFF1C1C1E)
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Text(
            text = "Account",
            modifier = Modifier.padding(start = 16.dp, top = 54.dp),
            color = Color.White,
            fontSize = 25.sp
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .width(343.dp)
                .height(92.dp)
                .background(gray, RoundedCornerShape(8.dp))
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
                        text = "Saving Account",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
                Row {
                    Text(
                        text = "91212192291221",
                        color = Color.Gray,
                        fontSize = 13.sp
                    )

                }
                Row {
                    Text(
                        text = "•••• 1234",
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
        Box(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .width(343.dp)
                .height(390.dp)
                .background(gray, RoundedCornerShape(8.dp))
        ) {
            Column {
                Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                    Text(
                        text = "OOO \"Company\"",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$10.09",
                        color = Color.White,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "01.06.2024",
                        color = Color.Gray
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "Executed",
                        color = Color.Green
                    )
                }
                Divider(
                    modifier = Modifier
                        .width(311.dp)
                        .padding(start = 30.dp, top = 16.dp),
                    color = Color(0xFF404040)
                )
                Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                    Text(
                        text = "OOO \"Company2\"",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$10.09",
                        color = Color.White,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "02.06.2024",
                        color = Color.Gray
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "Declined",
                        color = Color.Red
                    )
                }
                Divider(
                    modifier = Modifier
                        .width(311.dp)
                        .padding(start = 30.dp, top = 16.dp),
                    color = Color(0xFF404040)
                )
                Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                    Text(
                        text = "OOO \"Company2\"",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$10.09",
                        color = Color.White,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "06.06.2024",
                        color = Color.Gray
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "In progress",
                        color = Color.Yellow
                    )
                }
                Divider(
                    modifier = Modifier
                        .width(311.dp)
                        .padding(start = 30.dp, top = 16.dp),
                    color = Color(0xFF404040)
                )
                Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                    Text(
                        text = "OOO \"Company\"",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$10.09",
                        color = Color.White,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "07.06.2024",
                        color = Color.Gray
                    )
                }
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "Executed",
                        color = Color.Green
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
    }

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
        )
    }
}





