package com.pavel.m_banking.ui.newTransaction


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun addNewTransactions(
        accountName: String,
        companyName: String,
        transactionNumber: String,
        receivingDate: String,
        status: String,
        amount: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCity(
                accountName,
                companyName,
                transactionNumber,
                receivingDate,
                status,
                amount
            )
            Log.e("info", accountName)
            Log.e("info", companyName)
            Log.e("info", transactionNumber)
            Log.e("info", receivingDate)
            Log.e("info", status)
            Log.e("info", amount)
        }
    }
}
