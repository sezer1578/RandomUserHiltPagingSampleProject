package com.ozaltun.pagingsampleproject.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.ozaltun.pagingsampleproject.data.model.UserModel
import com.ozaltun.pagingsampleproject.data.remote.ApiService
import com.ozaltun.pagingsampleproject.data.remote.UserPagingSource
import com.ozaltun.pagingsampleproject.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {

    override suspend fun getUserList(): LiveData<PagingData<UserModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }
}