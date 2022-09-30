package com.ozaltun.pagingsampleproject.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozaltun.pagingsampleproject.R
import com.ozaltun.pagingsampleproject.databinding.FragmentHomeBinding
import com.ozaltun.pagingsampleproject.ui.adapter.HomeFragmentAdapter
import com.ozaltun.pagingsampleproject.ui.viewmodel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var userAdapter: HomeFragmentAdapter
    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()
        loadData()
        return binding.root
    }

    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUserList().observe(viewLifecycleOwner, {
                userAdapter.submitData(lifecycle, it)
            })
        }
    }

    private fun setupRecyclerView() {
        userAdapter = HomeFragmentAdapter()
        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
        }
    }

}