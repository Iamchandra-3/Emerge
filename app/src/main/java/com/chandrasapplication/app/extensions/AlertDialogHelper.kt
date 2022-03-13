package com.chandrasapplication.app.extensions

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

/**
 * AlertDialogHelper file contains,
 * easy to use dialog extensions.
 */

/**
 * Context extension method used to create the alert dialog
 * @param title the string value for dialog title.
 * @param message the string value for dialog message.
 * @param dialogBuilder the builder callback used to build dialog with passed arguments and style.
 */
fun Context.alert(
    title:String,
    message:String,
    dialogBuilder: AlertDialog.Builder.() -> Unit
) {
    AlertDialog.Builder(this)
        .apply {
            setTitle(title)
            setMessage(message)
            setCancelable(false)
            dialogBuilder()
            create()
            show()
        }
}


/**
 * AlertDialog.Builder extension method which handle the negative button click of the dialog
 * @param text the string value for negative button.
 * @param handleClick the callback for dialog click.
 */
fun AlertDialog.Builder.negativeButton(
    text: String = "Cancel",
    handleClick: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    this.setNegativeButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
}

/**
 * AlertDialog.Builder extension method which handle the positive button click of the dialog
 * @param text the string value for positive button.
 * @param handleClick the callback for dialog click.
 */
fun AlertDialog.Builder.positiveButton(
    text: String = "Yes",
    handleClick: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    this.setPositiveButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
}

/**
 * AlertDialog.Builder extension method which handle the neutral button click of the dialog
 * @param text the string value for neutral button.
 * @param handleClick the callback for dialog click.
 */
fun AlertDialog.Builder.neutralButton(
    text: String = "OK",
    handleClick: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    this.setNeutralButton(text) { dialogInterface, _ -> handleClick(dialogInterface) }
}