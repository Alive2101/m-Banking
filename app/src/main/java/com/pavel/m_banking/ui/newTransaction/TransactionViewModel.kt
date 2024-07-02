package com.pavel.m_banking.ui.newTransaction


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
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