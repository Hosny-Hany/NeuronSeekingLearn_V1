package com.route.neuronseekinglearn

import android.app.Activity
import android.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showDialog(
    message: String,
    posMessage: String? = null,
    posAction: OnDialogActionClick? = null,
    negMessage: String? = null,
    negAction: OnDialogActionClick? = null

): AlertDialog {
    val dialog = AlertDialog.Builder(context)
    dialog.setMessage(message)
    if (posMessage != null) {
        dialog.setPositiveButton(posMessage)
        { dialog, id ->
            dialog.dismiss()
            posAction?.OnActionClick()
        }
    }
    if (negMessage != null) {
        dialog.setNegativeButton(negMessage)
        { dialog, id ->
            dialog.dismiss()
            negAction?.OnActionClick()
        }

    }
    return dialog.show()
}

fun Activity.showDialog(
    Message: String,
    posMessage: String? = null,
    posAction: OnDialogActionClick? = null,
    negMessage: String? = null,
    negAction: OnDialogActionClick? = null,
    isCancellable: Boolean = true
): AlertDialog {
    val dialog = AlertDialog.Builder(this)
    if (posMessage != null) {
        dialog.setPositiveButton(posMessage)
        { dialog, id ->
            dialog.dismiss()
            posAction?.OnActionClick()
        }
    }
    if (negMessage != null) {
        dialog.setNegativeButton(negMessage)
        { dialog, id ->
            dialog.dismiss()
            negAction?.OnActionClick()
        }

    }
    dialog.setCancelable(isCancellable)
    return dialog.show()
}