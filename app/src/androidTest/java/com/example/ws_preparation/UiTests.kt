package com.example.ws_preparation

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ws_preparation.domain.model.OnboardPage
import com.example.ws_preparation.domain.useCases.onboard.AddItemInQueue
import com.example.ws_preparation.domain.useCases.onboard.ClearQueue
import com.example.ws_preparation.domain.useCases.onboard.CreateDefaultQueue
import com.example.ws_preparation.domain.useCases.onboard.GetButtonStateQueue
import com.example.ws_preparation.domain.useCases.onboard.GetItemFromQueue
import com.example.ws_preparation.domain.useCases.onboard.OnboardUseCases
import com.example.ws_preparation.domain.useCases.onboard.QueueIsEmpty
import com.example.ws_preparation.presentation.Onboard.OnboardViewModel
import com.example.ws_preparation.presentation.Onboard.components.OnboardScreen
import com.example.ws_preparation.presentation.SignIn.SignInViewModel
import com.example.ws_preparation.presentation.SignIn.components.SignInScreen
import com.example.ws_preparation.presentation.navgraph.Route
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@ExperimentalMaterial3Api
class UiTests {

    private lateinit var viewModel: OnboardViewModel
    private lateinit var queueTestManger: QueueTestManger
    private lateinit var useCases: OnboardUseCases


    @get: Rule
    val rule = createComposeRule()

    @Before
    fun setUp(){
        queueTestManger = QueueTestManger()
        useCases = OnboardUseCases(
            GetItemFromQueue(queueTestManger),
            GetButtonStateQueue(queueTestManger),
            AddItemInQueue(queueTestManger),
            ClearQueue(queueTestManger),
            QueueIsEmpty(queueTestManger),
            CreateDefaultQueue(queueTestManger)
        )
        viewModel = OnboardViewModel(
            useCases
        )
    }

    private val nextButton = hasText("Next")
    private val signUpButton = hasText("Sign Up") and hasClickAction()
    private val signInButton = hasText("Sign in") and hasClickAction()


    @Test
    fun titleAndImageFromQueueGetCorrect() {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.onboardUseCases.clearQueue()
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            viewModel.getNextPage()
        }

        rule.setContent {
            OnboardScreen(viewModel = viewModel, navController = rememberNavController())
        }

        rule.onNodeWithText("title1").assertExists()
        rule.onNode(nextButton).performClick()
        rule.onNodeWithText("title2").assertExists()
    }


    @Test
    fun correctGetItemFromQueue() {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.onboardUseCases.clearQueue()
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            viewModel.getNextPage()
        }

        rule.setContent {
            OnboardScreen(viewModel = viewModel, navController = rememberNavController())
        }

        var beforeSize = false
        var afterSize = false

        GlobalScope.launch(Dispatchers.Main) {
            beforeSize = viewModel.onboardUseCases.queueIsEmpty() == true
            Log.i("tests", beforeSize.toString())
        }

        rule.onNode(nextButton).performClick()
        sleep(1000)

        GlobalScope.launch(Dispatchers.Main) {
            afterSize = viewModel.onboardUseCases.queueIsEmpty() == true
            Log.i("tests", afterSize.toString())
        }

        sleep(1000)
        assert(beforeSize!=afterSize)

    }

    @Test
    fun getCorrectButtonStateWithFullQueue() {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.onboardUseCases.clearQueue()
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 0))
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title3", "description3", 0))
            viewModel.getNextPage()
        }

        rule.setContent {
            OnboardScreen(viewModel = viewModel, navController = rememberNavController())
        }


        rule.onNode(nextButton).performClick()
        sleep(1000)
        rule.onNode(nextButton).assertExists()
    }

    @Test
    fun getCorrectButtonStateWithEmptyQueue() {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.onboardUseCases.clearQueue()
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            viewModel.getNextPage()
        }

        rule.setContent {
            OnboardScreen(viewModel = viewModel, navController = rememberNavController())
        }

        rule.onNode(nextButton).performClick()
        sleep(1000)
        rule.onNode(signUpButton).assertExists()

    }



    @Test
    fun getCorrectSignInNavigation() {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.onboardUseCases.clearQueue()
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title1", "description1", 0))
            viewModel.onboardUseCases.addItemInQueue(OnboardPage("title2", "description2", 1))
            viewModel.getNextPage()
        }

        rule.setContent {
            val navController = rememberNavController()
            NavHost(navController, Route.OnboardScreen.route){
                composable(Route.OnboardScreen.route){
                    OnboardScreen(viewModel = viewModel, navController = navController)
                }
                composable(Route.SignInScreen.route){
                    assert(true)
                    SignInScreen(viewModel = SignInViewModel(), navController = navController)
                }
            }
        }

        rule.onNode(nextButton).performClick()
        rule.onNode(signInButton).performClick()
    }

}