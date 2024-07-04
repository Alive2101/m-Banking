package com.pavel.m_banking.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.model.Transaction
import com.pavel.m_banking.repository.AccountRepository
import com.pavel.m_banking.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val transactionRepository: TransactionRepository,
) : ViewModel() {

    val transactions = MutableLiveData<List<Transaction>>()
    var accountData = MutableLiveData<Account?>()
    var accountList = MutableLiveData<List<Account>>()
    private var isFirst = true

    fun getAccountAndTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFirst) {
                transactions.postValue(transactionRepository.getTransactionList())
                accountData.postValue(accountRepository.getAccountList()[0])
                accountList.postValue(accountRepository.getAccountList())
                isFirst = false
            }
        }
    }

    fun findAccountByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            accountData.postValue(accountRepository.getAccountByName(name))
            transactions.postValue(transactionRepository.getLastFiveTransaction(name))
        }
    }
}
