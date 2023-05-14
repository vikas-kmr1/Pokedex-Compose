package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class XY(
    @SerialName("front_default")
    val frontDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/132.png
    @SerialName("front_female")
    val frontFemale: String?, // null
    @SerialName("front_shiny")
    val frontShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/shiny/132.png
    @SerialName("front_shiny_female")
    val frontShinyFemale: String? // null
)