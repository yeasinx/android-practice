package com.example.composeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Article(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    val title = stringResource(R.string.article_title)
    val para1 = stringResource(R.string.article_para1)
    val para2 = stringResource(R.string.article_para2)

    Column (modifier = modifier) {
        ArticleImage()
        ArticleText(
            title = title,
            para1 = para1,
            para2 = para2
        )
    }
}

@Composable
fun ArticleImage() {
    val image = painterResource(R.drawable.bg_compose_background)

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArticleText (title: String, para1: String, para2: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = para1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp, 0.dp)
        )
        Text(
            text = para2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Article Preview")
@Composable
fun ArticlePreview() {
    ComposeActivityTheme {
        Scaffold() { innerPadding ->
            Article(modifier = Modifier.padding(innerPadding))
        }
    }
}