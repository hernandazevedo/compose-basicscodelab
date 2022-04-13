package com.hernandazevedo.basicscodelab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun ExampleLayoutsPreview() {
    Example7()
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
//    RowWithDirection("flex-end", horizontalArrangement = Arrangement.End)
//    RowWithDirection(text = "center", horizontalArrangement = Arrangement.Center)
//     RowWithDirection(text = "space-around", horizontalArrangement = Arrangement.SpaceAround)
//     RowWithDirection(text = "space-between", horizontalArrangement = Arrangement.SpaceBetween)
//    RowWithDirection(text = "space-evenly", horizontalArrangement = Arrangement.SpaceEvenly)
}

@Composable
private fun RowWithDirection(text: String,
                             verticalAlignment: Alignment.Vertical = Alignment.Top,
                             horizontalArrangement: Arrangement.Horizontal = Arrangement.Start) {
    Row(
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)

    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .width(50.dp)
                .height(50.dp)
        )
        {
            ExampleText(text)
        }

        Box(
            modifier = Modifier
                .background(Color.Red)
                .width(50.dp)
                .height(50.dp)

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

