package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .padding(20.dp)
        )
        var repeatSqueeze = (1..4).random()
        var result by remember { mutableIntStateOf(1) }
        when (result) {
            1 ->
                LemonTextAndImage(
                    image = painterResource(R.drawable.lemon_tree),
                    imageDescription = stringResource(R.string.tree),
                    onClick = { result++ },
                    instruction = stringResource(R.string.tap),
                    modifier = modifier
                )

            2 ->
                repeat(repeatSqueeze) {
                    LemonTextAndImage(
                        image = painterResource(R.drawable.lemon_squeeze),
                        imageDescription = stringResource(R.string.lemon),
                        onClick = {
                            repeatSqueeze--
                            if (repeatSqueeze == 0) {
                                result++
                            }
                        },
                        instruction = stringResource(R.string.squeeze),
                        modifier = modifier
                    )
                }

            3 ->
                LemonTextAndImage(
                    image = painterResource(R.drawable.lemon_drink),
                    imageDescription = stringResource(R.string.glass),
                    onClick = { result++ },
                    instruction = stringResource(R.string.drink),
                    modifier = modifier
                )

            4 ->
                LemonTextAndImage(
                    image = painterResource(R.drawable.lemon_restart),
                    imageDescription = stringResource(R.string.empty),
                    onClick = { result = 1 },
                    instruction = stringResource(R.string.restart),
                    modifier = modifier
                )
        }

    }

}

@Composable
fun LemonTextAndImage(
    image: Painter,
    imageDescription: String,
    onClick: () -> Unit,
    instruction: String,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = image,
            contentDescription = imageDescription,
            modifier = modifier
                .clip(shape = RoundedCornerShape(45.dp))
                .background(Color(0xFFd2e8d4))
                .border(
                    width = 2.dp,
                    color = Color(0xFF69CDD8),
                    shape = RoundedCornerShape(45.dp)
                )
                .size(200.dp)

                .clickable(onClick = onClick)
        )
        Text(
            text = instruction,
            fontSize = 18.sp,
            modifier = modifier
                .padding(top = 16.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
