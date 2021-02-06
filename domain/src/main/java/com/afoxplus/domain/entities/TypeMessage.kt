package com.afoxplus.domain.entities

enum class TypeMessage {
    LOADING,
    REQUEST,
    RESPONSE;

    companion object {
        fun valueOf(value: String) = values().find { it.name == value } ?: LOADING
    }

}