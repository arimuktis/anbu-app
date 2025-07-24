package com.anbu.di

import com.anbu.data.repository.AnimeRepository
import com.anbu.data.repository.AnimeRepositoryImpl
import com.anbu.data.repository.BunnyDataSource
import com.anbu.data.repository.BunnyDataSourceImpl
import com.anbu.data.repository.BunnySyncService
import com.anbu.data.repository.UserDataSource
import com.anbu.data.repository.UserDataSourceImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<AnimeRepository> {
        AnimeRepositoryImpl()
    }

    single<UserDataSource> {
        UserDataSourceImpl(get())
    }

    single<BunnyDataSource> {
        BunnyDataSourceImpl(
            client = get()
        )
    }

    single {
        BunnySyncService(
            bunny = get(),
            db = get()
        )
    }

}