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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MaterialTheme {
                SystemWideScreen()
            }
        }
    }
}

@Composable
fun SystemWideScreen() {
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
            onClick = { isActive = !isActive }
        ) {
            Text(if (isActive) "Stop Shield" else "Start Shield")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Camera + ML Kit integration coming soon",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}