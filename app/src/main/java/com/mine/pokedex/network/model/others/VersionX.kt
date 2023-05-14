package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionX(
    @SerialName("name")
    val name: String, // ruby
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/version/7/
)