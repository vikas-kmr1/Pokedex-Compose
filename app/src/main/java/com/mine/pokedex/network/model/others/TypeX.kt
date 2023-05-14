package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeX(
    @SerialName("name")
    val name: String, // normal
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/type/1/
)