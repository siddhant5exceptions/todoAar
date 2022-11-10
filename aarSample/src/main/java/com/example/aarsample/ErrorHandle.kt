package com.example.aarsample

import kotlinx.coroutines.CoroutineExceptionHandler
import org.json.JSONObject

internal class ErrorHandle {

    /**
     * handle the all type of errors code
     * @param code  Error code
     * @param data  error response from the server
     * @param order  indicate which api need to recall
     * @return void
     */
    fun handled(code: String, data: String,order:Int) {
        when (code) {
            ErrorType.ERROR_INVALID_DATA.intValue.toString() -> {


            }
            ErrorType.ERROR_UNAUTHORIZED.intValue.toString() -> {


            }
            ErrorType.ERROR_FORBIDDEN.intValue.toString() -> {

            }
            ErrorType.ERROR_INTERNAL_SERVER_ERROR.intValue.toString() -> {

            }
            else -> {

            }
        }
    }

    /**
     * @return exceptions
     */
    fun coroutineException(): CoroutineExceptionHandler {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            LogUtil.printLog("Error=>",throwable.message.toString())
        }
        return coroutineExceptionHandler
    }
}