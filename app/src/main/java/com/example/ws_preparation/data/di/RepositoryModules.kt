package com.example.ws_preparation.data.di

import com.example.ws_preparation.data.repository.CreateChatRepositoryImpl
import com.example.ws_preparation.data.repository.CreateMessageRepositoryImpl
import com.example.ws_preparation.data.repository.GetAdvertisementRepositoryImpl
import com.example.ws_preparation.data.repository.GetChatIdRepositoryImpl
import com.example.ws_preparation.data.repository.GetChatsProfileRepositoryImpl
import com.example.ws_preparation.data.repository.GetLastMessageRepositoryImpl
import com.example.ws_preparation.data.repository.GetLastPackageFullRepositoryImpl
import com.example.ws_preparation.data.repository.GetLastPackageUUIDRepositoryImpl
import com.example.ws_preparation.data.repository.GetMessageHistoryRepositoryImpl
import com.example.ws_preparation.data.repository.GetProfileRepositoryImpl
import com.example.ws_preparation.data.repository.GetProfileRoleRepositoryImpl
import com.example.ws_preparation.data.repository.PostCommentRepositoryImpl
import com.example.ws_preparation.data.repository.PostPackageRepositoryImpl
import com.example.ws_preparation.domain.repository.CreateChatRepository
import com.example.ws_preparation.domain.repository.CreateMessageRepository
import com.example.ws_preparation.domain.repository.GetAdvertisementRepository
import com.example.ws_preparation.domain.repository.GetChatIdRepository
import com.example.ws_preparation.domain.repository.GetChatsProfileRepository
import com.example.ws_preparation.domain.repository.GetLastMessageRepository
import com.example.ws_preparation.domain.repository.GetLastPackageFullRepository
import com.example.ws_preparation.domain.repository.GetLastPackageTrackRepository
import com.example.ws_preparation.domain.repository.GetMessageHistoryRepository
import com.example.ws_preparation.domain.repository.GetProfileRepository
import com.example.ws_preparation.domain.repository.GetProfileRoleRepository
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
    fun getProfileRole(): GetProfileRoleRepository = GetProfileRoleRepositoryImpl()

    @Provides
    @Singleton
    fun getAdvertisement(): GetAdvertisementRepository = GetAdvertisementRepositoryImpl()

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

    @Provides
    @Singleton
    fun getChatsProfile(): GetChatsProfileRepository = GetChatsProfileRepositoryImpl()

    @Provides
    @Singleton
    fun getLastMessage(): GetLastMessageRepository = GetLastMessageRepositoryImpl()

    @Provides
    @Singleton
    fun getChatId(): GetChatIdRepository = GetChatIdRepositoryImpl()

    @Provides
    @Singleton
    fun createChat(): CreateChatRepository = CreateChatRepositoryImpl()

    @Provides
    @Singleton
    fun createMessage(): CreateMessageRepository = CreateMessageRepositoryImpl()

    @Provides
    @Singleton
    fun getMessageHistory(): GetMessageHistoryRepository = GetMessageHistoryRepositoryImpl()

}