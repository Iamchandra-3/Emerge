package com.chandrasapplication.app.appcomponents.views

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.*

/**
 * the dialog which used to pick date from the user.
 */
class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var defaultDate: Date? = null
    private var callback: ((selectedDate: Date) -> Unit)? = null

    /**
     * the override method here we are managing passed arguments and preparing the dialog.
     * @return the date picker dialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        c.time = Date()

        var year = arguments?.getInt(BUNDLE_YEAR, -1) ?: -1
        var month = arguments?.getInt(BUNDLE_MONTH, -1) ?: -1
        var dayOfMonth = arguments?.getInt(BUNDLE_DAY_OF_MONTH, -1) ?: -1
        var hour = arguments?.getInt(BUNDLE_HOURS_OF_DAY, -1) ?: -1
        var minute = arguments?.getInt(BUNDLE_MINUTE, -1) ?: -1

        year = if (year != -1) year else c.get(Calendar.YEAR)
        month = if (month != -1) month else c.get(Calendar.MONTH)
        dayOfMonth = if (dayOfMonth != -1) dayOfMonth else c.get(Calendar.DAY_OF_MONTH)
        hour = if (hour != -1) hour else c.get(Calendar.HOUR_OF_DAY)
        minute = if (minute != -1) minute else c.get(Calendar.MINUTE)

        c.set(year, month, dayOfMonth, hour, minute)
        defaultDate = c.time
        return DatePickerDialog(requireContext(), this, year, month, dayOfMonth)
    }

    /**
     * this override method will be called after user select the date.
     * This will invoke the interface also to handle the selected date on controller.
     */
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val calendar = Calendar.getInstance()
        defaultDate?.let {
            calendar.time = it
        }
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)
        if (arguments?.getBoolean(BUNDLE_INCLUDE_TIME_PICKER, false) == true) {
            TimePickerFragment.getInstance(calendar.time)
                .show(parentFragmentManager, TimePickerFragment.TAG) {
                    callback?.invoke(it)
                }
        } else {
            callback?.invoke(calendar.time)
        }
    }

    /**
     * the method is used to show the dialog,
     * @param manager the fragment manager.
     * @param tag the string of dialog tag
     * @param callback which used to handle event of selected date.
     *
     * to use : show(supportFragmentManager,null){selectedDate ->  }
     */
    fun show(
        manager: FragmentManager, tag: String?,
        callback: (selectedDate: Date) -> Unit
    ) {
        super.show(manager, tag)
        this.callback = callback
    }

    public companion object {
        public const val TAG: String = "DATE_PICKER_FRAGMENT"

        //dialog arguments constants
        private const val BUNDLE_INCLUDE_TIME_PICKER: String = "bundle_include_time_picker"
        private const val BUNDLE_DAY_OF_MONTH: String = "bundle_selected_day_of_month"
        private const val BUNDLE_MONTH: String = "bundle_selected_month"
        private const val BUNDLE_YEAR: String = "bundle_selected_year"
        private const val BUNDLE_HOURS_OF_DAY: String = "bundle_selected_hour_of_day"
        private const val BUNDLE_MINUTE: String = "bundle_selected_minute"

        /**
         * the companion class function which used to get instance of date picker.
         * @param includeTimePicker the boolean value to identify pick date with time picker.
         * @param defaultDate the default date to show.
         *
         * @return DatePickerFragment
         */
        public fun getInstance(
            includeTimePicker: Boolean = false,
            defaultDate: Date? = null
        ): DatePickerFragment {
            val bundle = Bundle()
            defaultDate?.let {
                val c = Calendar.getInstance()
                c.time = it
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val hoursOfDay = c.get(Calendar.HOUR_OF_DAY)
                val minutes = c.get(Calendar.MINUTE)
                bundle.putInt(BUNDLE_YEAR, year)
                bundle.putInt(BUNDLE_MONTH, month)
                bundle.putInt(BUNDLE_DAY_OF_MONTH, day)
                bundle.putInt(BUNDLE_HOURS_OF_DAY, hoursOfDay)
                bundle.putInt(BUNDLE_MINUTE, minutes)
            }
            bundle.putBoolean(BUNDLE_INCLUDE_TIME_PICKER, includeTimePicker)


            val fragment = DatePickerFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}