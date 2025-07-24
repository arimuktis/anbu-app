package com.anbu.plugins

import com.anbu.data.repository.BunnyDataSource
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureBunnyRouting() {
    routing {
        val userDataSource: BunnyDataSource by inject(BunnyDataSource::class.java)


        //TODO for admin repository later
    }
}