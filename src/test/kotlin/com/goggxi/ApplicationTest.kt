package com.goggxi

import com.goggxi.model.HeroResponse
import com.goggxi.repository.HeroRepository
import com.goggxi.repository.HeroRepositoryImpl
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    private val repo : HeroRepository by inject(HeroRepositoryImpl::class.java)

    @Test
    fun testRoot() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status()
                )
                assertEquals(
                    expected = "Welcome to Boruto API",
                    actual = response.content
                )
            }
        }
    }

    @Test
    fun `access all heroes endpoint, assert correct information`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/boruto/heroes").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status()
                )
                val expected = HeroResponse(
                    success = true,
                    message = "ok",
                    prevPage = null,
                    nextPage = 2,
                    heroes = repo.page1,
                )

                val actual = Json.decodeFromString<HeroResponse>(response.content.toString())

                assertEquals(
                    expected = expected,
                    actual = actual,
                )
            }
        }
    }
}