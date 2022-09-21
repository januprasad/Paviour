package com.github.paviour

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.github.paviour.ui.theme.PaviourTheme

@Composable
fun TopSection(id: Int) {
    Box() {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 2.dp
        ) {
            ImageView(id)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column() {
                    Text(
                        text = "Constraint layout example with barriers",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Constraint layout example",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                    Column() {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "H1", color = Color.White, fontSize = 40.sp)
                            Text(text = "H2", color = Color.White, fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MiddleSection() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            ImageText(R.drawable.img, true)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            ImageText(R.drawable.img)
        }
//        Column(modifier = Modifier.fillMaxWidth().weight(1.0f)) {
//            TopSection(R.drawable.img)
//        }
//        Column(modifier = Modifier.fillMaxWidth().weight(1.0f)) {
//            TopSection(R.drawable.img)
//        }
    }
}

@Composable
fun EndSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            ImageText(R.drawable.img, true)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            ImageText(R.drawable.img)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            ImageText(R.drawable.img)
        }
//        Column(modifier = Modifier.fillMaxWidth().weight(1.0f)) {
//            TopSection(R.drawable.img)
//        }
//        Column(modifier = Modifier.fillMaxWidth().weight(1.0f)) {
//            TopSection(R.drawable.img)
//        }
    }
}

@Composable
fun ImageView(id: Any) {
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

@Composable
fun Progress() {
    Box(modifier = Modifier.size(50.dp, 50.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ImageText(id: Int, flip: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 2.dp
    ) {
        CardElement(id, flip)
    }
}

@Composable
fun CardElement(id: Int, flip: Boolean) {
    Row(
        modifier = if (flip) {
            Modifier
                .scale(scaleX = -1f, scaleY = 1f)
        } else {
            Modifier.fillMaxWidth()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            Text(
                text = "Image View",
                color = Color.Black,
                fontSize = 50.sp
            )
            Text(
                text = "Description",
                color = Color.Black,
                fontSize = 20.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        ) {
            ImageView(id = R.drawable.img)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopSectionPreview() {
    PaviourTheme {
        TopSection(id = R.drawable.img)
    }
}

@Preview(showBackground = true)
@Composable
fun MiddleSectionPreview() {
    PaviourTheme {
        MiddleSection()
    }
}

@Preview(showBackground = true)
@Composable
fun EndSectionPreview() {
    PaviourTheme {
        EndSection()
    }
}

@Preview(showBackground = true)
@Composable
fun ImageTextPreview() {
    PaviourTheme {
        ImageText(R.drawable.img)
    }
}
