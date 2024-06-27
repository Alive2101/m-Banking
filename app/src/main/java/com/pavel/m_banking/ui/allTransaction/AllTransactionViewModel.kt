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
        Transaction("Company1", "50", "01.06.2024", TransactionStatus.DECLINE),
        Transaction("Company2", "66", "01.06.2024", TransactionStatus.EXECUTED),
        Transaction("Company3", "70", "01.06.2024", TransactionStatus.DECLINE),
        Transaction("Company4", "80", "01.06.2024", TransactionStatus.IN_PROGRESS)
    )

    fun getAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            transactions.postValue(hardcodedTransactionList)
        }
    }
}