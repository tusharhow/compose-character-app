package com.example.characterapp.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.characterapp.data.repository.BaseRepository
import com.example.characterapp.data.data_source.CharacterSource
import kotlinx.coroutines.flow.Flow
import  com.example.characterapp.data.models.Result


class CharacterViewModel(
    private  val baseRepository: BaseRepository,
) : ViewModel() {
val character: Flow<PagingData<Result>> = Pager(PagingConfig(pageSize = 1)){
    CharacterSource(baseRepository = baseRepository)
}.flow.cachedIn(viewModelScope)

}