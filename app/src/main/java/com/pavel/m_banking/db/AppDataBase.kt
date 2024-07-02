package com.pavel.m_banking.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AccountEntity::class, InfoTransactionEntity::class], version = 3)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getAccountDao(): AccountDao
    abstract fun getInfoTransactionDao(): InfoTransactionDao

}
