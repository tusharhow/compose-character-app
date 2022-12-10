package com.example.characterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.lifecycle.ViewModelProvider
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.characterapp.components.MyTopAppBar
import com.example.characterapp.data.repository.BaseRepository
import com.example.characterapp.network.ApiServiceImpl
import com.example.characterapp.view.HomeListView
import com.example.characterapp.viewModel.CharacterViewModel
import com.example.characterapp.viewModel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val characterApi = ApiServiceImpl.api
            val baseRepository = BaseRepository(characterApi)
            val viewModelFactory = ViewModelFactory(baseRepository)
            val viewModel =
                ViewModelProvider(this, viewModelFactory).get(CharacterViewModel::class.java)
            val character = viewModel.character.collectAsLazyPagingItems()
            Scaffold(
                topBar = {
                    MyTopAppBar()
                }
            ) {
                HomeListView(character = character) {}
            }
        }
    }
}


