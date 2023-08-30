package com.example.testtask.di

import com.example.testtask.data.realm.RealmRepositoryImpl
import com.example.testtask.domain.realm.RealmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRealmInstance(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    fun provideUserRepository(realm: Realm): RealmRepository {
        return RealmRepositoryImpl(realm)
    }
}