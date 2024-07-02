package com.pavel.m_banking.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.model.Transaction
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

    fun getAccountAndTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFirst) {
                transactions.postValue(repository.getLastFiveTransaction())
                accountData.postValue(repository.getAccountList()[0])
                accountList.postValue(repository.getAccountList())
                isFirst = false
            }
        }
    }

    fun findAccountByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            accountData.postValue(repository.getAccountByName(name))
        }
    }
}
