package com.example.androidjetpack._2_Asynchronous_Kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidjetpack._2_Asynchronous_Kotlin.ui.theme.AndroidJetpackTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val TAG=javaClass.simpleName

        enableEdgeToEdge()
        setContent {
            AndroidJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  Text("CoroutinActivity",
                      Modifier.padding(innerPadding))
                }
            }
        }
        runBlocking {


            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG,"Coroutine A is Finished")
            }

            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG,"Coroutine B is Finished")
            }

            Log.d(TAG,"Runblocking started")
            delay(3000L)
            Log.d(TAG,"Runblocking End")
        }
        Log.d(TAG,"back to Main")

    }
}

