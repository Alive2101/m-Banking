package com.pavel.m_banking.ui.allTransaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTransactionViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()

    private val hardcodedTransactionList = listOf(
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1"),
        Transaction("1", "1", "1", "1", "TransactionStatus.EXECUTED", "1")
    )

    fun getAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            transactions.postValue(repository.getTransactionList())
        }
    }

    fun searchTransactionsByParameter(text1: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val filteredList = hardcodedTransactionList.filter {
                it.receivingDate.contains(
                    text1,
                    ignoreCase = true
                )
            }
            transactions.postValue(filteredList)
        }
}
}
