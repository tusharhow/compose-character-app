package com.example.characterapp.network

import com.example.characterapp.data.models.CharacterModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("/api/character")
    suspend fun getCharacter(
        @Query("page") page: Int
    ): CharacterModel
}