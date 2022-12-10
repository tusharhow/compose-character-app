package com.example.characterapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.characterapp.data.repository.BaseRepository

class ViewModelFactory(
    private  val baseRepository: BaseRepository
) :ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterViewModel(baseRepository) as T
    }

}