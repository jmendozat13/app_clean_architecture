package com.afoxplus.appdemo.ui.chat.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.afoxplus.appdemo.ui.chat.viewholder.ChatLoadingViewHolder
import com.afoxplus.appdemo.ui.chat.viewholder.ChatRequestViewHolder
import com.afoxplus.appdemo.ui.chat.viewholder.ChatResponseViewHolder
import com.afoxplus.appdemo.ui.chat.viewholder.ChatViewHolder
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import com.afoxplus.domain.entities.chat.TypeMessage

class ChatBotAdapter(val user: User) :
    ListAdapter<Message, ChatViewHolder>(ChatBotDiffCallback()) {

    private var onClickMessageListener: OnClickMessageListener = OnClickMessageListener {}

    fun setOnClickMessageListener(listener: OnClickMessageListener) {
        onClickMessageListener = listener
    }

    override fun getItemViewType(position: Int): Int {
        val message = getItem(position)
        return message.type.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return when (TypeMessage.valueOf(viewType)) {
            TypeMessage.RESPONSE -> ChatResponseViewHolder.from(
                parent,
                onClickMessageListener,
                user
            )
            TypeMessage.REQUEST -> ChatRequestViewHolder.from(parent)
            TypeMessage.LOADING -> ChatLoadingViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class ChatBotDiffCallback : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem == newItem
}

fun interface OnClickMessageListener {
    fun onClick(option: OptionMessage)
}