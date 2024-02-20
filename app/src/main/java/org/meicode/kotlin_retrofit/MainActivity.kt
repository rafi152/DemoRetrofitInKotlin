package org.meicode.kotlin_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = Newservice.newsInstance.getheadlines("in",5)
        news.enqueue(object:Callback<apiResponse>{
            override fun onResponse(call: Call<apiResponse>, response: Response<apiResponse>) {
                val news=response.body()
                if (news!=null){
                    Log.d("rafi",news.toString())
                }
            }
            override fun onFailure(call: Call<apiResponse>, t: Throwable) {
                Log.d("rafi","error in fetching news",t)
            }
        })
    }
}