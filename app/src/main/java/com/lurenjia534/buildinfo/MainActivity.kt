package com.lurenjia534.buildinfo

import android.icu.text.IDNA.Info
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lurenjia534.buildinfo.ui.theme.BuildInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildInfoTheme {
                APP()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun APP() {
    BuildInfoTheme {
        MaterialTheme {
            Scaffold(
                containerColor = Color(0xFFFFF6F6),
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Build Info", style = TextStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                ),
                                color = Color(0xFFFF8FA3)
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFFFFF1F4),
                        ),
                        navigationIcon = {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.padding(0.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Info,
                                    contentDescription = "Info",
                                    tint = Color(0xFFFF496A)
                                )
                            }
                        },
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(32.dp),
                        contentColor = Color(0xFFFF5C78),
                        containerColor = Color(0xFFFFEBEF),
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Love",
                        )
                    }
                },
                content = { innerPadding ->
                    APPUI(innerPadding)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun APPUI(innerPadding: PaddingValues) {
    LazyColumn(contentPadding = innerPadding) {
        item {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InfoCard(text = "Build Info")
            }
        }
        items(1) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    onClick = { },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(1f)
                        .graphicsLayer {
                            alpha = 0.8f // Adjust the transparency if needed
                            clip = true
                            scaleX = 0.8f
                            scaleY = 0.9f
                        },
                    colors = CardDefaults.cardColors(Color(0xFFFFFFFF)),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(0.6f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        InfoText("Android Version:")
                        InfoText("Android Level:")
                        InfoText("Android Build ID:")
                        InfoText("Brand:")
                        InfoText("Manufacturer:")
                        InfoText("Model:")
                        InfoText("Board:")
                        InfoText("Build fingerprint:")
                        InfoText("Product:")
                        InfoText("SKU:")
                        InfoText("Build Type:")
                    }
                }
            }
        }
        item {
            InfoCard(text =" Media Info")
        }
    }
}

@Composable
fun InfoText(text:String){
    Text(text = text,
        style = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        color = Color(0xFFFF4466),
        modifier = Modifier.fillMaxWidth()
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoCard(text: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(1f)
                .graphicsLayer {
                    alpha = 0.8f
                    clip = true
                    scaleX = 0.8f
                    scaleY = 0.9f
                },
            colors = CardDefaults.cardColors(Color(0xFFFFFFFF)),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = Color(0xFFFF2D53),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}