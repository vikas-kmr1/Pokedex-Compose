package com.mine.pokedex.network.model

data class PokemonErrorResponse(
    val statusCode : Int,
    val message : String?
)
