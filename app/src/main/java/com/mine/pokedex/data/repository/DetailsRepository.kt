package com.mine.pokedex.data.repository

import com.mine.pokedex.network.model.Pokemon
import com.mine.pokedex.network.model.Pokemoninfo

interface DetailsRepository {
    suspend fun fetchPokemonInfo(
        name: String,
//        onStart: () -> Unit,
//        onComplete: () -> Unit,
//        onError: (String?) -> Unit
    ) : Pokemoninfo
}