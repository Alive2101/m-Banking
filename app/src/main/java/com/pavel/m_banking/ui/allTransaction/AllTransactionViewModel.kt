package com.pavel.m_banking.ui.allTransaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()
    private var isFirst = true

    fun getAllTransactions(accountName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFirst) {
                transactions.postValue(transactionRepository.getTransactionInfo(accountName))
                isFirst = false
            }
        }
    }

    fun getTransactionsBetweenDates(startDate: String, endDate: String, accountName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            transactions.postValue(
                transactionRepository.getTransactionsBetweenDates(
                    startDate,
                    endDate,
                    accountName
                )
            )
        }
}
}
