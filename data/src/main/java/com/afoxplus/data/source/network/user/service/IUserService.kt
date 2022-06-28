package com.afoxplus.data.source.network.user.service

import com.afoxplus.data.source.network.user.request.UserRequest
import com.afoxplus.data.source.network.user.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IUserService {
    @POST("user")
    suspend fun createUser(@Body userRequest: UserRequest): Response<UserResponse>
}