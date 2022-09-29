package com.ozaltun.pagingsampleproject.ui.view

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.ozaltun.pagingsampleproject.R
import com.ozaltun.pagingsampleproject.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bunle: DetailFragmentArgs by navArgs()
        val getData = bunle.data


        val imageLink = getData?.picture?.large
        binding.imageViewDetail.load(imageLink) {
            crossfade(true)
            crossfade(1000)
        }
        binding.textViewDetail.text = getData?.name?.first
        return binding.root
    }
}