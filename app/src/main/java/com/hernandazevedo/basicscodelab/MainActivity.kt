package com.hernandazevedo.basicscodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hernandazevedo.basicscodelab.R
import com.hernandazevedo.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box {
                        Example8()
                    }
                }
            }
        }
    }
}

@Composable
private fun MyApp() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
private fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
private fun Greetings(names: List<String> = List(1000) { "$it" } ) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun DefaultPreview() {
//    BasicsCodelabTheme {
//        Greetings()
//    }
//}
//
//@Preview(showBackground = true, widthDp = 320, heightDp = 320)
//@Composable
//fun OnboardingPreview() {
//    BasicsCodelabTheme {
//        OnboardingScreen(onContinueClicked = {})
//    }
//}

@Preview(showBackground = true)
@Composable
fun ExamplePreview() {
    LayoutExample(
        modifier = Modifier.fillMaxSize()
    )
}


@Composable
fun LayoutExample(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(10.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
            Modifier
                .background(Color.Red)
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Max)) {
            Text("1", modifier = Modifier.fillMaxWidth())
        }
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
            Modifier
                .background(Color.Green)
                .width(30.dp)
                .height(30.dp)) {
            Text("2", modifier = Modifier.background(Color.Gray))
        }
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
            Modifier
                .background(Color.Blue)
                .width(30.dp)
                .height(30.dp)) {
            Text("3")
        }
    }
}


@Preview
@Composable
fun ExamplePreview2() {
    MarginExample()
}

@Composable
fun MarginExample() {
    val shape = CircleShape
    Text(
        text = "Text 1",
        style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center),
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp)
            .border(2.dp, MaterialTheme.colors.secondary, shape)
            .background(MaterialTheme.colors.primary, shape)
            .padding(16.dp)
    )
}



@Composable
fun ShadowExample() {
    val padding = 20.dp
    val density = LocalDensity.current
    Surface(
        shape = RectangleShape,
        color = Color.White,
//        elevation = 10.dp,
        modifier = Modifier
            .padding(padding)
            .coloredShadow(
                shadowRadius = 10.dp,
                color = Color.Blue,
                offsetX = 10.dp
            )
            .drawWithContent {
                val paddingPx = with(density) { padding.toPx() }
                clipRect(
                    left = -paddingPx,
                    top = 0f,
                    right = size.width + paddingPx,
                    bottom = size.height + paddingPx
                ) {
                    this@drawWithContent.drawContent()
                }
            }
    ) {
        Text(
            "Hello",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}

fun Modifier.coloredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = composed {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha= 0f).toArgb()

    this.drawBehind {

        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparent

            frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )
            it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OffSetExamplePreview() {
    OffsetExample()
}

@Composable
fun OffsetExample() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
//        val modifier = Modifier.shadow(
//            elevation = 4.dp,
//            shape = RoundedCornerShape(8.dp)
//        )
//            .align(Alignment.BottomEnd)

        Box (modifier = Modifier
            .offset(x = 100.dp, y = 100.dp)){
//            Button(
//                onClick = { /*TODO*/ },
//
//            ) {
//                Text("Lorem Ipsum")
//            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OffSetExamplePreview2() {
    OffsetExample2()
}


@Composable
fun OffsetExample2() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val modifier = Modifier.shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        )

        Button(
            onClick = { /*TODO*/ },
//            modifier = Modifier
//                .offset(x = 100.dp, y = 100.dp)
        ) {
            Text("Lorem Ipsum")
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .offset(x = 100.dp, y = 100.dp)
        ) {
            Text("Lorem Ipsum")
        }


        Box( modifier = modifier.align(Alignment.BottomEnd)) {
            Button(
                onClick = { /*TODO*/ },
//            modifier = Modifier
//                .offset(x = 100.dp, y = 100.dp)
            ) {
                Text("Lorem Ipsum")
            }
        }
    }
}