package com.example.testtask.di


import com.example.testtask.data.ProjectApi
import com.example.testtask.data.ProjectApiImpl
import com.example.testtask.data.ProjectRepository
import com.example.testtask.data.ProjectRepositoryImpl
import com.example.testtask.domain.server.GetCamerasUseCase
import com.example.testtask.domain.server.GetDoorsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProjectModule {
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient {
            install(io.ktor.client.plugins.json.JsonPlugin) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "cars.cprogroup.ru"
                }
            }
        }
    }



    @Provides
    @Singleton
    fun provideProjectApi(client: HttpClient): ProjectApi {
        return ProjectApiImpl(client)
    }

    @Provides
    @Singleton
    fun provideProjectRepository(api: ProjectApi): ProjectRepository {
        return ProjectRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCamerasUseCase(projectRepository: ProjectRepository): GetCamerasUseCase {
        return GetCamerasUseCase(projectRepository)
    }

    @Provides
    @Singleton
    fun provideGetDoorsUseCase(projectRepository: ProjectRepository): GetDoorsUseCase {
        return GetDoorsUseCase(projectRepository)
    }

}