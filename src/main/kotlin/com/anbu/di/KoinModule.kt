package com.anbu.di

import com.anbu.repository.AnimeRepository
import com.anbu.repository.AnimeRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<AnimeRepository> {
        AnimeRepositoryImpl()
    }
}