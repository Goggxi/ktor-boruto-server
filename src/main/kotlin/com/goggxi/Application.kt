package com.goggxi

import io.ktor.application.*
import com.goggxi.plugins.*
import com.goggxi.plugins.configureDefaultHeader

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureDefaultHeader()
    configureStatusPages()
}
