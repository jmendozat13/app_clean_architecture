package com.afoxplus.data.repository.account

import com.afoxplus.data.source.local.database.account.IUserLocalDataSource
import com.afoxplus.data.source.network.user.IUserNetworkDataSource
import com.afoxplus.data.source.network.user.request.UserRequest
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.repository.account.IUserRepository
import org.koin.core.inject

class UserRepository : IUserRepository {

    private val userLocalDataSource: IUserLocalDataSource by inject()
    private val userNetworkDataSource: IUserNetworkDataSource by inject()

    override suspend fun saveNetworkUser(user: User): User = userNetworkDataSource.createUser(
        UserRequest(
            username = user.name,
            externalId = user.name
        )
    )

    override suspend fun saveLocalUser(user: User) = userLocalDataSource.saveUser(user)


    override suspend fun getUser(): User? = userLocalDataSource.getUser()

}