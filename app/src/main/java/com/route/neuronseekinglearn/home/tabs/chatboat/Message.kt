package com.route.neuronseekinglearn.home.tabs.chatboat

class Message(
    private val message: String,
    private val isUserMessage: Boolean
) {
    fun getMessage(): String = message

    fun isUserMessage(): Boolean = isUserMessage
}