package com.pavel.m_banking.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AccountEntity")
class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("accountName")
    val accountName: String,
    @ColumnInfo("accountNumber")
    val accountNumber: String,
    @ColumnInfo("cardNumber")
    val cardNumber: String
)