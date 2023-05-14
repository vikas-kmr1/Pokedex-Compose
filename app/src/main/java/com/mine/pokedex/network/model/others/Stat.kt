package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    @SerialName("base_stat")
    val baseStat: Int, // 48
    @SerialName("effort")
    val effort: Int, // 1
    @SerialName("stat")
    val stat: StatX
)