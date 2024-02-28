package com.example.ws_preparation

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ws_preparation.data.manger.QueueMangerImpl
import com.example.ws_preparation.domain.entities.OnboardPage
import com.example.ws_preparation.domain.manger.QueueManger
import com.example.ws_preparation.domain.useCases.onboard.AddItemInQueue
import com.example.ws_preparation.domain.useCases.onboard.ClearQueue
import com.example.ws_preparation.domain.useCases.onboard.CreateDefaultQueue
import com.example.ws_preparation.domain.useCases.onboard.GetButtonStateQueue
import com.example.ws_preparation.domain.useCases.onboard.GetItemFromQueue
import com.example.ws_preparation.domain.useCases.onboard.IsQueueIsEmpty
import com.example.ws_preparation.domain.useCases.onboard.OnboardUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before



//GREEN
@RunWith(AndroidJUnit4::class)
class Tests {


    private lateinit var onboardUseCases: OnboardUseCases
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    @Before
    fun setUp(){
        val queueManger = QueueMangerImpl(InstrumentationRegistry.getInstrumentation().targetContext)
        onboardUseCases = OnboardUseCases(
            GetItemFromQueue(queueManger),
            GetButtonStateQueue(queueManger),
            AddItemInQueue(queueManger),
            ClearQueue(queueManger),
            IsQueueIsEmpty(queueManger),
            CreateDefaultQueue(queueManger)
        )
    }
    @Test
    fun test() {
        coroutineScope.launch {
            onboardUseCases.clearQueue()
            onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            assertEquals(onboardUseCases.getItemFromQueue().title, "title1")
            assertEquals(onboardUseCases.getItemFromQueue().title, "title2")





            onboardUseCases.clearQueue()
            val sizeBeforeAddItemInQueue = onboardUseCases.isQueueIsEmpty()
            onboardUseCases.addItemInQueue(OnboardPage("title", "description", 0))
            val sizeAfterAddItemInQueue = onboardUseCases.isQueueIsEmpty()
            assertTrue(sizeBeforeAddItemInQueue == sizeAfterAddItemInQueue)





            onboardUseCases.clearQueue()
            onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            assertEquals(onboardUseCases.getButtonStateQueue(), "Next")




            onboardUseCases.clearQueue()
            assertEquals(onboardUseCases.getButtonStateQueue(), "Sign Up")




            onboardUseCases.clearQueue()
            assertTrue(onboardUseCases.isQueueIsEmpty() == true)

            onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            assertFalse(onboardUseCases.isQueueIsEmpty() == true)



        }
    }
}