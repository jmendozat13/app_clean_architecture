package com.afoxplus.domain.entities.chat

enum class TypeMessage {
    LOADING,
    REQUEST,
    RESPONSE;

    companion object {
        fun valueOf(value: String) = values().find { it.name == value } ?: LOADING
    }

}