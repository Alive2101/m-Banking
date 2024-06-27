package com.pavel.m_banking.ui.allTransaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllTransactionViewModel : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()

    private val hardcodedTransactionList = listOf(
        Transaction("1", "50", "0", TransactionStatus.DECLINE),
        Transaction("2", "60", "0", TransactionStatus.EXECUTED),
        Transaction("3", "70", "0", TransactionStatus.DECLINE),
        Transaction("4", "80", "0", TransactionStatus.IN_PROGRESS),
        Transaction("5", "90", "0", TransactionStatus.DECLINE),
        Transaction("6", "100", "0", TransactionStatus.IN_PROGRESS),
        Transaction("7", "110", "0", TransactionStatus.EXECUTED),
        Transaction("8", "120", "0", TransactionStatus.IN_PROGRESS),
        Transaction("9", "130", "0", TransactionStatus.EXECUTED),
        Transaction("10", "140", "0", TransactionStatus.IN_PROGRESS),
    )

    fun getAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            transactions.postValue(hardcodedTransactionList)
        }
    }
}