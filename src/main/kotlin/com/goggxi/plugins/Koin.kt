package com.goggxi.plugins

import com.goggxi.di.koinModule
import io.ktor.application.*
import org.koin.ktor.ext.*
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger(level = org.koin.core.logger.Level.ERROR)
        modules(koinModule)
    }
}