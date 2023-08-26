package com.example.testtask.domain

import com.example.testtask.data.ProjectRepository

class GetDoorsUseCase(private val repository: ProjectRepository) {

    suspend operator fun invoke(): DoorResponse {
        return repository.getDoors()
    }

}