package com.mine.pokedex.ui.utils

import androidx.compose.ui.graphics.Color
import com.mine.pokedex.ui.theme.TypeBug
import com.mine.pokedex.ui.theme.TypeDark
import com.mine.pokedex.ui.theme.TypeDragon
import com.mine.pokedex.ui.theme.TypeElectric
import com.mine.pokedex.ui.theme.TypeFairy
import com.mine.pokedex.ui.theme.TypeFighting
import com.mine.pokedex.ui.theme.TypeFire
import com.mine.pokedex.ui.theme.TypeFlying
import com.mine.pokedex.ui.theme.TypeGhost
import com.mine.pokedex.ui.theme.TypeGrass
import com.mine.pokedex.ui.theme.TypeGround
import com.mine.pokedex.ui.theme.TypeIce
import com.mine.pokedex.ui.theme.TypePoison
import com.mine.pokedex.ui.theme.TypePsychic
import com.mine.pokedex.ui.theme.TypeRock
import com.mine.pokedex.ui.theme.TypeSteel
import com.mine.pokedex.ui.theme.TypeWater


object PokemonTypeUtils {

    fun getTypeColor(type: String): Color {
        return when (type) {
            "fighting" -> TypeFighting
            "flying" -> TypeFlying
            "poison" -> TypePoison
            "ground" -> TypeGround
            "rock" -> TypeRock
            "bug" -> TypeBug
            "ghost" -> TypeGhost
            "steel" -> TypeSteel
            "fire" -> TypeFire
            "water" -> TypeWater
            "grass" -> TypeGrass
            "electric" -> TypeElectric
            "psychic" -> TypePsychic
            "ice" -> TypeIce
            "dragon" -> TypeDragon
            "fairy" -> TypeFairy
            "dark" -> TypeDark
            else -> Color.LightGray
        }
    }
}