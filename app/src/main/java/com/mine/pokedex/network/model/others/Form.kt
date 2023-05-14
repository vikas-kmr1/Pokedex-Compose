package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Form(
    @SerialName("name")
    val name: String, // ditto
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/pokemon-form/132/
)