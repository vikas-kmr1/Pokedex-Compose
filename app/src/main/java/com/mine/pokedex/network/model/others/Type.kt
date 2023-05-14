package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName("slot")
    val slot: Int, // 1
    @SerialName("type")
    val type: TypeX
)