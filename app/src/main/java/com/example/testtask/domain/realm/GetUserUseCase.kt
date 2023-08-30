package com.example.testtask.domain.realm

class GetUserUseCase(private val userRepository: RealmRepository) {
    fun execute(_id: String): Data? {
        return userRepository.getUser(_id)
    }
}