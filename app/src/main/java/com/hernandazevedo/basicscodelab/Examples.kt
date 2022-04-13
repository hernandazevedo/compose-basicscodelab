package com.hernandazevedo.basicscodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ExamplePreview5() {
    LayoutExampleSize()
}

//3- Tamanho relativo ao parent e sieblings (flex 1) cresce ate o tamanho do irmao
@Composable
fun LayoutExamplePorcentage() {

    Column(

        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(2F)
                .width(50.dp)
                .background(Color.Red)
        ) {
            Text("1")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(50.dp)
                .background(Color.Green)
        ) {
            Text("2")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1F)
                .width(50.dp)
                .background(Color.Blue)

        ) {
            Text("3")
        }
    }
}

//3- Tamanho relativo ao parent e sieblings (flex 1) cresce ate o tamanho do irmao
@Composable
fun LayoutExampleSize() {

    Column(

        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(2F)
                .width(50.dp)
                .background(Color.Red)
        ) {
            Text("1")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(50.dp)
                .background(Color.Green)
        ) {
            Text("2")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1F)
                .width(50.dp)
                .background(Color.Blue)

        ) {
            Text("3")
        }
    }
}