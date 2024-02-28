package com.example.ws_preparation.domain.useCases.onboard



// Класс, содержащий все UseCases для работы с очередью Onboard
// Мичкасов Георгий
// 28.02.2024 11.20
class OnboardUseCases(
    val getItemFromQueue: GetItemFromQueue,
    val getButtonStateQueue: GetButtonStateQueue,
    val addItemInQueue: AddItemInQueue,
    val clearQueue: ClearQueue,
    val isQueueIsEmpty: IsQueueIsEmpty,
    val createDefaultQueue: CreateDefaultQueue
)

