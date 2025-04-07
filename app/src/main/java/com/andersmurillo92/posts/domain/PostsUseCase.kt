package com.andersmurillo92.posts.domain

import com.andersmurillo92.posts.data.model.ResponseModel
import com.andersmurillo92.posts.data.network.PostsRepository
import javax.inject.Inject

class PostsUseCase @Inject constructor(private val postsRepository: PostsRepository){

    companion object {
        private const val TAG = "PostsUseCase"
    }

    private var result: ResponseModel? = null

    suspend operator fun invoke(): ResponseModel? = try {
        result = postsRepository.getPosts()
        result
    } catch (e: Exception){
        result
    }
}