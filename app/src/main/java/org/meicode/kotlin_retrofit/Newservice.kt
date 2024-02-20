package org.meicode.kotlin_retrofit

import android.health.connect.datatypes.AppInfo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=apple&from=2023-12-12&to=2023-12-12&sortBy=popularity&apiKey=API_KEY

const val BASE_URL="https://newsapi.org/"
const val API_KEY="acbf05cb82074db292a102a8dcf3816b"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getheadlines(@Query("country")country: String, @Query("page")page: Int) : Call<apiResponse>

    //https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1
}
object Newservice{
    val newsInstance: NewsInterface  //reference
    init {
        val retrofit : Retrofit= Retrofit.Builder()//retrofit ka object
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}
