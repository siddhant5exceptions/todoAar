package com.example.aarsample

/**
 * General errorType enum
 */
internal enum class ErrorType(val stringValue: String, val intValue: Int) {
    ERROR_RATE_LIMITED("err_rate_limited", 429),
    ERROR_UNAUTHORIZED("err_unauthorized", 401),
    ERROR_INVALID_DATA("err_invalid_data", 400),
    ERROR_FORBIDDEN("err_forbidden", 403),
    ERROR_INTERNAL_SERVER_ERROR("err_internal_server_error", 500);

    override fun toString(): String {
        return stringValue
    }
}