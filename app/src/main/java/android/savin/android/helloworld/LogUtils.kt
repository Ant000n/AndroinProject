package android.savin.android.helloworld

import android.util.Log

fun Any.logDebag(message: String) {
    Log.d(this::class.java.name,message)
}