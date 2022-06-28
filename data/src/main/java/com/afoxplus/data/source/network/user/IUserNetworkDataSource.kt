package com.afoxplus.data.source.network.user

import com.afoxplus.data.source.network.core.NetworkBaseDataSource
import com.afoxplus.data.source.network.user.request.UserRequest
import com.afoxplus.domain.entities.account.User

interface IUserNetworkDataSource : NetworkBaseDataSource {
    suspend fun createUser(userRequest: UserRequest): User
}