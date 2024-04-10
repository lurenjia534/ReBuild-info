package com.lurenjia534.buildinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
                containerColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    MyTopAppBar("Build Info")
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(32.dp),
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
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
                InfoCard(text = "System Info")
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
                        val deviceInfo = DeviceInfo()
                        InfoText("Android Version: ${deviceInfo.androidVersion}")
                        InfoText("Android Level: ${deviceInfo.androidLevel}")
                        InfoText("Android Build ID: ${deviceInfo.androidBuildID}")
                        InfoText("Brand: ${deviceInfo.brand}")
                        InfoText("Manufacturer: ${deviceInfo.manufacturer}")
                        InfoText("Model: ${deviceInfo.model}")
                        InfoText("Board: ${deviceInfo.board}")
                        InfoText("Build fingerprint: ${deviceInfo.buildFingerprint}")
                        InfoText("Product: ${deviceInfo.product}")
                        InfoText("SKU: ${deviceInfo.sku}")
                        InfoText("Build Type: ${deviceInfo.buildType}")
                    }
                }
            }
        }
        item {
            InfoCard(text = " Media Info")
        }
        item {
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
                            alpha = 0.8f
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
                        InfoText("supported Encoder:")
                        InfoText("supported Decoder:")
                        InfoText("HDR 10:")
                        InfoText("HDR 10+:")
                        InfoText("HLG:")
                        InfoText("DOLBY VISION:")
                        InfoText("Screen refresh rate:")
                    }
                }
            }
        }
        item{
            InfoCard(text = "Widevine Info")
        }
        item {
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
                            alpha = 0.8f
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
                        InfoText("Vendor:")
                        InfoText("Version:")
                        InfoText("DRM Level:")
                    }
                }
            }
        }
    }
}

@Composable
fun InfoText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier =Modifier.height(8.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoCard(text: String) {
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
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(text: String) {
    TopAppBar(
        title = {
            Text(
                text = text, style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
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
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
    )
}