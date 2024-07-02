package com.pavel.m_banking.model

data class Transaction (
    val accountName : String,
    val companyName : String,
    val transactionNumber : String,
    val receivingDate : String,
    val status : String,
    val amount : String
)