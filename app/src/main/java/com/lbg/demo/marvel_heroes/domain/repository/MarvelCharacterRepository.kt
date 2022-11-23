package com.lbg.demo.marvel_heroes.domain.repository

import com.lbg.demo.core.data.Resource
import com.lbg.demo.marvel_heroes.domain.model.characters.CharacterResponseModel

interface MarvelCharacterRepository {

    suspend fun getMarvelCharactersList(limit: Int, offset: Int): Resource<CharacterResponseModel>

    suspend fun getMarvelCharacter(characterId: String): Resource<CharacterResponseModel>
}