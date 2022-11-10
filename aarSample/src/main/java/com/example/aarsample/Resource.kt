package com.example.aarsample

internal data class Resource<out T>(
    val status: Status,
    val data: String,
    val message: String?,
    val code: Int?
) {
    companion object {

        fun <T> success(data: String): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String, data: String, code: Int): Resource<T> {
            return Resource(Status.ERROR, data, msg, code)
        }
    }
}