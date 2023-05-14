package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Crystal(
    @SerialName("back_default")
    val backDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/132.png
    @SerialName("back_shiny")
    val backShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/shiny/132.png
    @SerialName("back_shiny_transparent")
    val backShinyTransparent: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/shiny/132.png
    @SerialName("back_transparent")
    val backTransparent: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/132.png
    @SerialName("front_default")
    val frontDefault: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/132.png
    @SerialName("front_shiny")
    val frontShiny: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/shiny/132.png
    @SerialName("front_shiny_transparent")
    val frontShinyTransparent: String, // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/shiny/132.png
    @SerialName("front_transparent")
    val frontTransparent: String // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/132.png
)