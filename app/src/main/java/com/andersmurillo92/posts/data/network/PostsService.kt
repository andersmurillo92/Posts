package com.andersmurillo92.posts.data.network

import android.util.Log
import com.andersmurillo92.posts.data.model.PostModel
import retrofit2.Response
import javax.inject.Inject

class PostsService @Inject constructor(private val postsApiClient: PostsApiClient) {

    companion object {
        private const val TAG = "----- PostsService -----"
    }

    suspend fun getPosts(): List<PostModel> =
        try {
            Log.i(TAG, "Method Called: getPosts()")
            val result: Response<List<PostModel>?> = postsApiClient.getPosts()
            Log.i(TAG, "$result")
            result.body() ?: emptyList()
        } catch (e: Exception) {
            Log.i(TAG, "Exception: $e")
            emptyList()
        }
}