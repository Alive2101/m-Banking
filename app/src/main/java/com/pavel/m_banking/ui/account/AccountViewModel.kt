package com.pavel.m_banking.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel() : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()
    val accountData = MutableLiveData<Account>()

    val hardcodedTransactionList = listOf<Transaction>(
        Transaction("1", "5", "0", TransactionStatus.DECLINE),
        Transaction("2", "6", "0", TransactionStatus.EXECUTED),
        Transaction("3", "7", "0", TransactionStatus.DECLINE),
        Transaction("4", "8", "0", TransactionStatus.IN_PROGRESS)
    )

    val hardCodedAccount = Account(
        accountName = "Saving Account",
        accountNumber = "56465846512",
        cardNumber = "**** djscnfdvh"
    )
    fun getAccountAndTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            transactions.postValue(hardcodedTransactionList)
            accountData.postValue(hardCodedAccount)
        }
    }
}