package com.mramallo.moviesapp.data.network

import android.util.Log
import com.mramallo.moviesapp.utils.Resource
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception
import kotlin.math.log

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend() -> Response<T>): Resource<T> {
        try {
            val response = call()
            if(response.isSuccessful) {
                val body = response.body()
                Log.d("APIRESULT", "body result -->> $body")
                if(body != null) return Resource.success(body)
            }

            return error("${response.code()}  ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.e(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }

}