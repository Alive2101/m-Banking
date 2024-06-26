package com.pavel.m_banking.model

data class Transaction (
    val companyName : String,
    val summa : String,
    val recivingDate : String,
    val status : TransactionStatus
)

enum class TransactionStatus {
    EXECUTED,
    DECLINE,
    IN_PROGRESS
}
