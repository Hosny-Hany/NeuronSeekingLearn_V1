package com.route.neuronseekinglearn

data class ChatAppError(
    val message: String? = null,
    val throwable: Throwable? = null,
    val onTryAgainClickListener: OnTryAgainClickListener? = null
)

fun interface OnTryAgainClickListener {
    fun onTryAgainClick()
}