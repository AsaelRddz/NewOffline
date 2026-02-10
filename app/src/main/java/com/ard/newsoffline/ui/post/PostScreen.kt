package com.ard.newsoffline.ui.post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ard.newsoffline.domain.model.Post

@Composable
fun PostScreen(viewModel: PostViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when(uiState) {
        is PostUiState.Loading -> {
            LoadingView()
        }
        is PostUiState.Error -> {
            ErrorView()
        }
        is PostUiState.Success ->{
            val posts = (uiState as PostUiState.Success).posts
            PostList(posts)
        }
    }
}

@Composable
fun PostList(posts : List<Post>) {
    LazyColumn {
        items(items = posts, key = { it.id }) {
            PostItem(it)
        }
    }
}

@Composable
fun PostItem(post : Post) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = post.title,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(text = post.content,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Error loading posts")
    }
}