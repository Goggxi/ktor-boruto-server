package com.goggxi.di

import com.goggxi.repository.HeroRepository
import com.goggxi.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}