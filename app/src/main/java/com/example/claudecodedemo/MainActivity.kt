package com.example.claudecodedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.claudecodedemo.ui.theme.ClaudeCodeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaudeCodeDemoTheme {
                var currentScreen by remember { mutableStateOf("login") }
                
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (currentScreen) {
                        "login" -> LoginScreen(
                            onLoginClick = { email, password ->
                                handleLogin(email, password)
                            },
                            onForgotPasswordClick = {
                                currentScreen = "forgot_password"
                            },
                            modifier = Modifier.padding(innerPadding)
                        )
                        "forgot_password" -> ForgotPasswordScreen(
                            onResetPasswordClick = { email, username ->
                                if (handleResetPassword(email, username)) {
                                    currentScreen = "login"
                                }
                            },
                            onBackToLoginClick = {
                                currentScreen = "login"
                            },
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
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

    private fun handleResetPassword(email: String, username: String): Boolean {
        // Simple validation
        return if (email.isNotBlank() && username.isNotBlank()) {
            Toast.makeText(this, "Password reset link sent!", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, "Please enter email and username", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
