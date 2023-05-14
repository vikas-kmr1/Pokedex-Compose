package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatX(
    @SerialName("name")
    val name: String, // hp
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/stat/1/
)