package com.andersmurillo92.posts.data.model

import java.io.Serializable

data class ResponseModel(
    var list: List<PostModel> = emptyList()
):Serializable
