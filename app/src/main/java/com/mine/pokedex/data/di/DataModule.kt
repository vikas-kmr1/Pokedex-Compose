package com.mine.pokedex.data.di

import com.mine.pokedex.data.repository.DetailsRepository
import com.mine.pokedex.data.repository.DetailsRepositoryImpl
import com.mine.pokedex.data.repository.MainRepository
import com.mine.pokedex.data.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository

    @Binds
    fun bindsDetailRepository(
        detailRepositoryImpl: DetailsRepositoryImpl
    ): DetailsRepository
}