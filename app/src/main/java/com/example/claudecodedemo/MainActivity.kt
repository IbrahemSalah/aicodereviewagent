package com.example.claudecodedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.claudecodedemo.ui.theme.ClaudeCodeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaudeCodeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        onLoginClick = { email, password ->
                            handleLogin(email, password)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun handleLogin(email: String, password: String) {
        // Simple validation
        if (email.isNotBlank() && password.isNotBlank()) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
        }
    }
}
