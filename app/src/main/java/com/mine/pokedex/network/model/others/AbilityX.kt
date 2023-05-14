package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityX(
    @SerialName("name")
    val name: String, // limber
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/ability/7/
)