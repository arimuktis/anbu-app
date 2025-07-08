package com.anbu.di

import com.anbu.data.repository.AnimeRepository
import com.anbu.data.repository.AnimeRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<AnimeRepository> {
        AnimeRepositoryImpl()
    }
}