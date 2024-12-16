package com.example.composetest101.compose.test114.datamodels

data class QuoteResponse(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)