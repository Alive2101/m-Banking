package com.pavel.m_banking.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ACCOUNT_ENTITY = "AccountEntity"
const val ACCOUNT_NUMBER = "accountNumber"
const val CARD_NUMBER = "AccountEntity"

@Entity(tableName = ACCOUNT_ENTITY)
class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(ACCOUNT_NAME)
    val accountName: String,
    @ColumnInfo(ACCOUNT_NUMBER)
    val accountNumber: String,
    @ColumnInfo(CARD_NUMBER)
    val cardNumber: String
)