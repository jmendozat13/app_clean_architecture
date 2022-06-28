package com.afoxplus.domain.entities.account

data class User(val name: String, val userExternalId: String = "", val id: Int = 0) {
    companion object {
        fun getUserDemo() = User("Demo")
    }
}