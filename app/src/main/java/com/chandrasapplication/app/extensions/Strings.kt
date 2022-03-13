package com.chandrasapplication.app.extensions

import android.util.Patterns
import org.json.JSONObject
import java.util.regex.Pattern
import kotlin.Exception

/**
 * Strings file contains string utils and extension methods
 */

/**
 * Minimum 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character
 */
private val PASSWORD_PATTERN =
    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[`~#@$!%^*?&()+-_=<>,./';:{}|])[A-Za-z\\d`~#@$!%^*?&()+-_=<>,./';:{}|]{8,}$"

/**
 * the string extension method to identify the value is type of email pattern or not
 * @return boolean value if string value not match with the email pattern it returns false
 */
fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * the string extension method to identify the value is type of password pattern or not
 * @return boolean value if string value not match with the password pattern it returns false
 */
fun String.isPassword(): Boolean {
    return Pattern.compile(PASSWORD_PATTERN).matcher(this).matches()
}

/**
 * the string extension method to identify the jsonObject from the json string
 * @return boolean value if string value is not match with the jsonObject it returns false
 */
fun String.isJSONObject():Boolean{
    return try {
        JSONObject(this)
        true
    }catch (e:Exception){
        false
    }
}