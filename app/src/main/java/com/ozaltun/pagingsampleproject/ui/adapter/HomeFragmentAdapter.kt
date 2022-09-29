package com.ozaltun.pagingsampleproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ozaltun.pagingsampleproject.data.model.UserModel
import com.ozaltun.pagingsampleproject.databinding.UserLayoutBinding
import com.ozaltun.pagingsampleproject.ui.view.HomeFragmentDirections

class HomeFragmentAdapter :
    PagingDataAdapter<UserModel, HomeFragmentAdapter.ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(val binding: UserLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.phone == newItem.phone
            }

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.phone == newItem.phone
            }

        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)
        holder.binding.apply {
            holder.itemView.apply {
                tvDescription.text = "${currChar?.name?.first}"
                val imageLink = currChar?.picture?.thumbnail
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
                imageView.setOnClickListener {
                    val nav = HomeFragmentDirections.actionHomeFragmentToDetailFragment(currChar)
                    Navigation.findNavController(it).navigate(nav)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            UserLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }
}