package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveX(
    @SerialName("name")
    val name: String, // transform
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/move/144/
)