package com.mine.pokedex.network.model.others


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonData(
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
    val types: List<Type>,
    @SerialName("weight")
    val weight: Int, // 40
)