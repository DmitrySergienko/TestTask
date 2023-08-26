package com.example.testtask.domain

import com.example.testtask.data.ProjectRepository

class GetCamerasUseCase(private val repository: ProjectRepository) {

    suspend operator fun invoke(): Response {
        return repository.getCameras()
    }

}