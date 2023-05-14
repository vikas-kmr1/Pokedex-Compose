package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndice(
    @SerialName("game_index")
    val gameIndex: Int, // 76
    @SerialName("version")
    val version: Version
)