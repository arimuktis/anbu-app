package com.anbu.domain.models

sealed class Endpoint(val path: String) {
    object Root: Endpoint(path = "/")
    object TokenVerification: Endpoint(path = "/anbu/token_verification")
    object GetUserInfo: Endpoint(path = "/anbu/get_user")
    object UpdateUserInfo: Endpoint(path = "/anbu/update_user")
    object DeleteUser: Endpoint(path = "/anbu/delete_user")
    object SignOut: Endpoint(path = "/anbu/sign_out")
    object Unauthorized: Endpoint(path = "/anbu/unauthorized")
    object Authorized: Endpoint(path = "/anbu/authorized")
}