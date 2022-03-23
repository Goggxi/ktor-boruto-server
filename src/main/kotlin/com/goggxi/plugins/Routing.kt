package com.goggxi.plugins

import com.goggxi.routes.allHeroes
import com.goggxi.routes.root
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    routing {
        root()
        allHeroes()

        static("/images") {
            resource("images")
        }
    }
}
