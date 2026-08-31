package com.example.androidjetpack._1_activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidjetpack._1_activitylifecycle.ui.theme.AndroidJetpackTheme

class ActivityLifeCycle : ComponentActivity() {
    private val TAG = "${javaClass.simpleName}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"oncreate :: ActivityLifeCycle----------------------------------------------")
        enableEdgeToEdge()
        setContent {
            AndroidJetpackTheme {
                var showDialog by remember{
                    mutableStateOf(false)
                }

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

                    Button(
                        onClick = {
                            showDialog=!showDialog
                        }
                    ) {
                        Text("Show Dialog")
                    }


                    if (showDialog){
                        CustomAlertDialog(
                            onDismiss = {
                                showDialog=false
                            },
                            onConfirm = {
                                Toast.makeText(this@ActivityLifeCycle,"Click On dialog",Toast.LENGTH_SHORT).show()
                            }
                        )
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

@Composable
fun CustomAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text(text = "Delete Item")
        },

        text = {
            Text(text = "Are you sure you want to delete this item?")
        },

        confirmButton = {
            TextButton(
                onClick = onConfirm
            ) {
                Text("Yes")
            }
        },

        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}