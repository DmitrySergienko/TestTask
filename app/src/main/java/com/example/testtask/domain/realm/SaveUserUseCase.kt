package com.example.testtask.domain.realm

class SaveUserUseCase(private val userRepository: RealmRepository) {
    fun execute(name: String, favorite: Boolean) {
        userRepository.saveUser(name, favorite)
    }
}