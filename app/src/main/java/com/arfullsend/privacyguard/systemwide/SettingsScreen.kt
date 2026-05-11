package com.arfullsend.privacyguard.systemwide

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    var autoStartEnabled by remember { mutableStateOf(true) }
    var sensitivity by remember { mutableStateOf(0.75f) }
    var powerSavingEnabled by remember { mutableStateOf(true) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Auto-start on Boot", modifier = Modifier.weight(1f))
            Switch(
                checked = autoStartEnabled,
                onCheckedChange = { autoStartEnabled = it }
            )
        }
        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Power Saving Mode", modifier = Modifier.weight(1f))
            Switch(
                checked = powerSavingEnabled,
                onCheckedChange = { powerSavingEnabled = it }
            )
        }
        
        Text("Detection Sensitivity: ${(sensitivity * 100).toInt()}%")
        Slider(
            value = sensitivity,
            onValueChange = { sensitivity = it },
            valueRange = 0.5f..0.95f
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = { /* Save settings */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Settings")
        }
    }
}