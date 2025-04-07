package com.andersmurillo92.posts.data.network

import com.andersmurillo92.posts.data.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface PostsApiClient {

    @GET("posts")
    suspend fun getPosts(): Response<List<PostModel>?>
}