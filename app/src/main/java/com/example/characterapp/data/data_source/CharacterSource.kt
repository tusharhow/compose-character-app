package com.example.characterapp.data.data_source


import android.annotation.SuppressLint
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.characterapp.data.models.Result
import com.example.characterapp.data.repository.BaseRepository

class CharacterSource(
    private val baseRepository: BaseRepository
):PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
return  state.anchorPosition
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
       return try {
           val nextPage = params.key ?: 1
            val character = baseRepository.getCharacter(nextPage).results
              LoadResult.Page(
                data = character,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPage +1
              )
       }catch (e:Exception){
           LoadResult.Error(e)
       }
    }
}