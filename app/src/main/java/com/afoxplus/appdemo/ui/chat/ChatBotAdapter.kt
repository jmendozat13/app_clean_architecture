package com.afoxplus.appdemo.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afoxplus.appdemo.databinding.RowChatInputBinding
import com.afoxplus.appdemo.util.extensions.gone
import com.afoxplus.appdemo.util.extensions.visible
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import com.afoxplus.domain.entities.chat.TypeMessage

class ChatBotAdapter : ListAdapter<Message, ChatBotAdapter.ViewHolder>(ChatBotDiffCallback()) {

    private var onClickMessageListener: OnClickMessageListener = OnClickMessageListener {}

    fun setOnClickMessageListener(listener: OnClickMessageListener) {
        onClickMessageListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent, onClickMessageListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder private constructor(
        private val binding: RowChatInputBinding,
        private val onClickMessage: OnClickMessageListener
    ) : RecyclerView.ViewHolder(binding.root) {
        private val adapterOptions: ChatBotOptionAdapter by lazy { ChatBotOptionAdapter() }
        fun bind(item: Message) {
            binding.message = item
            binding.adapterOption = adapterOptions
            adapterOptions.setOnClickOptionListener { option ->
                onClickMessage.onClick(option)
            }
            when (item.type) {
                TypeMessage.RESPONSE -> {
                    binding.responseMessage.visible()
                    binding.requestMessage.gone()
                    binding.loadingMessage.gone()
                }
                TypeMessage.LOADING -> {
                    binding.responseMessage.gone()
                    binding.requestMessage.gone()
                    binding.loadingMessage.visible()
                }

                TypeMessage.REQUEST -> {
                    binding.responseMessage.gone()
                    binding.requestMessage.visible()
                    binding.loadingMessage.gone()
                }
            }
            adapterOptions.submitList(item.options)
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, onClickMessage: OnClickMessageListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowChatInputBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, onClickMessage)
            }
        }
    }
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