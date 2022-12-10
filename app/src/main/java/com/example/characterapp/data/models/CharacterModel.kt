package com.example.characterapp.data.models



data class CharacterModel(
    val info: Info,
    val results: List<Result> = listOf()
)