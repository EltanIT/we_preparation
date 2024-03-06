package com.example.ws_preparation.presentation.DeliverySuccessful

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.repository.PostCommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class DeliverySuccessfulViewModel @Inject constructor(
    private val postCommentRepository: PostCommentRepository
): ViewModel(), SensorEventListener {


    var isSuccessful by mutableStateOf(false)
        private set

    var comment by mutableStateOf("")
        private set

    var rating by mutableStateOf(0)
        private set

    var exception by mutableStateOf("")
        private set

    private var order_id = ""

    private var isRatingRedact = true

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null


    fun setOrder(id: String){
        order_id = id
    }


    fun postComment(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                postCommentRepository.postComment(comment, order_id, rating)
                withContext(Dispatchers.Main){
                    exception = "true"
                }

            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
                withContext(Dispatchers.Main){
                    exception = e.message.toString()
                }

            }
        }
    }

    init {
        timer()
    }

    fun timer(){
       object: CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                isSuccessful = true
            }

        }.start()
    }

    fun redactComment(it: String) {
        if (it.length<10){
            comment = it
        }
    }

    fun rotateInit(context: Context) {
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer =sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        accelerometer?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val x =event.values[0]
            if (x <= -5){
                if (isRatingRedact){
                    isRatingRedact = false
                    if (rating!=5){
                        rating++
                    }

                }
            }else if (x >= 5){
                if (isRatingRedact){
                    isRatingRedact = false
                    if (rating!=0){
                        rating--
                    }
                }
            }else if (x in -1.5..1.5) {
                isRatingRedact = true
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
    fun defaultException() {
        exception = ""
    }
}