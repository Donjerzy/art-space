package com.example.artspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LocalTests {

    @Test
    fun next_image_returns_next_image() {

        val currentPosition = 3
        val nextImage = nextImage(currentPosition)
        assertEquals(1, nextImage.position)

    }

    @Test
    fun previous_image_returns_previous_image() {

        val currentPosition = 1
        val nextImage = previousImage(currentPosition)
        assertEquals(3, nextImage.position)

    }




}