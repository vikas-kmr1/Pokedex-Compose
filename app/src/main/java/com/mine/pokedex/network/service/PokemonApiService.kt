package com.mine.pokedex.network.service


import com.mine.pokedex.network.model.PokemonResponse
import com.mine.pokedex.network.model.Pokemoninfo
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// BaseUrl = "https://pokeapi.co/api/v2/"
interface PokemonApiService {
    @GET(value = "pokemon")
    suspend fun fetchPokemonList(
        @Query(value = "offset") offset:Int = 0,
        @Query(value = "limit") limit: Int = 20
    ): PokemonResponse


    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name:String
    ):Pokemoninfo

}