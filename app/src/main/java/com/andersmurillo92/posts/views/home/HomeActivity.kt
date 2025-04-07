package com.andersmurillo92.posts.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andersmurillo92.posts.R
import com.andersmurillo92.posts.data.model.PostModel
import com.andersmurillo92.posts.databinding.ActivityHomeBinding
import com.andersmurillo92.posts.views.adapters.PostsAdapter
import com.andersmurillo92.posts.views.base.BaseActivity
import com.andersmurillo92.posts.views.interfaces.ItemActionListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: BaseActivity(), ItemActionListener {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val postsAdapter = PostsAdapter(this)
    lateinit var listOfPosts : List<PostModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeUI()
    }

    @SuppressLint("SetTextI18n")
    private fun initializeObservables(){
        viewModel.isLoading.observe(this) {
            if (!it) binding.progressBar.visibility = View.GONE
        }

        viewModel.posts.observe(this) {
            it?.let {
                listOfPosts = it
                postsAdapter.onUpdateData(listOfPosts)
            }
        }
    }

    private fun initializeUI() {
        initializeRecyclerView()
        initializeObservables()

        if (isOnline()) {
            viewModel.onCreate()
        } else {
            binding.progressBar.visibility = View.GONE
            showAlert(getString(R.string.message_not_connected))
        }
    }

    private fun initializeRecyclerView() {
        with(binding) {
            postsRv.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            postsRv.adapter = postsAdapter
        }
    }

    override fun onClickItem(item: Any, position: Int) {
        // TODO("Not yet implemented")
    }
}