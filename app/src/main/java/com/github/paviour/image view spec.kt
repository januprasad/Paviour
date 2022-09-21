package com.github.paviour

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun ImageView(id: Any) {
    ImageViewWrapper {
        SubcomposeAsyncImage(
            model = id,
            contentDescription = "coil_image_view",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillHeight
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                Progress()
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}

@Composable
fun ImageViewWrapper(content: @Composable () -> Unit) {
    content()
}

@Composable
fun Progress() {
    Box(modifier = Modifier.size(50.dp, 50.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}
