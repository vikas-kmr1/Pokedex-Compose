package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("name")
    val name: String, // metal-powder
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/item/234/
)