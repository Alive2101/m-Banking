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

}