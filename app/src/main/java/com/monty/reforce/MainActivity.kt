package com.monty.reforce

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.monty.reforce.ui.screen.Wha_Top
import com.monty.reforce.ui.screen.CustomDatePicker
import com.monty.reforce.ui.theme.ReforceTheme
import com.monty.reforce.ui.screen.viewListUsers

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReforceTheme{
               Column {
                  // Wha_Top ()
                  // CustomDatePicker()
                   viewListUsers()
               }
            }
        }
    }
}
