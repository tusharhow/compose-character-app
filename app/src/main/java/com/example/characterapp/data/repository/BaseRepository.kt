package com.example.characterapp.data.repository

import com.example.characterapp.data.models.CharacterModel
import com.example.characterapp.network.ApiService

class BaseRepository(
    private val characterApi : ApiService
):ApiService {
    override suspend fun getCharacter(page: Int): CharacterModel {
      return characterApi.getCharacter(page)
    }
}