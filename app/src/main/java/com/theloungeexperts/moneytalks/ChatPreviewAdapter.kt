package com.theloungeexperts.moneytalks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theloungeexperts.moneytalks.databinding.ChatPreviewBinding

class ChatPreviewAdapter : RecyclerView.Adapter<ChatPreviewAdapter.ChatPreviewHolder>() {
    private val chatPreviewList = ArrayList<ChatPreview>()

    class ChatPreviewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ChatPreviewBinding.bind(item)

        fun bind(chatPreview: ChatPreview) = with(binding) {
            avatar.setImageResource(chatPreview.avatarID)
            userName.text = chatPreview.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatPreviewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.chat_preview, parent, false)

        return ChatPreviewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatPreviewHolder, position: Int) {
        holder.bind(chatPreviewList[position])
    }

    override fun getItemCount(): Int {
        return chatPreviewList.size
    }

    fun addChatPreview(chatPreview: ChatPreview) {
        chatPreviewList.add(chatPreview)
        notifyDataSetChanged()
    }
}