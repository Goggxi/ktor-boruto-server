package com.goggxi.repository

import com.goggxi.model.Hero
import com.goggxi.model.HeroResponse

interface HeroRepository {

    val heroes: Map<Int, List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): HeroResponse
    suspend fun searchHero(name: String): HeroResponse
}