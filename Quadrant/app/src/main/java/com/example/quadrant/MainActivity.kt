package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   QuadrantContainer(
                       modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}

@Composable
fun QuadrantContainer(modifier : Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(R.string.text_title) ,
                description = stringResource(R.string.text_description),
                color = colorResource(R.color.quad1),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.image_title) ,
                description = stringResource(R.string.image_description),
                color = colorResource(R.color.quad2),
                modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(R.string.row_title) ,
                description = stringResource(R.string.row_description),
                color = colorResource(R.color.quad3),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.column_title) ,
                description = stringResource(R.string.column_description),
                color = colorResource(R.color.quad4),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    color: Color,
    modifier : Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    QuadrantTheme {
        Column(Modifier.fillMaxSize()) {
            Row(Modifier.weight(1f)) {
                Quadrant(
                    title = stringResource(R.string.text_title) ,
                    description = stringResource(R.string.text_description),
                    color = colorResource(R.color.quad1),
                    modifier = Modifier.weight(1f)
                )
                Quadrant(
                    title = stringResource(R.string.image_title) ,
                    description = stringResource(R.string.image_description),
                    color = colorResource(R.color.quad2),
                    modifier = Modifier.weight(1f))
            }
            Row(Modifier.weight(1f)) {
                Quadrant(
                    title = stringResource(R.string.row_title) ,
                    description = stringResource(R.string.row_description),
                    color = colorResource(R.color.quad3),
                    modifier = Modifier.weight(1f)
                )
                Quadrant(
                    title = stringResource(R.string.column_title) ,
                    description = stringResource(R.string.column_description),
                    color = colorResource(R.color.quad4),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}