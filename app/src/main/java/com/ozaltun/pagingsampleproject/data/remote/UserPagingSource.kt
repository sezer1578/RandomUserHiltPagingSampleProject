package com.ozaltun.pagingsampleproject.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ozaltun.pagingsampleproject.data.model.UserModel
import com.ozaltun.pagingsampleproject.util.Constants

class UserPagingSource(private val apiService: ApiService) : PagingSource<Int, UserModel>() {
    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        return try {
            val currentPage = params.key ?: Constants.STARTING_PAGE_INDEX
            val response = apiService.getAllUsers(currentPage, params.loadSize)
            val responseData = mutableListOf<UserModel>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


}