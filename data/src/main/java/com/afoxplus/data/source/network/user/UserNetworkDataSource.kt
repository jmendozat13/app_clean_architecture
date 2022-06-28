package com.afoxplus.data.source.network.user

import com.afoxplus.data.source.network.core.BaseNetwork
import com.afoxplus.data.source.network.core.extension.onFailure
import com.afoxplus.data.source.network.core.extension.onSuccess
import com.afoxplus.data.source.network.user.request.UserRequest
import com.afoxplus.data.source.network.user.service.IUserService
import com.afoxplus.domain.core.exceptions.GenericException
import com.afoxplus.domain.entities.account.User
import org.koin.core.inject

class UserNetworkDataSource : IUserNetworkDataSource, BaseNetwork() {
    private val userService: IUserService by inject()

    override suspend fun createUser(userRequest: UserRequest): User {
        val response = userService.createUser(userRequest)
        var user: User? = null
        response.onSuccess { userResponse -> user = userResponse.toUserEntity() }
        response.onFailure { error -> throw error }
        return user ?: throw GenericException()
    }
}