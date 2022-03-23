package com.goggxi.routes

import com.goggxi.model.HeroResponse
import com.goggxi.repository.HeroRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.allHeroes() {
    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val response = heroRepository.getAllHeroes(page = page)

            call.respond(
                message = response,
                status = HttpStatusCode.OK
            )

        } catch (e: java.lang.NumberFormatException) {
            call.respond(
                message = HeroResponse(message = "Only Number Allowed.", success = false),
                status = HttpStatusCode.BadRequest,
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = HeroResponse(message = "Heroes not found.", success = false),
                status = HttpStatusCode.NotFound ,
            )
        }

    }
}