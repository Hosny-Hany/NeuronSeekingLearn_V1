package com.route.neuronseekinglearn.home.tabs.chatboat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.neuronseekinglearn.R

class ChatAdapter(private val messageList: List<com.route.neuronseekinglearn.home.tabs.chatboat.Message>) :
    RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]
        if (message.isUserMessage()) {
            holder.textMessage.setBackgroundResource(R.color.primaryColor)
        } else {
            holder.textMessage.setBackgroundResource(R.color.Secondarycolor)
        }
        holder.textMessage.text = message.getMessage()
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textMessage: TextView = itemView.findViewById(R.id.message_tv)
    }
}
