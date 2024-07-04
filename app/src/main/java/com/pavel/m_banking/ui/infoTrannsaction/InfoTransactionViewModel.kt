package com.pavel.m_banking.ui.infoTrannsaction

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
class InfoTransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()

    fun filterTransactionsByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            transactions.postValue(transactionRepository.getTransactionListByName(name))
        }
    }
}
