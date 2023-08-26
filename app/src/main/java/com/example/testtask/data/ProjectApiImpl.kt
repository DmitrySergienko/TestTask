package com.example.testtask.data

import com.example.testtask.domain.DoorResponse
import com.example.testtask.domain.Response
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText


class ProjectApiImpl(private val client: HttpClient) : ProjectApi {

    override suspend fun getCameras(): Response {
        val httpResponse: HttpResponse = client.get("http://cars.cprogroup.ru/api/rubetek/cameras/")
        val responseString = httpResponse.bodyAsText()
        val response = Gson().fromJson(responseString, Response::class.java)
        return response
    }

    override suspend fun getDoors(): DoorResponse {
        val httpResponse: HttpResponse = client.get("http://cars.cprogroup.ru/api/rubetek/doors/")
        val responseString = httpResponse.bodyAsText()
        val response = Gson().fromJson(responseString, DoorResponse::class.java)
        return response
    }
}