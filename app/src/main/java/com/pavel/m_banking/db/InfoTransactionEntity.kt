package com.pavel.m_banking.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "InfoTransactionEntity")
class InfoTransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("companyName")
    val companyName: String,
    @ColumnInfo("summa")
    val summa: String,
    @ColumnInfo("receivingDate")
    val receivingDate: String,
    @ColumnInfo("status")
    val status: String,
)