package com.example.aarsample

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException


internal class NetworkClient {
    private val contentType = "application/json"
    private var mHostName = ""
    private val accept = "application/json"

    /**
     * POST network request
     * @param url String api end point
     * @param body JSONObject request body
     * @return response
     */

    @Throws(IOException::class)
    fun getMethodCall(url: String?) : Resource<Any> {
        getHostName(url!!)
        // OkHttp 3.3.x and higher
        val client = OkHttpClient().newBuilder()
            .build()
        val request: Request = Request.Builder()
            .url(url)
            .build()
        //        request = setHeader(request);
        val response = client.newCall(request).execute()
        val decrypted = response.body!!.string().trim { it <= ' ' }
        LogUtil.printLog("response decpript", decrypted)
        if (response.code == 200) {
            return Resource.success(decrypted)
        } else {
            return Resource.error(response.message, decrypted, response.code);
        }
    }

    @Throws(IOException::class)
    fun postMethodCall(url: String, body: JSONObject): Resource<Any> {
        val client = OkHttpClient().newBuilder()
            .build()
        val strOldBody = body.toString()
        val mediaType = "application/json;charset=utf-8".toMediaTypeOrNull()
        val newEncryptedBody: RequestBody = RequestBody.create(mediaType, strOldBody)
        LogUtil.printLog("URL => ", url)
        LogUtil.printLog("REQUEST => ", strOldBody)
        var request: Request? = Request.Builder()
            .url(url)
            .post(newEncryptedBody)
            .build()
        request = request?.let { setHeader(it, newEncryptedBody) }
        val response = client.newCall(request!!).execute()
        val decrypted = response.body!!.string().trim { it <= ' ' }
        LogUtil.printLog("RESPONSE => ", decrypted)
        LogUtil.printLog("response decpript", "$newEncryptedBody  $decrypted")
        LogUtil.printLog("upload ", url)
        if (response.code == 200) {
            return Resource.success(decrypted)
        } else {
            return Resource.error(response.message, decrypted, response.code);
        }
    }

    /**
     * Set Header Details
     *
     * @param requestHeader Request
     * @param requestBody RequestBody
     * @return Request
     */
    private fun setHeader(requestHeader: Request, requestBody: RequestBody): Request? {
        var requestHeader = requestHeader
        val requestBuilder = requestHeader.newBuilder()
        requestBuilder.addHeader("Content-Type", contentType)
        requestBuilder.addHeader("Accept", accept)
        requestBuilder.method(requestHeader.method, requestBody)
        requestHeader = requestBuilder.build()
        LogUtil.printLog("Header => ", requestHeader.headers.toString())
        return requestHeader
    }


    /**
     * Get Hostname
     *
     * @param url String
     * @return void
     */
    private fun getHostName(url: String) {
        try {
            val uri = URI(url)
            mHostName = uri.getHost()
            LogUtil.printLog("Host Name Custom HTTP client", " :$mHostName")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }
}