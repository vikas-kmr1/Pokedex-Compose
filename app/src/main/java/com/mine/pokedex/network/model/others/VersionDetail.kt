package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionDetail(
    @SerialName("rarity")
    val rarity: Int, // 5
    @SerialName("version")
    val version: VersionX
)