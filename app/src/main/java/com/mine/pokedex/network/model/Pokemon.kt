package com.mine.pokedex.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    var page:Int = 0,
    @SerialName(value = "name")val name:String,
    @SerialName(value = "url") val url:String
)
{
    fun getImageUrl():String{
        val index = url.split("/".toRegex()).dropLast(1).last()
        return  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/$index.svg"
    }
}