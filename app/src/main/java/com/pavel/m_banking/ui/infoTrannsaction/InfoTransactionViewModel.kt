package com.pavel.m_banking.ui.infoTrannsaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus

class InfoTransactionViewModel() : ViewModel() {

    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactionsInfo: LiveData<List<Transaction>> get() = _transactions

    private val hardcodedTransactionList = listOf<Transaction>(
        Transaction("1", "5", "0", TransactionStatus.DECLINE),
        Transaction("2", "6", "0", TransactionStatus.EXECUTED),
        Transaction("3", "7", "0", TransactionStatus.DECLINE),
        Transaction("4", "8", "0", TransactionStatus.IN_PROGRESS)
    )


    fun filterTransactionsByName(id: String) {
        val filteredTransactions = hardcodedTransactionList.filter { it.companyName == id }
        _transactions.value = filteredTransactions
    }
}