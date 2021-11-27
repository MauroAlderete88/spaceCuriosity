package com.example.space_curiosity.data.network

import com.example.space_curiosity.data.responseNasa
import retrofit2.Response
import retrofit2.http.GET

interface nasaServiceAPI {
    @GET("apod?api_key=DEMO_KEY")
    suspend fun getService () : Response<responseNasa>

}