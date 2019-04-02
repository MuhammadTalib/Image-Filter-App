package com.example.filterapp


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class AddedEffects : Activity() {

    lateinit var path: String
    lateinit var effect_chosen: String
    lateinit var changed: ImageView
    lateinit var out: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finalview)

        val i = intent
        path = i.getStringExtra("path")
        effect_chosen = i.getStringExtra("effect")

        changed = findViewById(R.id.view) as ImageView


        val thumbnail = BitmapFactory.decodeFile(path)

        if (effect_chosen.equals("tint", ignoreCase = true)) {
            out = addEffect(thumbnail, 5, 5.0, 6.0, 0.0)  //red,green,no blue
        } else if (effect_chosen.equals("violet", ignoreCase = true)) {
            out = addEffect(thumbnail, 5, 5.0, 0.0, 10.0)  //red,blue,no green
        } else if (effect_chosen.equals("Green effect", ignoreCase = true)) {
            out = addEffect(thumbnail, 5, 0.0, 10.0, 0.0)  //only green
        } else if (effect_chosen.equals("Amaro", ignoreCase = true)) {
            out = addEffect(thumbnail, 15, 5.0, 0.0, 10.0)  //red,blue,no green, depth increased
        } else if (effect_chosen.equals("RedEye", ignoreCase = true)) {
            out = addEffect(thumbnail, 5, 10.0, 0.0, 0.0)  //only red
        } else if (effect_chosen.equals("greyscale", ignoreCase = true)) {
            out = addEffect(thumbnail, 5, 10.0, 10.0, 10.0)  //depth, red blue and green
        } else if (effect_chosen.equals("winter", ignoreCase = true)) {
            out = addEffect(thumbnail, 15, 5.0, 5.0, 10.0)  //depth increased, red,green, blue
        } else if (effect_chosen.equals("Willow", ignoreCase = true)) {
            out = addEffect(thumbnail, 20, 0.0, 0.0, 0.0)  //Increased Depth
        } else if (effect_chosen.equals("Warm", ignoreCase = true)) {
            out = addEffect(thumbnail, 15, 10.0, 5.0, 0.0)  //depth, red and green, no blue
        } else if (effect_chosen.equals("Hudson", ignoreCase = true)) {
            out = addEffect(thumbnail, 5, 10.0, 5.0, 15.0)  //red,green, increased blue blue
        }

        changed.setImageBitmap(out)

    }

    companion object {


        fun addEffect(src: Bitmap, depth: Int, red: Double, green: Double, blue: Double): Bitmap {
            val width = src.width
            val height = src.height
            val finalBitmap = Bitmap.createBitmap(width, height, src.config)
            val grayScale_Red = 0.3
            val grayScale_Green = 0.59
            val grayScale_Blue = 0.11
            var channel_aplha: Int
            var channel_red: Int
            var channel_green: Int
            var channel_blue: Int
            var pixel: Int

            Log.e("hahaha","width=$width")
            Log.e("hahaha","height=$height")

            for (x in 0 until width) {
                for (y in 0 until height) {
                    pixel = src.getPixel(x, y)
                    channel_aplha = Color.alpha(pixel)
                    channel_red = Color.red(pixel)
                    channel_green = Color.green(pixel)
                    channel_blue = Color.blue(pixel)
                    channel_red =
                        (grayScale_Red * channel_red + grayScale_Green * channel_green + grayScale_Blue * channel_blue).toInt()
                    channel_green = channel_red
                    channel_blue = channel_green

                    channel_red += (depth * red).toInt()
                    if (channel_red > 255) {
                        channel_red = 255
                    }

                    channel_green += (depth * green).toInt()
                    if (channel_green > 255) {
                        channel_green = 255
                    }

                    channel_blue += (depth * blue).toInt()
                    if (channel_blue > 255) {
                        channel_blue = 255
                    }

                    finalBitmap.setPixel(x, y, Color.argb(channel_aplha, channel_red, channel_green, channel_blue))
                }
            }

            return finalBitmap
        }
    }
}
