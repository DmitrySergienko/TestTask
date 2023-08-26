package com.example.testtask.domain


data class Response(
    val success: Boolean,
    val data: Data
)

data class Data(
    val room: List<String>,
    val cameras: List<Camera>
)

data class Camera(
    val name: String,
    val snapshot: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val rec: Boolean
)

data class DoorResponse(
    val success: Boolean,
    val data: List<Door>
)

data class Door(
    val name: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val snapshot: String? = null
)

