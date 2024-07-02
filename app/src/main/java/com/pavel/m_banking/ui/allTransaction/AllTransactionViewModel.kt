package com.pavel.m_banking.ui.allTransaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus
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
    private var isFirst = true

    private val hardcodedTransactionList = listOf(
        Transaction("Company1", "50", "1.6.2024", TransactionStatus.DECLINE),
        Transaction("Company2", "66", "2.6.2024", TransactionStatus.EXECUTED),
        Transaction("Company3", "70", "3.6.2024", TransactionStatus.DECLINE),
        Transaction("Company4", "80", "4.6.2024", TransactionStatus.IN_PROGRESS)
    )

    fun getAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFirst) {
            transactions.postValue(hardcodedTransactionList)
            }
            isFirst = false
        }
    }

    fun searchTransactionsByParameter(text1: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val filteredList = hardcodedTransactionList.filter {
                it.recivingDate.contains(
                    text1,
                    ignoreCase = true
                )
            }
            transactions.postValue(filteredList)
        }
}
}
