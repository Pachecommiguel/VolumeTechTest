package com.pacheco.volumetechtest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pacheco.volumetechtest.domain.model.WeatherModel
import com.pacheco.volumetechtest.router.ApplicationNavHost
import com.pacheco.volumetechtest.ui.theme.VolumeTechTestTheme
import com.pacheco.volumetechtest.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolumeTechTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    WeatherLayer(viewModel = viewModel)
                    ApplicationNavHost()
                }
            }
        }
    }
}

@Composable
private fun WeatherLayer(viewModel: MainViewModel) {
    var weather: WeatherModel? by remember {
        mutableStateOf(null)
    }

    var alignment: Pair<Alignment?, Alignment.Horizontal?> by remember {
        mutableStateOf(null to null)
    }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            alignment = when(alignment.first) {
                Alignment.TopStart -> Alignment.TopEnd to Alignment.End
                Alignment.TopEnd -> Alignment.TopStart to Alignment.Start
                else -> Alignment.TopStart to Alignment.Start
            }
            delay(timeMillis = TimeUnit.SECONDS.toMillis(30))
        }
    }

    weather?.let {
        Box(
            contentAlignment = alignment.first ?: Alignment.TopStart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.Blue)
                    .padding(all = 10.dp),
                horizontalAlignment = alignment.second ?: Alignment.Start
            ) {
                Text(text = it.temp.toString() + "ºC")
                Text(text = it.city)
            }
        }
    } ?: viewModel.getWeather {
        weather = it
    }
}