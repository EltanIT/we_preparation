package com.example.ws_preparation.data.di

import android.app.Application
import com.example.ws_preparation.data.manger.QueueMangerImpl
import com.example.ws_preparation.domain.manger.QueueManger
import com.example.ws_preparation.domain.useCases.onboard.AddItemInQueue
import com.example.ws_preparation.domain.useCases.onboard.ClearQueue
import com.example.ws_preparation.domain.useCases.onboard.CreateDefaultQueue
import com.example.ws_preparation.domain.useCases.onboard.GetButtonStateQueue
import com.example.ws_preparation.domain.useCases.onboard.GetItemFromQueue
import com.example.ws_preparation.domain.useCases.onboard.IsQueueIsEmpty
import com.example.ws_preparation.domain.useCases.onboard.OnboardUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OnboardProvider {

    @Provides
    @Singleton
    fun queueMangerProvider(
        application: Application
    ): QueueManger = QueueMangerImpl(application)


    @Provides
    @Singleton
    fun queueUseCasesProvider(
        queueManger: QueueManger
    ): OnboardUseCases = OnboardUseCases(
        GetItemFromQueue(queueManger),
        GetButtonStateQueue(queueManger),
        AddItemInQueue(queueManger),
        ClearQueue(queueManger),
        IsQueueIsEmpty(queueManger),
        CreateDefaultQueue(queueManger)
    )

}