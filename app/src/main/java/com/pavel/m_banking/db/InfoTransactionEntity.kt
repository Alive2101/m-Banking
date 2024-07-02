package com.pavel.m_banking.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val INFO_TRANSACTION_ENTITY = "InfoTransactionEntity"
const val ACCOUNT_NAME = "accountName"
const val COMPANY_NAME = "companyName"
const val TRANSACTION_NUMBER = "transactionNumber"
const val RECEIVING_DATE = "receivingDate"
const val STATUS = "status"
const val AMOUNT = "amount"

@Entity(tableName = INFO_TRANSACTION_ENTITY)
class InfoTransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(ACCOUNT_NAME)
    val accountName: String,
    @ColumnInfo(COMPANY_NAME)
    val companyName: String,
    @ColumnInfo(TRANSACTION_NUMBER)
    val summa: String,
    @ColumnInfo(RECEIVING_DATE)
    val receivingDate: String,
    @ColumnInfo(STATUS)
    val status: String,
    @ColumnInfo(AMOUNT)
    val amount: String
)