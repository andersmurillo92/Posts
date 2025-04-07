package com.andersmurillo92.posts.data.model

import java.io.Serializable

data class PostModel(
    var userId: Int? = 0,
    var id: Int? = 0,
    var title: String? = null,
    var body: String? = null,
): Serializable
