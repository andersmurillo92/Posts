package com.andersmurillo92.posts.views.interfaces

import com.andersmurillo92.posts.data.model.PostModel

interface ItemActionListener {
    fun onClickItem(item:PostModel, position: Int)
}