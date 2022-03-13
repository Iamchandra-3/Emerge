package com.chandrasapplication.app.appcomponents.views

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.*

/**
 * the dialog which used to pick time from the user.
 */
class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private var defaultDate: Date? = null
    private var callback: ((selectedDate: Date) -> Unit)? = null

    /**
     * the override method here we are managing passed arguments and preparing the dialog.
     * @return the time picker dialog
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
        return TimePickerDialog(
            requireContext(),
            this,
            hour,
            minute,
            DateFormat.is24HourFormat(activity)
        )
    }

    /**
     * the override method which called when time selected from the user
     * @param view the time picker.
     * @param hourOfDay int value of hour.
     * @param minute int value of minute.
     */
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        defaultDate?.let {
            calendar.time = it
        }
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        callback?.invoke(calendar.time)
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
        public const val TAG: String = "TIME_PICKER_FRAGMENT"

        //dialog arguments constants
        private const val BUNDLE_DAY_OF_MONTH: String = "bundle_selected_day_of_month"
        private const val BUNDLE_MONTH: String = "bundle_selected_month"
        private const val BUNDLE_YEAR: String = "bundle_selected_year"
        private const val BUNDLE_HOURS_OF_DAY: String = "bundle_selected_hour_of_day"
        private const val BUNDLE_MINUTE: String = "bundle_selected_minute"

        /**
         * the companion class function which used to get instance of time picker.
         * @param defaultDate the default time to show.
         *
         * @return TimePickerFragment
         */
        public fun getInstance(defaultDate: Date? = null): TimePickerFragment {
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

            val fragment = TimePickerFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}