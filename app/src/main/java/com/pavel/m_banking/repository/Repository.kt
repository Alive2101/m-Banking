package com.pavel.m_banking.repository

import com.pavel.m_banking.db.AccountDao
import com.pavel.m_banking.db.InfoTransactionDao
import com.pavel.m_banking.db.InfoTransactionEntity
import com.pavel.m_banking.model.Account
import com.pavel.m_banking.model.Transaction
import javax.inject.Inject

class Repository @Inject constructor(
    private val accountDao: AccountDao,
    private val infoTransactionDao: InfoTransactionDao
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

    suspend fun addCity(
        accountName: String,
        companyName: String,
        transactionNumber: String,
        receivingDate: String,
        status: String,
        amount: String
    ) = infoTransactionDao.addItem(
        InfoTransactionEntity(
            0,
            accountName,
            companyName,
            transactionNumber,
            receivingDate,
            status,
            amount
        )
    )

    suspend fun getTransactionList(): ArrayList<Transaction> {
        return (infoTransactionDao.getAllItem().map {
            Transaction(
                it.accountName,
                it.companyName,
                it.summa,
                it.receivingDate,
                it.status,
                it.amount
            )
        } as? ArrayList<Transaction>) ?: arrayListOf()
    }

    suspend fun getLastFiveTransaction(): ArrayList<Transaction> {
        return (infoTransactionDao.getLastFiveTransaction().map {
            Transaction(
                it.accountName,
                it.companyName,
                it.summa,
                it.receivingDate,
                it.status,
                it.amount
            )
        } as? ArrayList<Transaction>) ?: arrayListOf()
    }

}