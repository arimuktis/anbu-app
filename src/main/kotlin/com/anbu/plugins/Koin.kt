package com.anbu.plugins

import com.anbu.database.mongoModule
import com.anbu.di.repositoryModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(
            mongoModule,
                    repositoryModule
        )
    }
}