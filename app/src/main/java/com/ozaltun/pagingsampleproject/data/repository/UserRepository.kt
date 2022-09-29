package com.ozaltun.pagingsampleproject.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.ozaltun.pagingsampleproject.data.model.UserModel
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun getUserList(): LiveData<PagingData<UserModel>>
}