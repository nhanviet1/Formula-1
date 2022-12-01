package com.example.formula1.utils

import android.content.Context
import android.widget.Toast

fun Context.shortToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}
