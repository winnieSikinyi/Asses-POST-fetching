package com.example.apkfetch.apis

object ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterfactory(GsonConverterFactory.create())
        .build()
    fun <T>buildClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }



}