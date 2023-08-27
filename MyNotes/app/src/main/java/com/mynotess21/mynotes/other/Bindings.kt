package com.mynotess21.mynotes.other

import android.text.TextUtils
import android.util.Log
import androidx.databinding.InverseMethod

@InverseMethod("convertIntegerToString")
fun convertStringToInteger(value: String): Int? {
    Log.d("integer livedata", "convertStringToInteger: $value")
    if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
        return null
    }
    return value.toIntOrNull()
}

fun convertIntegerToString(value: Int?): String {
    return value?.toString() ?: ""
    Log.d("integer livedata", "convertIntegerToString: $value")

}

@InverseMethod("convertDoubleToString")
fun convertStringToDouble(value: String): Double? {
    Log.d("double livedata", "convertStringToDouble: $value")
    if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
        return null
    }
    return value.toDoubleOrNull()
}

fun convertDoubleToString(value: Double?): String {
    return value?.toString() ?: ""
    Log.d("double livedata", "convertDoubleToString: $value")

}