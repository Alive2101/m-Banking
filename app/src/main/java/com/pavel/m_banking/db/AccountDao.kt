package com.pavel.m_banking.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {

    @Insert
    suspend fun addItem(item: AccountEntity)

    @Query("SELECT * FROM AccountEntity")
    suspend fun getAllItem(): List<AccountEntity>

    @Query("SELECT * FROM AccountEntity WHERE accountName = :name")
    suspend fun findValue(name: String): AccountEntity?


}