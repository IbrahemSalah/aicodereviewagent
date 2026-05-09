package com.example.claudecodedemo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.claudecodedemo.ui.theme.ClaudeCodeDemoTheme

@Composable
fun ForgotPasswordScreen(
    onResetPasswordClick: (String, String) -> Unit,
    onBackToLoginClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Reset Password",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Button(
            onClick = { onResetPasswordClick(email, username) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Reset Password")
        }

        TextButton(
            onClick = { onBackToLoginClick() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Back to Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ClaudeCodeDemoTheme {
        ForgotPasswordScreen(
            onResetPasswordClick = { email, username ->
                // Handle reset password logic
            },
            onBackToLoginClick = {
                // Handle back to login
            }
        )
    }
}
