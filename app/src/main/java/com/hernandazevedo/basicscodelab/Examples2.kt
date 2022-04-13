package com.hernandazevedo.basicscodelab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import kotlin.math.roundToInt


@Preview(showBackground = true)
@Composable
fun ExampleLayoutsPreview() {
    Example13()
}

//1.Row: 3 elementos de tamanhos iguais que ocupam todo o espaço disponível (flex: 1).
@Composable
fun Example1() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Red)
                .height(50.dp)
        ) {
            ExampleText("r")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Green)
                .height(50.dp)
        ) {
            ExampleText("g")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Blue)
                .height(50.dp)

        ) {
            ExampleText("b")
        }
    }
}

//2.Igual ao anterior, mas com margin-left de 10 entre cada item.
@Composable
fun Example2() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
                .padding(start = 10.dp)
                .background(Color.Red)
                .height(50.dp)
        ) {
            ExampleText("r")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .padding(start = 10.dp)
                .background(Color.Green)
                .height(50.dp)

        ) {
            ExampleText("g")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .padding(start = 10.dp)
                .background(Color.Blue)
                .height(50.dp)


        ) {
            ExampleText("b")
        }
    }
}


//3.Igual ao primeiro, mas com padding-left de 10 entre cada item.
@Composable
fun Example3() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Red)
                .padding(start = 10.dp)
                .height(50.dp)
        ) {
            ExampleText("r")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Green)
                .padding(start = 10.dp)
                .height(50.dp)

        ) {
            ExampleText("g")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Blue)
                .padding(start = 10.dp)
                .height(50.dp)


        ) {
            ExampleText("b")
        }
    }
}

//4.Igual ao primeiro, mas o primeiro ocupa o dobro de espaço que os demais (flex 2).
@Composable
fun Example4() {
    Row(
//        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(2F)
                .background(Color.Red)
                .height(50.dp)
        ) {
            ExampleText("r")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Green)
                .height(50.dp)
        ) {
            ExampleText("g")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Blue)
                .height(50.dp)

        ) {
            ExampleText("b")
        }
    }
}

//5.Igual ao anterior, mas o primeiro tem margin top e bottom de 10 e o último padding e bottom de 10.
@Composable
fun Example5() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(2F)
                //before background is margin
                .padding(top = 10.dp)
                .padding(bottom = 10.dp)
                .background(Color.Red)
                .height(50.dp)

        ) {
            ExampleText("r")
        }
        Row(
            modifier = Modifier
                .weight(1F)

                .background(Color.Green)
                .height(50.dp)
        ) {
            ExampleText("g")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .background(Color.Blue)
                //after background is padding
                .padding(top = 10.dp)
                .padding(bottom = 10.dp)
                .height(50.dp)

        ) {
            ExampleText("b")
        }
    }
}

//6.Imagem com 100 de largura à esquerda de um componente que ocupa o resto do espaço disponível.
// Margem de 20 entre a imagem e o componente. O Retangulo deve ocupar a altura da imagem de
// maneira implícita.
@Composable
fun Example6() {

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
    ) {

        Image(
            painter = painterResource(R.drawable.forest),
            contentDescription = "Forest",
            modifier = Modifier
                .height(100.dp)
        )
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .background(Color.Blue)
                .fillMaxHeight()
                .weight(1F)
        )
//        {
////            ExampleText("b")
//        }
    }
}

//7.Row: variações de justify-content
@Composable
fun Example7() {
    RowWithDirection("flex-start", horizontalArrangement = Arrangement.Start)
//    RowWithDirection("flex-end", horizontalArrangement = Arrangement.End)
//    RowWithDirection(text = "center", horizontalArrangement = Arrangement.Center)
//     RowWithDirection(text = "space-around", horizontalArrangement = Arrangement.SpaceAround)
//     RowWithDirection(text = "space-between", horizontalArrangement = Arrangement.SpaceBetween)
//     RowWithDirection(text = "space-evenly", horizontalArrangement = Arrangement.SpaceEvenly)
}

//8.Row: variações de align-items
@Composable
fun Example8() {
    RowWithDirection("flex-start", verticalAlignment = Alignment.Top)
//    RowWithDirection("flex-end", verticalAlignment = Alignment.Bottom)
//    RowWithDirection(text = "center", verticalAlignment = Alignment.CenterVertically)

    //FIXME stretch ta com problema
//    RowWithDirection(text = "no height, stretch", itemHeight = 0, itemWidth = 50, stretch = true)


}

//9.Row: largura 300, altura indefinida. Overflow do texto deve criar novas linhas, aumentando a altura.
@Composable
fun Example9() {
    Row(modifier = Modifier
        .width(300.dp)
        .background(Color.LightGray)) {
        ExampleText("""
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et ipsum eu nunc semper dapibus vitae id urna. Aenean fermentum purus vitae leo congue varius vel nec ligula. Ut feugiat consectetur augue mattis tempus. Curabitur a erat nec lectus convallis vestibulum. Pellentesque suscipit id tellus ac dapibus. Vivamus aliquam, urna eu ornare euismod, arcu purus vestibulum dolor, ac tempus ante metus mollis ipsum. Ut eget tellus mollis, efficitur sapien in, pulvinar neque.
            """)
    }

}

