package com.mine.pokedex.network.model.mapper

import com.mine.pokedex.network.model.PokemonErrorResponse
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

object PokemonErrorResponseMapper : ApiErrorModelMapper<PokemonErrorResponse> {
    override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): PokemonErrorResponse {
        return PokemonErrorResponse(
            statusCode = apiErrorResponse.statusCode.code,
            message = apiErrorResponse.message()
        )
    }

}