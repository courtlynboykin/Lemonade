package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    var result by remember { mutableStateOf (1) }
    val image = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val instructions = when (result) {
        1 -> R.string.tree
        2 -> R.string.tap
        3 -> R.string.drink
        4 -> R.string.restart
        else -> R.string.tree
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Box {
            Button(
                onClick = { result++ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color.Yellow)
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = stringResource(R.string.tree),
                    modifier = modifier
                        .background(Color.Yellow)
                )
            }
        }
            Text(
                text = stringResource(instructions)
            )
        }

    }




@Composable
fun LemonSqueeze(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.lemon_squeeze),
                contentDescription = stringResource(R.string.lemon),
                modifier = modifier
                    .background(Color.Yellow)
            )
        }
        Text(
            text = stringResource(R.string.tap)
        )
    }

}


@Preview()
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
