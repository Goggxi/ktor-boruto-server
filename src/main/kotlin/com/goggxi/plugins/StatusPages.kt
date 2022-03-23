package com.goggxi.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) {
            call.respond(
                message = "Page not Found.",
                status = HttpStatusCode.NotFound
            )
        }

        // Example handle exception
//        exception<AuthenticationException> {
//            call.respond(
//                message = "Authorized",
//                status = HttpStatusCode.OK
//            )
//        }
    }

}