package com.afoxplus.data.source.network.music.service

import com.afoxplus.data.source.network.music.response.TunesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesService {

    @GET("search")
    suspend fun search(
        @Query("term") query: String,
        @Query("mediaType") mediaType: String,
        @Query("offset") page: Int,
        @Query("limit") itemsPerPage: Int
    ): Response<TunesResponse>
}