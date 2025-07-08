package com.anbu.plugins

import com.anbu.domain.models.UserSession
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.sessions.SessionTransportTransformerEncrypt
import io.ktor.server.sessions.Sessions
import io.ktor.server.sessions.cookie
import io.ktor.server.sessions.directorySessionStorage
import io.ktor.util.hex
import java.io.File

fun Application.configureSession() {
    install(Sessions) {
        val secretEncryptKey = hex("00112233445566778899aabbccddeeff") // 16 bytes
        val secretAuthKey = hex("ffeeddccbbaa99887766554433221100")  // 16 bytes
        cookie<UserSession>(
            name = "USER_SESSION",
            storage = directorySessionStorage(File(".session"))
        ) {
            cookie.secure = true
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretAuthKey))
        }
    }
}