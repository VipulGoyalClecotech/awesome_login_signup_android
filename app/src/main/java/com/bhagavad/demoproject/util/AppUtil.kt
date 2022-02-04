package com.bhagavad.demoproject.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.bhagavad.demoproject.R


class AppUtil {

    companion object {
        private var toast: Toast? = null
        var mLastClickTime = 0L

        //these method is to start new intent
        fun startIntent(
            bundle: Bundle?,
            mSourceActivity: Activity,
            destinationClass: Class<*>?
        ) {
            val mainIntent = Intent(mSourceActivity, destinationClass)
            if (bundle != null) mainIntent.putExtras(bundle)
            mSourceActivity.startActivity(mainIntent)
            mSourceActivity.overridePendingTransition(
                R.anim.slide_out_left_anim,
                R.anim.slide_in_right_anim
            )
        }

        //these method is to start new intent for result
        fun startIntentForResult(
            bundle: Bundle?,
            mSourceActivity: Activity,
            destinationClass: Class<*>?,
            requestCode: Int
        ) {
            val mainIntent = Intent(mSourceActivity, destinationClass)
            if (bundle != null) mainIntent.putExtras(bundle)
            mSourceActivity.startActivityForResult(mainIntent, requestCode)
            mSourceActivity.overridePendingTransition(
                R.anim.slide_in_right_anim,
                R.anim.slide_out_left_anim
            )
        }

        //these method is to hide keyboard
        fun hideSoftKeyBoard(context: Context, view: View) {
            try {
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            } catch (e: Exception) {
                // TODO: handle exception
                e.printStackTrace()
            }
        }

        fun hideKeyboard(activity: Activity) {
            try {
                val view = activity.currentFocus
                if (view != null) {
                    val imm =
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
            } catch (ex: java.lang.Exception) {
                ex.printStackTrace()
            }
        }



    }
}