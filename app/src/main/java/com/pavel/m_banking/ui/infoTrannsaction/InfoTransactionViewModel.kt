package com.pavel.m_banking.ui.infoTrannsaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus

class InfoTransactionViewModel : ViewModel() {

    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactionsInfo: LiveData<List<Transaction>> get() = _transactions

    private val hardcodedTransactionList = listOf(
        Transaction("Company1", "50", "01.06.2024", TransactionStatus.DECLINE),
        Transaction("Company2", "66", "01.06.2024", TransactionStatus.EXECUTED),
        Transaction("Company3", "70", "01.06.2024", TransactionStatus.DECLINE),
        Transaction("Company4", "80", "01.06.2024", TransactionStatus.IN_PROGRESS)
    )


    fun filterTransactionsByName(id: String) {
        val filteredTransactions = hardcodedTransactionList.filter { it.companyName == id }
        _transactions.value = filteredTransactions
    }
}