package com.ferdialif.pokemonapps.domain.repository

import com.ferdialif.pokemonapps.core.util.baseUrl
import com.ferdialif.pokemonapps.data.api.GetPokemon
import com.ferdialif.pokemonapps.data.dto.GeneralPokemonModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class GetPokemonImpl(private val client: HttpClient) : GetPokemon {
    override suspend fun getPokemon(): GeneralPokemonModel? {
        return client.get(baseUrl + "pokemon") {
            contentType(ContentType.Application.Json)
        }.body()
    }
}