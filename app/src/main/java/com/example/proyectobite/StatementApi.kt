package com.example.proyectobite

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// peticiones
interface StatementApi {
    @GET("user/statements")
    suspend fun obtenerMovimientos(): StatementResponse
}

// conexión
object RetrofitClient {
    private const val BASE_URL = "https://91f7b927-de7a-401b-8a73-f0fd9b35764d.mock.pstmn.io/"

    val api: StatementApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StatementApi::class.java)
    }
}