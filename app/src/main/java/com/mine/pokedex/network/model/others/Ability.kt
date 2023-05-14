package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    @SerialName("ability")
    val ability: AbilityX,
    @SerialName("is_hidden")
    val isHidden: Boolean, // false
    @SerialName("slot")
    val slot: Int // 1
)