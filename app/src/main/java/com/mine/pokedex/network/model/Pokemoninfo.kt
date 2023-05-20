package com.mine.pokedex.network.model

import com.mine.pokedex.network.model.others.Ability
import com.mine.pokedex.network.model.others.Form
import com.mine.pokedex.network.model.others.GameIndice
import com.mine.pokedex.network.model.others.HeldItem
import com.mine.pokedex.network.model.others.Item
import com.mine.pokedex.network.model.others.Move
import com.mine.pokedex.network.model.others.Species
import com.mine.pokedex.network.model.others.Sprites
import com.mine.pokedex.network.model.others.Stat
import com.mine.pokedex.network.model.others.Type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Pokemoninfo(
    @SerialName("abilities")
    val abilities: List<Ability>,
    @SerialName("base_experience")
    val baseExperience: Int, // 101
    @SerialName("forms")
    val forms: List<Form>,
    @SerialName("game_indices")
    val gameIndices: List<GameIndice>,
    @SerialName("height")
    val height: Int, // 3
    @SerialName("held_items")
    val heldItems: List<HeldItem>,
    @SerialName("id")
    val id: Int, // 132
    @SerialName("is_default")
    val isDefault: Boolean, // true
    @SerialName("location_area_encounters")
    val locationAreaEncounters: String, // https://pokeapi.co/api/v2/pokemon/132/encounters
    @SerialName("moves")
    val moves: List<Move>,
    @SerialName("name")
    val name: String, // ditto
    @SerialName("order")
    val order: Int, // 214
    @SerialName("past_types")
    val pastTypes: List<Item>,
    @SerialName("species")
    val species: Species,
    @SerialName("sprites")
    val sprites: Sprites,
    @SerialName("stats")
    val stats: List<Stat>,
    @SerialName("types")
    val types: List<com.mine.pokedex.network.model.others.Type>,
    @SerialName("weight")
    val weight: Int, // 40

    val hp: Int = Random.nextInt(maxHp),
    val attack: Int = Random.nextInt(maxAttack),
    val defense: Int = Random.nextInt(maxDefense),
    val speed: Int = Random.nextInt(maxSpeed),
    val exp: Int = Random.nextInt(maxExp),
) {

    fun getImageUrl():String{
        return  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/$id.svg"
    }


    fun getIdString(): String = String.format("#%03d", id)
    fun getWeightString(): String = String.format("%.1f KG", weight.toFloat() / 10)
    fun getHeightString(): String = String.format("%.1f M", height.toFloat() / 10)
    fun getHpString(): String = " $hp/$maxHp"
    fun getAttackString(): String = " $attack/$maxAttack"
    fun getDefenseString(): String = " $defense/$maxDefense"
    fun getSpeedString(): String = " $speed/$maxSpeed"
    fun getExpString(): String = " $exp/$maxExp"


    @Serializable
    data class TypeResponse(
        @SerialName(value = "slot") val slot: Int,
        @SerialName(value = "type") val type: List<Type>
    )

    @Serializable
    data class Type(
        @SerialName(value = "name") val name: String
    )


    companion object {
        const val maxHp = 300
        const val maxAttack = 300
        const val maxDefense = 300
        const val maxSpeed = 300
        const val maxExp = 1000
    }
}



