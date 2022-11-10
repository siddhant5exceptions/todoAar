package com.example.aarsample

import android.util.Log


internal class LogUtil {

    companion object {
        private val isEnableLogs = true

        fun printLog(tag: String?, `object`: Any?) {
            if (isEnableLogs && `object` != null) {
                Log.d(tag, "" + `object`)
            }
        }

        fun printLog(tag: String?, `object`: String?) {
            if (isEnableLogs && `object` != null) {
                Log.d(tag, "" + `object`)
            }
        }

        fun printLog(tag: String?, `object`: String?, tr: Throwable?) {
            if (isEnableLogs && `object` != null) {
                LogUtil.printLog(tag, "" + `object`)
            }
        }
    }
}
