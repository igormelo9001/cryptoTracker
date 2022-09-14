package com.monnos.cryptotracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        val serviceNetwork = ServiceNetwork.buildService(ApiService::class.java)

        val call = serviceNetwork.getCoins()

        call.enqueue(object : Callback<MutableList<Model>> {
            override fun onResponse(
                call: Call<MutableList<Model>>,
                response: Response<MutableList<Model>>
            ) {
                if (response.isSuccessful){
                    Log.e("success", response.body().toString())
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = Adapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Model>>, t: Throwable) {
              t.printStackTrace()
                Log.e("error", t.message.toString())
            }

        })

    }
}