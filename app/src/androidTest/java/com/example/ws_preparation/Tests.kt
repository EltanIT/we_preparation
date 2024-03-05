package com.example.ws_preparation

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.ws_preparation.data.manger.QueueMangerImpl
import com.example.ws_preparation.domain.model.OnboardPage
import com.example.ws_preparation.domain.useCases.onboard.AddItemInQueue
import com.example.ws_preparation.domain.useCases.onboard.ClearQueue
import com.example.ws_preparation.domain.useCases.onboard.CreateDefaultQueue
import com.example.ws_preparation.domain.useCases.onboard.GetButtonStateQueue
import com.example.ws_preparation.domain.useCases.onboard.GetItemFromQueue
import com.example.ws_preparation.domain.useCases.onboard.QueueIsEmpty
import com.example.ws_preparation.domain.useCases.onboard.OnboardUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


//REFACTOR
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
            QueueIsEmpty(queueManger),
            CreateDefaultQueue(queueManger)
        )
    }
    @Test
    fun titleAndImageFromQueueGetCorrect() {
        coroutineScope.launch {
            onboardUseCases.clearQueue()
            onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            assertEquals(onboardUseCases.getItemFromQueue().title, "title1")
            assertEquals(onboardUseCases.getItemFromQueue().title, "title2")
        }
    }


    @Test
    fun correctGetItemFromQueue() {
        coroutineScope.launch {
            onboardUseCases.clearQueue()
            val sizeBeforeAddItemInQueue = onboardUseCases.queueIsEmpty()
            onboardUseCases.addItemInQueue(OnboardPage("title", "description", 0))
            val sizeAfterAddItemInQueue = onboardUseCases.queueIsEmpty()
            assertTrue(sizeBeforeAddItemInQueue == sizeAfterAddItemInQueue)
        }
    }
    @Test
    fun getCorrectButtonStateWithFullQueue() {
        coroutineScope.launch {
            onboardUseCases.clearQueue()
            onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            assertEquals(onboardUseCases.getButtonStateQueue(), "Next")
        }
    }

    @Test
    fun getCorrectButtonStateWithEmptyQueue() {
        coroutineScope.launch {
            onboardUseCases.clearQueue()
            assertEquals(onboardUseCases.getButtonStateQueue(), "Sign Up")
        }
    }

    @Test
    fun getCorrectSignInNavigation() {
        coroutineScope.launch {
            onboardUseCases.clearQueue()
            //переход произошел
            assertTrue(onboardUseCases.queueIsEmpty() == true)

            onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            //переход отсутствует
            assertFalse(onboardUseCases.queueIsEmpty() == true)
        }
    }

}