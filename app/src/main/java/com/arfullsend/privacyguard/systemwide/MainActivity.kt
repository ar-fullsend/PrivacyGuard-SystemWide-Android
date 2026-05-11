package com.arfullsend.privacyguard.systemwide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    
    private lateinit var cameraManager: CameraManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        cameraManager = CameraManager(this)
        
        setContent {
            MaterialTheme {
                SystemWideScreen(
                    onStart = { cameraManager.startCamera { faceCount ->
                        // Trigger overlay when 2+ faces detected
                        if (faceCount >= 2) {
                            // Activate full-screen overlay
                        }
                    }},
                    onStop = { cameraManager.stopCamera() }
                )
            }
        }
    }
}

@Composable
fun SystemWideScreen(
    onStart: () -> Unit,
    onStop: () -> Unit
) {
    var isActive by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "PrivacyGuard System-Wide",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = if (isActive) "🟢 Active - Monitoring" else "🔴 Inactive",
            style = MaterialTheme.typography.titleLarge
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = {
                isActive = !isActive
                if (isActive) onStart() else onStop()
            }
        ) {
            Text(if (isActive) "Stop Shield" else "Start Shield")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Real CameraX + ML Kit integration active",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}