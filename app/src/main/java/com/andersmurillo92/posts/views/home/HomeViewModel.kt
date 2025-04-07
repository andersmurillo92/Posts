package com.andersmurillo92.posts.views.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andersmurillo92.posts.data.model.PostModel
import com.andersmurillo92.posts.domain.PostsUseCase
import com.andersmurillo92.posts.views.base.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postsUseCase: PostsUseCase): ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    val isLoading = MutableLiveData<Boolean>()
    val posts = MutableLiveData<List<PostModel>?>()

    var singleLiveEvent: SingleLiveEvent<ViewEvent> = SingleLiveEvent()

    fun onCreate(){
        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch {
            try {
                isLoading.value = true

                val result: List<PostModel>? = postsUseCase()
                posts.value = result

                isLoading.value = false
                singleLiveEvent.value = ViewEvent.Success()
            } catch (e: Exception){
                Log.e(TAG, "Exception $e")
                singleLiveEvent.value = ViewEvent.Error(e.message.toString())
            }
        }
    }

    sealed class ViewEvent {
        class Success: ViewEvent()
        class Error(val error: String?): ViewEvent()
    }
}