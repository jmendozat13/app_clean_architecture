package com.afoxplus.data.source.network.user.request

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("username")val username: String,
    @SerializedName("userExternalId")val externalId: String)