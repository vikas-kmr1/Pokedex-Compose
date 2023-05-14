package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlackWhite(
    @SerialName("animated")
    val animated: Animated,
    @SerialName("back_default")
    val backDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/132.png
    @SerialName("back_female")
    val backFemale: String?, // null
    @SerialName("back_shiny")
    val backShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/shiny/132.png
    @SerialName("back_shiny_female")
    val backShinyFemale: String?, // null
    @SerialName("front_default")
    val frontDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/132.png
    @SerialName("front_female")
    val frontFemale: String?, // null
    @SerialName("front_shiny")
    val frontShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/shiny/132.png
    @SerialName("front_shiny_female")
    val frontShinyFemale: String? // null
)