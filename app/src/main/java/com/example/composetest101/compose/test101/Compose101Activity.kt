package com.example.composetest101.compose.test101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest101.R

class Compose101Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101()
        }
    }

}

@Composable
private fun Test101() {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(top = 64.dp)
            .padding(16.dp)

    ) {
        val painter: Painter = painterResource(R.drawable.kermit_snow)
        val description = "Kermit paying in the snow"
        val title = "Kermit is playing in the snow"
        ImageCard(painter = painter, title = title, contentDescription = description)
    }
}

@Composable
private fun ImageCard(
    painter: Painter,
    contentDescription: String = "",
    title: String = "",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "Something to be - Rob Thomas",
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewTest101() {
    Test101()
}