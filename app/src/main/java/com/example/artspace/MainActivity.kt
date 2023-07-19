package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.dto.Next
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpace()
            }
        }
    }
}

@Composable
fun ArtSpace() {

    var art by remember {
        mutableStateOf(R.drawable.first)
    }

    var description by remember {
        mutableStateOf(R.string.first_image_description)
    }

    var artist by remember {
        mutableStateOf(R.string.artist_one)
    }

    var artYear by remember {
        mutableStateOf(R.string.image_one_year)
    }


    var position by remember{
        mutableStateOf(1)
    }
    
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {

        ArtCard(image = art, contentDescription = description,
            modifier = Modifier
                .padding(bottom = 50.dp, top = 50.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.75F))
        ArtDescription(description = description, artistName = artist, artYear = artYear, modifier = Modifier
            .fillMaxWidth()
            .background(
                colorResource(id = R.color.details_background)
            )
            .padding(20.dp)
            )
        ArtSpaceNavigation(previous = {
            val nextImage = previousImage(position)
            art = nextImage.image
            description = nextImage.description
            artist = nextImage.artist
            artYear = nextImage.year
            position = nextImage.position
        }, next = {
            val nextImage = nextImage(position)
            art = nextImage.image
            description = nextImage.description
            artist = nextImage.artist
            artYear = nextImage.year
            position = nextImage.position
        })


        
    }

}
@VisibleForTesting
internal fun nextImage(currentPosition: Int): Next {

    return when(currentPosition) {
        1 -> Next(image = R.drawable.second, description = R.string.second_image_description,
            artist = R.string.artist_two, year = R.string.image_two_year, position = currentPosition + 1)
        2 -> Next(image = R.drawable.third, description = R.string.third_image_description,
            artist = R.string.artist_three, year = R.string.image_three_year, position = currentPosition + 1)
        else -> Next(image = R.drawable.first, description = R.string.first_image_description,
            artist = R.string.artist_one, year = R.string.image_one_year, position = 1)
    }

}

@VisibleForTesting
internal fun previousImage(currentPosition: Int): Next {

    return when(currentPosition) {
        3 -> Next(image = R.drawable.second, description = R.string.second_image_description,
            artist = R.string.artist_two, year = R.string.image_two_year, position = currentPosition - 1)
        2 -> Next(image = R.drawable.first, description = R.string.first_image_description,
            artist = R.string.artist_one, year = R.string.image_one_year, position = currentPosition - 1)
        else -> Next(image = R.drawable.third, description = R.string.third_image_description,
            artist = R.string.artist_three, year = R.string.image_three_year, position = 3)
    }

}


@Composable
fun ArtCard (modifier: Modifier = Modifier, @DrawableRes image: Int, @StringRes contentDescription: Int) {

    
    Row(modifier = modifier
        .fillMaxWidth()) {

        Image(painter = painterResource(id = image) ,
            contentDescription = stringResource(id = contentDescription),
        contentScale = ContentScale.Crop)

    }

}

@Composable
fun ArtDescription(modifier: Modifier = Modifier, description: Int,
artistName: Int, artYear: Int) {

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Row{
            Text(text = stringResource(id = description), fontSize = 32.sp)
        }

        Row{
            Text(text = stringResource(id = artistName), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = stringResource(id = artYear), fontSize = 24.sp )
        }

    }


    
}

@Composable
fun ArtSpaceNavigation(modifier: Modifier = Modifier, previous: () -> Unit,
next: () -> Unit) {

    Row(modifier = modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween) {

        Button(onClick = previous, modifier = Modifier.width(92.dp)) {
            Text(text = "Previous")
        }

        Button(onClick = next, modifier = Modifier.width(92.dp)) {
            Text(text = "Next")
        }

    }
    
}



@Composable
@Preview
fun ArtSpaceApp() {
    ArtSpace()
}



