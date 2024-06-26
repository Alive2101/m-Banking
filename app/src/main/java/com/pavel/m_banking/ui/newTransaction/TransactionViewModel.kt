package com.pavel.m_banking.ui.newTransaction

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {
    fun addNewTransactions(
        value: String,
        number: String,
        date: String,
        status: String,
        amount: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
        }
    }
}