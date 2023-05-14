package com.mine.pokedex.data.repository

import com.mine.pokedex.network.model.Pokemon
import com.mine.pokedex.network.service.PokemonApiClient
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(private val pokemonApiClient: PokemonApiClient) : MainRepository{
    override suspend fun fetchPokemonList(
        page: Int,
//        onStart: () -> Unit,
//        onComplete: () -> Unit,
//        onError: (String?) -> Unit
    ): List<Pokemon> {
        val response = pokemonApiClient.fetchPokemonList(page = page)
        return response.results
    }
}
