package com.example.testtask.data

import com.example.testtask.domain.DoorResponse
import com.example.testtask.domain.Response

class ProjectRepositoryImpl(private val api: ProjectApi) : ProjectRepository {

    override suspend fun getCameras(): Response {
        return api.getCameras()
    }
    override suspend fun getDoors(): DoorResponse {
        return api.getDoors()
    }
}