package com.afoxplus.domain.core.exceptions

class ApiNetworkException(
    val code: Int,
    override val message: String = "",
    val name: String = ""
) : Exception(message)