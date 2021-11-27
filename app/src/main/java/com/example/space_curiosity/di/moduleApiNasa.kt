package com.example.space_curiosity.di

import com.example.space_curiosity.data.network.nasaServiceAPI
import com.example.space_curiosity.data.responseNasa
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object moduleApiNasa {


    @Singleton
    @Provides
    fun getRetrofit () : Retrofit {
        return Retrofit.Builder().baseUrl("https://api.nasa.gov/planetary/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    suspend fun getCall (): responseNasa {
        var valueResponse : responseNasa = responseNasa("-","-","-","-",
        "-","-","-","-")
        val call = getRetrofit().create(nasaServiceAPI::class.java).getService()
        if (call.isSuccessful){
            valueResponse  = call.body()!!
        }
        return valueResponse
    }

}