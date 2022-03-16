package com.example.retrofit2.data.repository

import com.example.retrofit2.data.api.RetrofitInstance
import com.example.retrofit2.model.beznal.Beznal
import com.example.retrofit2.model.nal.Nal
import retrofit2.Response

class Repository {
    suspend fun getNalCourse(): Response<Nal> {
        return RetrofitInstance.api.getNalCourse()
    }

    suspend fun getBezNalCourse(): Response<Beznal> {
        return RetrofitInstance.api.getBezNalCourse()
    }
}