package com.ard.newsoffline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ard.newsoffline.ui.post.PostScreen
import com.ard.newsoffline.ui.post.PostViewModel
import com.ard.newsoffline.ui.post.PostViewModelFactory
import com.ard.newsoffline.ui.theme.NewsOfflineTheme

/**
 * ViewModel pregunta
 * Repository decide
 * Data responde
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as MyApp

        enableEdgeToEdge()
        setContent {
            NewsOfflineTheme {

                val viewModel: PostViewModel = viewModel(
                    factory = PostViewModelFactory(LocalContext.current)
                )

                PostScreen(viewModel = viewModel)
                //PostScreen(viewModel = PostScreenViewModel(app.repository))
            }
        }
    }
}