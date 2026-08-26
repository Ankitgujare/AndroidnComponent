package com.example.androidjetpack._1_activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidjetpack._1_activitylifecycle.ui.theme.AndroidJetpackTheme

class ActivityLifeCycle : ComponentActivity() {
    private val TAG = "ActivityLifeCycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"oncreate :: ActivityLifeCycle")
        enableEdgeToEdge()
        setContent {
            AndroidJetpackTheme {
                val intent= Intent(
                    this@ActivityLifeCycle,
                    ActivityLifeCycle::class.java
                )
                Column(
                    modifier=Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            startActivity(intent)
                        }
                    ) {
                        Text("Back")
                    }
                }
            }
        }
    }

    override fun onStart() {
        Log.d(TAG,"onStart :: ActivityLifeCycle")
        super.onStart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy :: ActivityLifeCycle")
        super.onDestroy()
    }

    override fun onResume() {
        Log.d(TAG,"onResume :: ActivityLifeCycle")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause :: ActivityLifeCycle")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop :: ActivityLifeCycle")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart :: ActivityLifeCycle")
        super.onRestart()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Activity LifeCycle",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidJetpackTheme {
        Greeting("Android")
    }
}