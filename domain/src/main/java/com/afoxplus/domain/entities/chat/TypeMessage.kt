package com.afoxplus.domain.entities.chat

enum class TypeMessage(val id: Int) {
    LOADING(id = 0),
    REQUEST(id = 1),
    RESPONSE(id = 2);

    companion object {
        fun valueOf(id: Int) = values().find { it.id == id } ?: LOADING
    }

}