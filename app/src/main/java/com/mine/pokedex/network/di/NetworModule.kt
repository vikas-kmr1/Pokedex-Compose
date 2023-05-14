package com.mine.pokedex.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mine.pokedex.network.service.PokemonApiClient
import com.mine.pokedex.network.service.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Singleton

const val BASE_URL = "https://pokeapi.co/api/v2/"

@Module
@InstallIn(SingletonComponent::class)
internal object NetworModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpRequestInterceptor())
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        val retrofit :Retrofit = Retrofit
            .Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit):PokemonApiService{
        return retrofit.create(PokemonApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonApiClient(pokemonApiService:PokemonApiService):PokemonApiClient{
        return PokemonApiClient(pokemonApiService)
    }

}


internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        Timber.d(request.toString())
        return chain.proceed(request)
    }
}
