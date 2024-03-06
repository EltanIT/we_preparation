package com.example.ws_preparation.data.di

import com.example.ws_preparation.data.repository.GetLastPackageFullRepositoryImpl
import com.example.ws_preparation.data.repository.GetLastPackageUUIDRepositoryImpl
import com.example.ws_preparation.data.repository.GetProfileRepositoryImpl
import com.example.ws_preparation.data.repository.PostCommentRepositoryImpl
import com.example.ws_preparation.data.repository.PostPackageRepositoryImpl
import com.example.ws_preparation.domain.repository.GetLastPackageFullRepository
import com.example.ws_preparation.domain.repository.GetLastPackageTrackRepository
import com.example.ws_preparation.domain.repository.GetProfileRepository
import com.example.ws_preparation.domain.repository.PostCommentRepository
import com.example.ws_preparation.domain.repository.PostPackageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModules {

    @Provides
    @Singleton
    fun getProfile(): GetProfileRepository = GetProfileRepositoryImpl()

    @Provides
    @Singleton
    fun postPackage(): PostPackageRepository = PostPackageRepositoryImpl()

    @Provides
    @Singleton
    fun getLastPackage(): GetLastPackageFullRepository = GetLastPackageFullRepositoryImpl()

    @Provides
    @Singleton
    fun getLastPackageTrack(): GetLastPackageTrackRepository = GetLastPackageUUIDRepositoryImpl()


    @Provides
    @Singleton
    fun postComment(): PostCommentRepository = PostCommentRepositoryImpl()

}