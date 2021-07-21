package com.afoxplus.appdemo.ui.chat.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afoxplus.domain.entities.chat.Message

abstract class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(message: Message)
}