package com.anbu.di

import com.anbu.repository.AnimeRepository
import com.anbu.repository.AnimeRepositoryImpl
import com.anbu.repository.HeroRepository
import com.anbu.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<AnimeRepository> {
        AnimeRepositoryImpl()
    }
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}