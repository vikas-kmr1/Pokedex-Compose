package com.mine.pokedex.ui.utils

import androidx.compose.ui.graphics.Color
import com.mine.pokedex.network.model.Pokemoninfo
import com.mine.pokedex.ui.theme.AtkColor
import com.mine.pokedex.ui.theme.DefColor
import com.mine.pokedex.ui.theme.ExpColor
import com.mine.pokedex.ui.theme.HPColor
import com.mine.pokedex.ui.theme.SpdColor

object PokemonStatTypeUtils {
    fun getTypeColor(type: String): Color {
        return when (type) {
            "hp" -> HPColor
            "atk" -> AtkColor
            "def" -> DefColor
            "spd" -> SpdColor
            "exp" -> ExpColor
            else -> Color.LightGray
        }
    }
}

object PokemonStatRatiosTypeUtils {
    fun getStatRationString(type: String, pokemoninfo: Pokemoninfo): String {
        return when (type) {
            "hp" -> pokemoninfo.getHpString()
            "atk" -> pokemoninfo.getAttackString()
            "def" -> pokemoninfo.getDefenseString()
            "spd" -> pokemoninfo.getSpeedString()
            "exp" -> pokemoninfo.getExpString()
            else -> "unknown"
        }
    }
}