//10.Igual ao anterior, mas o overflow do texto deve ser clipado.
@Composable
fun Example10() {
    //Warning colocou atributo(maxLines) no item ao inves do parent row
    Row(modifier = Modifier
        .width(300.dp)
        .background(Color.LightGray)
        ) {
        Text(text = """Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et ipsum eu nunc semper dapibus vitae id urna. Aenean fermentum purus vitae leo congue varius vel nec ligula. Ut feugiat consectetur augue mattis tempus. Curabitur a erat nec lectus convallis vestibulum. Pellentesque suscipit id tellus ac dapibus. Vivamus aliquam, urna eu ornare euismod, arcu purus vestibulum dolor, ac tempus ante metus mollis ipsum. Ut eget tellus mollis, efficitur sapien in, pulvinar neque.
            """,
            maxLines = 1,
//            overflow = TextOverflow.Ellipsis
            overflow = TextOverflow.Clip
            , color = Color.White)
    }


}


//11.Row: largura 300, altura indefinida. Overflow de componentes deve seguir para a próxima linha.
@Composable
fun Example11() {
    FlowRow(mainAxisSize = SizeMode.Wrap,
        modifier = Modifier
            .width(300.dp)
            .background(Color.LightGray)
    ) {
        Box(modifier = Modifier
            .background(Color.Red)
            .width(50.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Green)
            .width(100.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Blue)
            .width(80.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Cyan)
            .width(60.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.DarkGray)
            .width(120.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Magenta)
            .width(160.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.LightGray)
            .width(30.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Green)
            .width(300.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Black)
            .width(150.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Gray)
            .width(130.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Magenta)
            .width(40.dp)
            .height(30.dp)
        )
    }
}

//12.Igual o anterior, mas o overflow deve ser clipado.
@Composable
fun Example12() {
    Row(
        modifier = Modifier
            .width(300.dp)
            .background(Color.LightGray)
    ) {
        Box(modifier = Modifier
            .background(Color.Red)
            .width(50.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Green)
            .width(100.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Blue)
            .width(80.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Cyan)
            .width(60.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.DarkGray)
            .width(120.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Magenta)
            .width(160.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.LightGray)
            .width(30.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Green)
            .width(300.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Black)
            .width(150.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Gray)
            .width(130.dp)
            .height(30.dp)
        )
        Box(modifier = Modifier
            .background(Color.Magenta)
            .width(40.dp)
            .height(30.dp)
        )
    }
}

//12.Igual o anterior, mas o overflow deve ser clipado.
@Composable
fun Example13() {

    Row {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .border(BorderStroke(4.dp, Color.Red), shape = CircleShape)
                .padding(10.dp)
        )
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .border(BorderStroke(4.dp, Color.Green),
                    shape = RoundedCornerShape(50.dp))
                .padding(10.dp)
        )

    }

}

private data class DottedShape(
    val step: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val stepPx = with(density) { step.toPx() }
        val stepsCount = (size.width / stepPx).roundToInt()
        val actualStep = size.width / stepsCount
        val dotSize = Size(width = actualStep / 2, height = size.height)
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(x = i * actualStep, y = 0f),
                    size = dotSize
                )
            )
        }
        close()
    })
}

@Composable
private fun RowWithDirection(text: String,
                             itemWidth: Int = 50,
                             itemHeight: Int = 50,
                             stretch: Boolean = false,
                             verticalAlignment: Alignment.Vertical = Alignment.Top,
                             horizontalArrangement: Arrangement.Horizontal = Arrangement.Start) {
    val modifier = Modifier
        .width(150.dp)
        .height(150.dp)
        .padding(end = 10.dp)

    if(stretch) {
        Row(
            verticalAlignment = verticalAlignment,
            horizontalArrangement = horizontalArrangement,
            modifier = modifier
        ) {

            var itemModifier: Modifier = Modifier

            itemModifier = if(stretch) {
                itemModifier
            } else {
                itemModifier
                    .width(itemWidth.dp)
                    .height(itemHeight.dp)
            }
            Box(
                modifier = itemModifier
                    .background(Color.Blue)
            )
            {
                ExampleText(text)
            }

            Box(
                modifier = itemModifier
                    .background(Color.Red)
            )
        }
    }

    Row(
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        modifier = modifier
    ) {

        var itemModifier: Modifier = Modifier

        itemModifier = if(stretch) {
            itemModifier
        } else {
            itemModifier
                .width(itemWidth.dp)
                .height(itemHeight.dp)
        }
        Box(
            modifier = itemModifier
                .background(Color.Blue)
        )
        {
            ExampleText(text)
        }

        Box(
            modifier = itemModifier
                .background(Color.Red)
        )
    }
}

@Composable
fun ExampleText(text: String = "",
                textColor: Color = Color.White,
                modifier: Modifier = Modifier) {
    Text(text = text, color = textColor, modifier = modifier)
}


//@Composable
//fun Container(style: Style = Style(), modifier: Modifier = Modifier, content: @Composable ContainerScope.() -> Unit) {
//    modifier.height(50.dp)
//    Row(
//        modifier = modifier.flex(style.flex)
//    ) {
//        ContainerScopeInstance.content()
//    }
//}
//
//internal object ContainerScopeInstance : ContainerScope {
//    @Stable
//    override fun Modifier.flex(flex: Float): Modifier {
//        require(flex != 0F) { "invalid weight $flex; must be diferent than zero" }
//        return this.then(
//            this.weight(flex)
//        )
//    }
//}
//
//interface ContainerScope {
//    @Stable
//    fun Modifier.flex(
//        flex: Float = 0F,
//    ): Modifier
//}

