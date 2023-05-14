package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OmegarubyAlphasapphire(
    @SerialName("front_default")
    val frontDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/132.png
    @SerialName("front_female")
    val frontFemale: String?, // null
    @SerialName("front_shiny")
    val frontShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/shiny/132.png
    @SerialName("front_shiny_female")
    val frontShinyFemale: String? // null
)