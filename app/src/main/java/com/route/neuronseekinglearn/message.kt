package com.route.neuronseekinglearn

data class message(
    val message: String? = null,
    val posActionName: String? = null,
    val OnPosAction: OnDialogActionClick? = null,
    val NegActionName: OnDialogActionClick? = null,
    val OnNegAction: OnDialogActionClick? = null,
    val IsCancelable: Boolean = true
)


fun interface OnDialogActionClick {
    fun OnActionClick()
}