package com.andersmurillo92.posts.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andersmurillo92.posts.R
import com.andersmurillo92.posts.data.model.PostModel
import com.andersmurillo92.posts.databinding.ItemPostBinding
import com.andersmurillo92.posts.views.interfaces.ItemActionListener

class PostsAdapter(private val itemActionListener: ItemActionListener) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private val list = mutableListOf<PostModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post, parent, false
            ), parent, itemActionListener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            itemActionListener.onClickItem(item, position)
        }
    }

    override fun getItemCount(): Int =
        list.size

    fun onUpdateData(items: List<PostModel>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(
        view: View,
        private val parent: ViewGroup,
        private val itemActionListener: ItemActionListener
    ) : RecyclerView.ViewHolder(view) {

        private val binding = ItemPostBinding.bind(view)

        fun bind(item: PostModel) {
            with(binding) {
                titleTv.text = item.title.toString().capitalize()
                bodyTv.text = item.body.toString().capitalize()
            }
        }
    }
}