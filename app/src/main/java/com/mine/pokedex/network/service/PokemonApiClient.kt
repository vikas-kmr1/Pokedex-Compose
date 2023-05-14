package com.mine.pokedex.network.service

import com.mine.pokedex.network.model.PokemonResponse
import com.mine.pokedex.network.model.Pokemoninfo
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.serialization.json.Json
import javax.inject.Inject


@ActivityScoped
class PokemonApiClient @Inject constructor(
    private val pokedexApiService: PokemonApiService
) {

    suspend fun fetchPokemonList(page: Int): PokemonResponse {
       return pokedexApiService.fetchPokemonList(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE
        )
    }

    suspend fun fetchPokemonInfo(name: String): Pokemoninfo =
        pokedexApiService.fetchPokemonInfo(
            name = name
        )

    companion object {
        private const val PAGING_SIZE = 20
    }

}


