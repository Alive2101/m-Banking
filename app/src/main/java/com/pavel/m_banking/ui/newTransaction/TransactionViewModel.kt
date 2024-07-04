package com.pavel.m_banking.ui.newTransaction


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    @RequiresApi(Build.VERSION_CODES.O)
    fun addNewTransactions(
        accountName: String,
        companyName: String,
        transactionNumber: String,
        status: String,
        amount: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentDate = LocalDate.now()
            val formatter = DateTimeFormatter.ofPattern("d.M.yyyy")
            val formattedDate = currentDate.format(formatter)

            repository.addTransaction(
                accountName,
                companyName,
                transactionNumber,
                formattedDate,
                status,
                amount
            )
        }
    }
}
