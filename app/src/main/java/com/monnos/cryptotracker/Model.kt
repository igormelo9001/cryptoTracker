package com.monnos.cryptotracker

import java.util.*

data class Model(
    val id: String? = null,
    val symbol: Any? = null,
    val priceIndex: Float? = null,
    val priceIndexString: String? = null,
    val lastDayPriceIndexChangePercent: Float? = null,
    val lastWeekPriceIndexChangePercent: Float? = null,
    val counterAssetRank: Long? = null,
    val date: Date? = null
)

