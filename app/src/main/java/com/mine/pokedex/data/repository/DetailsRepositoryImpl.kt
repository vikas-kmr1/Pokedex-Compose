package com.mine.pokedex.data.repository

import com.mine.pokedex.network.model.Pokemoninfo
import com.mine.pokedex.network.service.PokemonApiClient
import javax.inject.Inject


class DetailsRepositoryImpl @Inject constructor(private  val pokemonApiClient: PokemonApiClient):DetailsRepository{
    override suspend fun fetchPokemonInfo(name: String): Pokemoninfo {
        return pokemonApiClient.fetchPokemonInfo(name = name)
    }
}