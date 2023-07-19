package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {

            }
        }
    }
}

@Composable
fun ArtSpace() {
    
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        
    }

}


@Composable
fun ArtCard (modifier: Modifier = Modifier) {

}

@Composable
fun ArtDescription(modifier: Modifier = Modifier) {
    
}

@Composable
fun ArtSpaceNavigation(modifier: Modifier = Modifier) {
    
}



@Composable
@Preview
fun ArtSpaceApp() {
    ArtSpace()
}



