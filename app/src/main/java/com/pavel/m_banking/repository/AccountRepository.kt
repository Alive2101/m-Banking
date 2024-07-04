package com.pavel.m_banking.repository

import com.pavel.m_banking.db.AccountDao
import com.pavel.m_banking.model.Account
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountDao: AccountDao
) {
    suspend fun getAccountList(): ArrayList<Account> {
        return (accountDao.getAllItem().map {
            Account(it.accountName, it.accountNumber, it.cardNumber)
        } as? ArrayList<Account>) ?: arrayListOf()
    }

    suspend fun getAccountByName(name: String): Account? {
        val accountEntity = accountDao.findValue(name)
        return accountEntity?.let {
            Account(it.accountName, it.accountNumber, it.cardNumber)
        }
    }
}