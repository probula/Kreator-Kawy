package com.example.kreator_kawy

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image: ImageView = findViewById(R.id.imageCoffee)
        val imgEspresso: RadioButton = findViewById(R.id.rbEspresso)
        val imgCappuccino: RadioButton = findViewById(R.id.rbCappuccino)
        val imgLatte: RadioButton = findViewById(R.id.rbLatte)

        imgEspresso.setOnClickListener{
            image.setImageResource(R.drawable.espressozdj)
        }
        imgCappuccino.setOnClickListener{
            image.setImageResource(R.drawable.cappuccinozdj)
        }
        imgLatte.setOnClickListener{
            image.setImageResource(R.drawable.lattezdj)
        }
    }
}
