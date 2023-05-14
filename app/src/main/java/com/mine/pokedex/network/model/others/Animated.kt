package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Animated(
    @SerialName("back_default")
    val backDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/132.gif
    @SerialName("back_female")
    val backFemale: String?, // null
    @SerialName("back_shiny")
    val backShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/shiny/132.gif
    @SerialName("back_shiny_female")
    val backShinyFemale: String?, // null
    @SerialName("front_default")
    val frontDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/132.gif
    @SerialName("front_female")
    val frontFemale: String?, // null
    @SerialName("front_shiny")
    val frontShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/shiny/132.gif
    @SerialName("front_shiny_female")
    val frontShinyFemale: String? // null
)