package com.ozaltun.pagingsampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozaltun.pagingsampleproject.databinding.ActivityMainBinding
import com.ozaltun.pagingsampleproject.ui.adapter.HomeFragmentAdapter
import com.ozaltun.pagingsampleproject.ui.viewmodel.HomeFragmentViewModel
import com.ozaltun.pagingsampleproject.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}