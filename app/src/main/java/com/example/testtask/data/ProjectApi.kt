package com.example.testtask.data

import com.example.testtask.domain.DoorResponse
import com.example.testtask.domain.Response

interface ProjectApi {

    suspend fun getCameras(): Response
    suspend fun getDoors(): DoorResponse
}