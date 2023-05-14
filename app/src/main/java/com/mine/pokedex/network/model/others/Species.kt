package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Species(
    @SerialName("name")
    val name: String, // ditto
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/pokemon-species/132/
)