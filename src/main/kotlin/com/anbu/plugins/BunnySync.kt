package com.anbu.plugins

import com.anbu.data.repository.BunnySyncService
import io.ktor.server.application.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.ktor.ext.inject
import java.time.Duration

fun Application.configureBunnySync() {
    val syncService: BunnySyncService by inject()

    launch {
        while (true) {
            runCatching { syncService.syncAll() }
                .onSuccess { log.info("✅ Bunny sync finished") }
                .onFailure { log.error("❌ Bunny sync failed: ${it.message}") }

            delay(Duration.ofHours(6).toMillis())
        }
    }
}
