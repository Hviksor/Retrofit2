package com.example.retrofit2.data.api

import com.example.retrofit2.model.beznal.Beznal
import com.example.retrofit2.model.nal.Nal
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getNalCourse(): Response<Nal>

    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getBezNalCourse(): Response<Beznal>
}