package com.monnos.cryptotracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceNetwork = ServiceNetwork.buildService(ApiService::class.java)

        val call = serviceNetwork.getCoins()

        call.enqueue(object : retrofit2.Callback<MutableList<Model>> {
            override fun onResponse(
                call: Call<MutableList<Model>>,
                response: Response<MutableList<Model>>
            ) {
                if (response.isSuccessful){
                    Log.e("success", response.body().toString())
                }
            }

            override fun onFailure(call: Call<MutableList<Model>>, t: Throwable) {
              t.printStackTrace()
                Log.e("error", t.message.toString())
            }

        })

    }
}