package com.afoxplus.data.source.network.user.response

import com.afoxplus.domain.entities.account.User
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("userExternalId") val externalId: String
) {

    fun toUserEntity(): User = User(
        name = username,
        userExternalId = id
    )
}