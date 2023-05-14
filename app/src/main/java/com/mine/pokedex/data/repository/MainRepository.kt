package com.mine.pokedex.data.repository

import com.mine.pokedex.network.model.Pokemon


interface MainRepository {
    suspend fun fetchPokemonList(
        page: Int,
//        onStart: () -> Unit,
//        onComplete: () -> Unit,
//        onError: (String?) -> Unit
    ) : List<Pokemon>
}



