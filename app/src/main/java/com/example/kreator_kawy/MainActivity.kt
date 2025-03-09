package com.example.kreator_kawy

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
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

        val seekBar: SeekBar = findViewById(R.id.ilosc)
        val wyswietl: TextView = findViewById(R.id.wyswietlSB)

        wyswietl.text = "Ilość kaw: ${seekBar.progress}"

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                wyswietl.text = "Ilość kaw: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //kod
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //kod
            }
        })

        val button = findViewById<Button>(R.id.submit);
        val mleko = findViewById<CheckBox>(R.id.mleko);
        val cukier = findViewById<CheckBox>(R.id.cukier)

        button.setOnClickListener{
            val wybranaKawa: String = when{
                imgEspresso.isChecked -> "Espresso"
                imgCappuccino.isChecked -> "Cappuccino"
                imgLatte.isChecked -> "Latte"
                else -> "Brak wyboru!"
            }

            val dodatki = mutableListOf<String>()
            if(mleko.isChecked) dodatki.add("mleko")
            if(cukier.isChecked) dodatki.add("cukier")
            val tekstDodatki = if (dodatki.isEmpty()) "brak dodatków" else dodatki.joinToString(", ")
            val ilosc = seekBar.progress

            Toast.makeText(this, "Zamówiono!", Toast.LENGTH_LONG).show()

            val podsumowanie: String = ("Zamówiono $ilosc kaw $wybranaKawa, dodatki: $tekstDodatki")

            Log.d("Zamówienie: ", podsumowanie)
        }
    }
}
