package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGroupDetail(
    @SerialName("level_learned_at")
    val levelLearnedAt: Int, // 1
    @SerialName("move_learn_method")
    val moveLearnMethod: MoveLearnMethod,
    @SerialName("version_group")
    val versionGroup: VersionGroup
)