package com.ozaltun.pagingsampleproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ozaltun.pagingsampleproject.data.model.UserModel
import com.ozaltun.pagingsampleproject.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {
    private val userList = MutableLiveData<PagingData<UserModel>>()

    suspend fun getUserList(): LiveData<PagingData<UserModel>> {
        val response = repository.getUserList().cachedIn(viewModelScope)
        userList.value = response.value
        return response
    }

}