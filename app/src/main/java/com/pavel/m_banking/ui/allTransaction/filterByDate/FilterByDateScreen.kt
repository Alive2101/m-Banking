package com.pavel.m_banking.ui.allTransaction.filterByDate

import android.os.Build
import android.widget.CalendarView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.pavel.m_banking.R
import com.pavel.m_banking.ui.allTransaction.AllTransactionViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FilterByDateScreen(
    viewModel: AllTransactionViewModel = hiltViewModel(),
    accountName: String
) {

    var firstField by remember { mutableStateOf("") }
    var secondField by remember { mutableStateOf("") }
    var firstFieldBorderColor by remember { mutableStateOf(Color.Gray) }
    var secondFieldBorderColor by remember { mutableStateOf(Color.Gray) }
    val focusRequester = remember { FocusRequester() }
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedTextField by remember { mutableStateOf("text1") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        ShowFilterTitle()

        ShowText("Start date")

        OutlinedTextField(
            value = firstField,
            onValueChange = { firstField = it },
            textStyle = MaterialTheme.typography.bodySmall.copy(Color.White),
            label = { Text("Select end date", color = Color.White) },
            trailingIcon = {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_calendar),
                    contentDescription = "Calendar Icon",
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .focusable(true)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        selectedTextField = "firstField"
                        showBottomSheet = true
                    }
                },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = firstFieldBorderColor,
                unfocusedBorderColor = firstFieldBorderColor
            )
        )

        ShowText("End date")

        OutlinedTextField(
            value = secondField,
            onValueChange = { secondField = it },
            textStyle = MaterialTheme.typography.bodySmall.copy(Color.White),
            label = { Text("Select end date", color = Color.White) },
            trailingIcon = {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_calendar),
                    contentDescription = "Calendar Icon",
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .focusable(true)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        selectedTextField = "secondField"
                        showBottomSheet = true
                    }
                },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondFieldBorderColor,
                unfocusedBorderColor = secondFieldBorderColor
            )
        )

        Button(
            onClick = {
                firstFieldBorderColor = if (firstField.isEmpty()) Color.Red else Color.Gray
                secondFieldBorderColor = if (secondField.isEmpty()) Color.Red else Color.Gray

                if (firstField.isEmpty() || secondField.isEmpty()) {
                    return@Button
                }

                val formatter = DateTimeFormatter.ofPattern("d.M.yyyy")
                val startDate = LocalDate.parse(firstField, formatter)
                val endDate = LocalDate.parse(secondField, formatter)

                if (endDate.isBefore(startDate)) {
                    Toast.makeText(
                        context,
                        "End date cannot be before start date",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    viewModel.getTransactionsBetweenDates(
                        firstField,
                        secondField,
                        accountName
                    )
                    showBottomSheet = false
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
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

    if (showBottomSheet) {
        AndroidView(
            {
                CalendarView(context).apply {
                    setBackgroundColor(Color.White.hashCode())
                }
            },
            modifier = Modifier.wrapContentWidth(),
            update = { views ->
                views.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    val date = "$dayOfMonth.${month + 1}.$year"
                    when (selectedTextField) {
                        "firstField" -> firstField = date
                        "secondField" -> secondField = date
                    }
                }
            }
        )
    }
}