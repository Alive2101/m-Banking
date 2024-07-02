package com.pavel.m_banking.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.model.TransactionStatus
import com.pavel.m_banking.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()
    var accountData = MutableLiveData<Account?>()
    var accountList = MutableLiveData<List<Account>>()
    private var isFirst = true

    private val hardcodedTransactionList = listOf(
        Transaction("Company1", "50", "01.06.2024", TransactionStatus.DECLINE),
        Transaction("Company2", "66", "01.06.2024", TransactionStatus.EXECUTED),
        Transaction("Company3", "70", "01.06.2024", TransactionStatus.DECLINE),
        Transaction("Company4", "80", "01.06.2024", TransactionStatus.IN_PROGRESS)
    )

    private val hardCodedAccount = listOf(
        Account("Saving account", "123456789", "***** 123456"),
        Account("For traveling", "987654321", "***** 654321"),
        Account("My first account", "741852963", "***** 852963"),
    )
    fun getAccountAndTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFirst) {
            transactions.postValue(hardcodedTransactionList)
                accountData.postValue(hardCodedAccount[0])
                accountList.postValue(hardCodedAccount)
                isFirst = false
            }
        }
    }

    fun findAccountByName(name: String) {
        val foundAccount = hardCodedAccount.find { it.accountName == name }
        if (foundAccount != null) {
            accountData.postValue(foundAccount)
        }
    }
}
