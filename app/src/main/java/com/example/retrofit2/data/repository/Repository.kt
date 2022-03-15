package com.example.retrofit2.data.repository

import android.util.Log
import com.example.retrofit2.data.api.RetrofitInstance
import com.example.retrofit2.model.beznal.Beznal
import com.example.retrofit2.model.nal.Nal
import retrofit2.Response

class Repository {

    suspend fun getNal():Response<Nal>{
        return RetrofitInstance.api.getNalMoneys()
    }
    suspend fun getBezNal():Response<Beznal>{
        return RetrofitInstance.api.getBeznalMoneys()
    }
}