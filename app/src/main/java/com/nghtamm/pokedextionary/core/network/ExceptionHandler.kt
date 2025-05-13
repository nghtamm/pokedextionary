package com.nghtamm.pokedextionary.core.network

import okio.IOException
import retrofit2.HttpException

object ExceptionHandler {
    fun parse(error: Throwable): String {
        return when (error) {
            is HttpException -> {
                when (error.code()) {
                    400 -> "400 Bad Request"
                    401 -> "401 Unauthorized"
                    403 -> "403 Forbidden"
                    404 -> "404 Not Found"
                    405 -> "405 Method Not Allowed"
                    500 -> "500 Internal Server Error"
                    else -> "${error.code()} ${error.message()}"
                }
            }

            is IOException -> "Network error occurred. Please check your internet connection."
            else -> "Unexpected error: ${error.localizedMessage}"
        }
    }
}