package com.monnos.cryptotracker

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("tickers?allBase=BRL&marketType=CRYPTO")
    fun getCoins() :Call<MutableList<Model>>

}