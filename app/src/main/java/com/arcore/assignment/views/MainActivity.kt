package com.arcore.assignment.views

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.arcore.assignment.R
import com.arcore.assignment.models.JokeResponse
import com.arcore.assignment.networking.ApiService
import com.arcore.assignment.networking.RetrofitNetwork
import com.arcore.assignment.recyclerview.Adapter
import com.arcore.assignment.recyclerview.OnLongClickListener
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnLongClickListener {
    val jokeList = mutableListOf<JokeResponse>()
    lateinit var jokeAdapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        btnGetJoke.setOnClickListener {
            getTheJoke()
        }

    }

    private fun setRecyclerView() {
        jokeAdapter = Adapter(jokeList, this)
        jokeRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(
                    this@MainActivity
                )

            adapter = jokeAdapter
        }
    }

    private fun getTheJoke() {
        val apiClient = RetrofitNetwork.getInstance().create(ApiService::class.java)
        apiClient.getJoke().enqueue(object : Callback<JokeResponse> {
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                response.body()?.let {
                    Log.d("tag", "response")
                    val jokeRes = it
                    jokeList.add(0, it)
                    jokeAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                Log.d("tag", "OnFailure")
            }

        })
    }

    override fun onLongClickListener(position: Int) {
        jokeList.removeAt(position)
        jokeAdapter.notifyDataSetChanged()
    }
}