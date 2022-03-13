package com.chandrasapplication.app.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.chandrasapplication.app.R
import com.chandrasapplication.app.databinding.LayoutProgressDialogBinding

/**
 * CustomProgressDialog file contains,
 * extension related to the progress dialog.
 */

/**
 * Context extension method to show progress dialog for long running tasks.
 * @param message string value to show message, the default message is "Loading..."
 * @param setCancellationOnTouchOutside the boolean value for dialog dismissed on outside click, the default value is false,
 * pass true, if dialog should be dismissed on outside click
 */
fun Context.showProgressDialog(
    message: String? = null,
    setCancellationOnTouchOutside: Boolean = false
): AlertDialog {
    AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
        .apply {
            val layoutInflater = LayoutInflater.from(this@showProgressDialog)
            val binding = LayoutProgressDialogBinding.inflate(layoutInflater, null, false)

            setView(binding.root)

            if (!message.isNullOrBlank()) {
                binding.message = message
            }
            val dialog = create()
            dialog.setCanceledOnTouchOutside(setCancellationOnTouchOutside)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            return dialog
        }
}