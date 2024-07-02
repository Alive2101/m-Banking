package com.pavel.m_banking.ui.infoTrannsaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoTransactionViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactionsInfo: LiveData<List<Transaction>> get() = _transactions

    private val hardcodedTransactionList = listOf(
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1")
    )


    fun filterTransactionsByName(id: String) {
        val filteredTransactions = hardcodedTransactionList.filter { it.companyName == id }
        _transactions.value = filteredTransactions
    }
}