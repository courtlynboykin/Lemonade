package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MakeLemonade()
    }

}

@Composable
fun MakeLemonade(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            modifier = modifier
                .background(Color.Yellow)
                .fillMaxWidth()
        )
        var result by remember { mutableStateOf(1) }
        when (result) {
            1 ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color(0xFFd2e8d4))
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.tree),
                        modifier = modifier
                            .background(Color.White)
                            .clickable { result++ }
                    )
                    Text(
                        text = stringResource(R.string.tap)
                    )
                }

            2 ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color(0xFFd2e8d4))
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = modifier
                            .background(Color.White)
                            .clickable { result++ }
                    )
                    Text(
                        text = stringResource(R.string.squeeze)
                    )
                }

            3 ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color(0xFFd2e8d4))
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.glass),
                        modifier = modifier
                            .background(Color.White)
                            .clickable { result++ }
                    )
                    Text(
                        text = stringResource(R.string.drink)
                    )
                }

            4 ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color(0xFFd2e8d4))
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty),
                        modifier = modifier
                            .background(Color.White)
                            .clickable { result = 1 }
                    )
                    Text(
                        text = stringResource(R.string.restart)
                    )
                }

        }

    }
}

@Preview()
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
