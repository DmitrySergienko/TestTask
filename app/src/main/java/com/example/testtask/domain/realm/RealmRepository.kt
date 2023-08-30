package com.example.testtask.domain.realm



interface RealmRepository {
  fun saveUser(name: String, favorite: Boolean)
  fun getUser(_id: String): UserData?
  fun getAllUsers(): List<UserData>
  fun deleteUser(_id: String)
}