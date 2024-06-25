package com.pavel.m_banking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.pavel.m_banking.navigation.NavigationGraph
import com.pavel.m_banking.ui.account.AccountViewModel
import com.pavel.m_banking.ui.theme.MBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = ViewModelProvider(this)[AccountViewModel::class.java]
        setContent {
            MBankingTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationGraph(navigationController = rememberNavController(),
                        viewModel)
                }
            }
        }
    }
}

