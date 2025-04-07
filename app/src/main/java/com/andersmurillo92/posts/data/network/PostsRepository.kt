package com.andersmurillo92.posts.data.network

import android.util.Log
import com.andersmurillo92.posts.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostsRepository @Inject constructor(private val postsService: PostsService) {

    companion object {
        private const val TAG = "----- PostsRepository -----"
    }

    suspend fun getPosts(): List<PostModel> =
        withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "Method Called: getPosts()")
                val result: List<PostModel> = postsService.getPosts()
                Log.i(TAG, "$result")
                result
            } catch (e: Exception) {
                Log.i(TAG, "Exception: $e")
                emptyList()
            }
        }
}