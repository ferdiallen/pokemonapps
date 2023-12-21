package com.ferdialif.pokemonapps.domain.repository

import com.ferdialif.pokemonapps.core.util.baseUrl
import com.ferdialif.pokemonapps.data.api.GetDetailPokemon
import com.ferdialif.pokemonapps.data.dto.PokemonModelDetail
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class GetPokemonDetailImpl(
    private val client: HttpClient
) : GetDetailPokemon {
    override suspend fun getDetailPokemon(name: String): PokemonModelDetail? {
        return client.get(baseUrl + "pokemon/$name") {
            contentType(ContentType.Application.Json)
        }.body()
    }
}