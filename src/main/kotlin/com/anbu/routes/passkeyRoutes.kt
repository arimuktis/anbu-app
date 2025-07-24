package com.anbu.routes

import com.anbu.domain.models.GoogleScanLoginInfo
import com.anbu.domain.models.WebAuthnRequest
import com.anbu.domain.models.WebAuthnResponse
import com.webauthn4j.WebAuthnAuthenticationManager
import com.webauthn4j.data.AuthenticationParameters
import com.webauthn4j.data.AuthenticationRequest
import com.webauthn4j.data.AuthenticatorAssertionResponse
import com.webauthn4j.data.PublicKeyCredentialRequestOptions
import com.webauthn4j.data.attestation.authenticator.COSEKey
import com.webauthn4j.data.client.Origin
import com.webauthn4j.data.client.challenge.Challenge
import com.webauthn4j.data.client.challenge.DefaultChallenge
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.util.AttributeKey
import kotlinx.serialization.Serializable
import java.security.SecureRandom
import java.util.Base64
import java.util.Random

fun Route.passkeyRoutes() {
    val authManager = WebAuthnAuthenticationManager()

    // Temporary in-memory challenge store (⚠️ Ganti dengan Redis/DB/cache nanti)
    val challengeStore = mutableMapOf<String, DefaultChallenge>()

    /**
     * 1. GET /auth/assertion-options → return challenge and rpId
     */
    get("/auth/assertion-options") {
        try {
            val challenge = DefaultChallenge()
            val rpId = "yourdomain.com"

            val base64Challenge = Base64.getUrlEncoder().withoutPadding().encodeToString(challenge.value)

            val sessionId = "mock-user-session" // Replace with actual user/session ID
            challengeStore[sessionId] = challenge

            println("Generated challenge: $base64Challenge for sessionId=$sessionId")

            call.respond(
                AssertionRequestResponse(
                    challenge = base64Challenge,
                    rpId = rpId
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            call.respond(HttpStatusCode.InternalServerError, "Error generating assertion options: ${e.message}")
        }
    }


    /**
     * 2. POST /auth/verify-assertion → verify passkey response
     */
    post("/auth/verify-assertion") {
        val request = call.receive<VerificationRequest>()

        try {
            val decodedChallenge = getChallengeForUser(request.userHandle?.toByteArray())
            val decodedClientData = Base64.getUrlDecoder().decode(request.response.clientDataJSON)

            // 🧪 Mocked verification logic — replace with WebAuthn verification later
//            val isValid = decodedClientData.contains(decodedChallenge.value)
            val isValid = true

            if (isValid) {
                val jwt = generateJwtForUser(request.userHandle?.toByteArray())
                call.respond(VerifyResult(success = true, username = "mock-user")) // optional: include jwt
            } else {
                call.respond(HttpStatusCode.Unauthorized, VerifyResult(success = false, username = ""))
            }

        } catch (e: Exception) {
            e.printStackTrace()
            call.respond(HttpStatusCode.InternalServerError, "Verification failed: ${e.message}")
        }
    }

}

// --- Mocked versions (replace with real DB/cache access) ---

fun getChallengeBase64ForUser(userHandle: ByteArray?): String {
    // TODO: Replace with logic to retrieve previously generated Base64-encoded challenge from DB or session
    val fakeChallenge = DefaultChallenge()
    return Base64.getUrlEncoder().withoutPadding().encodeToString(fakeChallenge.value)
}

fun getPublicKeyForUser(userHandle: ByteArray?): ByteArray {
    // TODO: Replace with actual public key lookup from DB
    val fakeKey = ByteArray(64) { 1 } // fake dummy 64-byte key
    return fakeKey
}

fun getChallengeForUser(userHandle: ByteArray?): Challenge {
    // 🚧 TODO: Replace this with challenge loaded from DB or session
    val fakeChallenge = ByteArray(32).also { SecureRandom().nextBytes(it) }
    return DefaultChallenge(fakeChallenge)
}

fun generateJwtForUser(userHandle: ByteArray?): String {
    // 🚧 TODO: Replace with real JWT logic
    return "fake-jwt-token-for-${userHandle?.decodeToString() ?: "guest"}"
}

// --- Models ---
@kotlinx.serialization.Serializable
data class AssertionRequestResponse(
    val challenge: String,
    val rpId: String
)
@kotlinx.serialization.Serializable
data class VerificationRequest(
    val clientDataJSON: String,
    val authenticatorData: String,
    val signature: String,
    val userHandle: String? = null,
    val id: String,
    val rawId: String,
    val type: String,
    val response: AssertionResponse
)
@kotlinx.serialization.Serializable
data class VerifyResult(
    val success: Boolean,
    val username: String
)
@Serializable
data class AssertionResponse(
    val clientDataJSON: String,
    val authenticatorData: String,
    val signature: String,
    val userHandle: String?
)

