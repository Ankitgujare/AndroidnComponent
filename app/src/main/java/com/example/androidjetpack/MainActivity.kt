package com.example.androidjetpack

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidjetpack._1_activitylifecycle.ActivityLifeCycle
import com.example.androidjetpack.ui.theme.AndroidJetpackTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    private val TAG = "${javaClass.simpleName}"
    private val TAG1 = "Coroutine"
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate :: MainActivity")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG1,"Hello from Coroutine Running On the Thread ::  ${Thread.currentThread().name}")
        }
        Log.d(TAG1,"Hello From the Main Thread ::  ${Thread.currentThread().name}")
        setContent {
            AndroidJetpackTheme {
               /* Intent(
                    this,
                    ActivityLifeCycle::class.java
                ).also {
                    startActivity(it)
                }*/
                Column(
                    modifier=Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val intent= Intent(
                        this@MainActivity,
                        ActivityLifeCycle::class.java
                    )
                    Button(onClick = {
                       startActivity(intent)
                    }) {
                        Text("Next Page")
                    }
                }
            }
        }
    }

    override fun onStart() {
        Log.d(TAG,"onStart :: MainActivity")
        super.onStart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy :: MainActivity")
        super.onDestroy()
    }

    override fun onResume() {
        Log.d(TAG,"onResume :: MainActivity")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause :: MainActivity")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop :: MainActivity")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart :: MainActivity")
        super.onRestart()
    }
}

