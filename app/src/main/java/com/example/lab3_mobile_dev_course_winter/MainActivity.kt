package com.example.lab3_mobile_dev_course_winter

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3_mobile_dev_course_winter.ui.theme.Lab3mobiledevcoursewinterTheme
import androidx.compose.ui.graphics.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(){
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)){
        NavHost(navController, startDestination = NavRoutes.Base.route){
            composable(NavRoutes.Base.route) {Base(navController = navController)}
            composable(NavRoutes.First.route) {First(navController = navController)}
        }
    }
}


@Composable
fun Base(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {navController.navigate(NavRoutes.First.route)}
        ) {
            Text("First")
        }
    }
}

@Composable
fun First(modifier: Modifier = Modifier, navController: NavController) {
    Button(
       onClick =  {navController.navigate(NavRoutes.Base.route)}
    ){

    }
    Column(
        modifier = Modifier.size(286.dp, 524.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ){
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Green)
        )
    }
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.CenterHorizontally)
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Red)
        )
//        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Blue)
        )
    }
}


sealed class NavRoutes(val route: String){

    object Base: NavRoutes("Base")
    object First: NavRoutes("First")
}
