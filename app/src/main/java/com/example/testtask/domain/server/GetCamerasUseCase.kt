package com.example.testtask.domain.server

import com.example.testtask.data.ProjectRepository
import com.example.testtask.domain.Response

class GetCamerasUseCase(private val repository: ProjectRepository) {

    suspend operator fun invoke(): Response {
        return repository.getCameras()
    }

}