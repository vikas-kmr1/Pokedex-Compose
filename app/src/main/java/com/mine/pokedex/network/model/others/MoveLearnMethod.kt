package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveLearnMethod(
    @SerialName("name")
    val name: String, // level-up
    @SerialName("url")
    val url: String // https://pokeapi.co/api/v2/move-learn-method/1/
)