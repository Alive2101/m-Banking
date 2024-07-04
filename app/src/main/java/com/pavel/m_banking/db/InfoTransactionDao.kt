package com.pavel.m_banking.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InfoTransactionDao {

    @Insert
    suspend fun addItem(item: InfoTransactionEntity)

    @Query("SELECT * FROM InfoTransactionEntity")
    suspend fun getAllItem(): List<InfoTransactionEntity>

    @Query("SELECT * FROM InfoTransactionEntity WHERE accountName = :accountName ORDER BY id DESC LIMIT 5")
    suspend fun getLastFiveTransactionsByAccountName(accountName: String): List<InfoTransactionEntity>

    @Query("SELECT * FROM InfoTransactionEntity WHERE transactionNumber = :name")
    suspend fun findValue(name: String): List<InfoTransactionEntity>

    @Query("SELECT * FROM InfoTransactionEntity WHERE accountName = :name ")
    suspend fun getTransactionInfo(
        name: String,
    ): List<InfoTransactionEntity>

    @Query("SELECT * FROM InfoTransactionEntity WHERE accountName = :accountName " +
            "and receivingDate BETWEEN :startDate AND :endDate")
    suspend fun getTransactionsBetweenDates(
        startDate: String,
        endDate: String,
        accountName:String
    ): List<InfoTransactionEntity>
}

