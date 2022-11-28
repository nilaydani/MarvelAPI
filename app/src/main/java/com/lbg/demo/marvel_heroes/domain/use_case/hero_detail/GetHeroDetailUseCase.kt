package com.lbg.demo.marvel_heroes.domain.use_case.hero_detail

import com.lbg.demo.core.data.Resource
import com.lbg.demo.marvel_heroes.domain.model.characters.CharacterResponseModel
import com.lbg.demo.marvel_heroes.domain.repository.MarvelCharacterRepository
import javax.inject.Inject

class GetHeroDetailUseCase @Inject constructor(private val repository: MarvelCharacterRepository) {

    suspend operator fun invoke(characterId: String): Resource<CharacterResponseModel> {
        return repository.getMarvelCharacter(characterId)
    }
}