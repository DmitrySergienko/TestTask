package com.example.testtask.ui.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.domain.Camera
import com.example.testtask.domain.Door
import com.example.testtask.domain.realm.Data
import com.example.testtask.domain.realm.GetUserUseCase
import com.example.testtask.domain.realm.SaveUserUseCase
import com.example.testtask.domain.server.GetCamerasUseCase
import com.example.testtask.domain.server.GetDoorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCamerasUseCase: GetCamerasUseCase,
    private val getDoorsUseCase: GetDoorsUseCase,

    private val saveUserUseCase: SaveUserUseCase,
    private val getUserUseCase: GetUserUseCase
    ) : ViewModel() {


    private val _cameras = MutableLiveData<List<Camera>>()
    val cameras: LiveData<List<Camera>> = _cameras

    private val _doors = MutableLiveData<List<Door>>()
    val doors: LiveData<List<Door>> = _doors

    fun fetchCameras() {
        viewModelScope.launch {
            try {
                val response = getCamerasUseCase()
                _cameras.value = response.data.cameras
            } catch (e: Exception) {
                Log.e(TAG, "fetchCameras: $e", )
            }
        }
    }

    fun fetchDoors() {
        viewModelScope.launch {
            try {
                val response = getDoorsUseCase()
                Log.d(TAG, "fetchDoors: Response: $response")
                _doors.value = response.data
            } catch (e: Exception) {
                Log.e(TAG, "fetchDoors: $e")
            }
        }
    }


    fun saveUser(name: String, favorite: Boolean) {
        viewModelScope.launch {
            saveUserUseCase.execute(name, favorite)
        }
    }

    fun getUser(_id: String): Data? {
        var user: Data? = null
        viewModelScope.launch {
            user = getUserUseCase.execute(_id)
        }
        return user
    }

}


