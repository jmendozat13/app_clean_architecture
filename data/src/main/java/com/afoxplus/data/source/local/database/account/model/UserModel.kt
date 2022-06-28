package com.afoxplus.data.source.local.database.account.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afoxplus.domain.entities.account.User
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserModel(
    @SerializedName("name") val name: String,
    @SerializedName("userExternalId") val userExternalId: String,
    @PrimaryKey
    @SerializedName("id") val id: Int = 0
) {
    fun toUser(): User = User(name, userExternalId, id)
}