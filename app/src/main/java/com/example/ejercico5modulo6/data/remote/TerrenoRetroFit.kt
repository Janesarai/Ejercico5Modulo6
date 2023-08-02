package com.example.ejercico5modulo6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TerrenoRetroFit {
    companion object {
        private const val URL_BASE =
            "https://android-kotlin-fun-mars-server.appspot.com/"

        fun getTerrenoRetrofit() : TerrenoAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(TerrenoAPI::class.java)
        }
    }
}