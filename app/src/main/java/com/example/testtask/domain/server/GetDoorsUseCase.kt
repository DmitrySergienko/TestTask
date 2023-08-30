package com.example.testtask.domain.server

import com.example.testtask.data.ProjectRepository
import com.example.testtask.domain.DoorResponse

class GetDoorsUseCase(private val repository: ProjectRepository) {

    suspend operator fun invoke(): DoorResponse {
        return repository.getDoors()
    }

}