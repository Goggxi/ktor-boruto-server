package com.goggxi.routes

import com.goggxi.repository.HeroRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHero() {
     val repo : HeroRepository by inject()

     get("/boruto/heroes/search") {
          val name = call.request.queryParameters["name"]

          val response = repo.searchHero(name = name)

          call.respond(
               message = response,
               status = HttpStatusCode.OK
          )
     }
}