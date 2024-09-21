package com.example.warsztat

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var leather = "Nie wybrano skórzanej tapicerki."
    var acc = "Nie wybrano klimatyzacji."
    var checkedCar = "Nie wybrano żadnego pojazdu."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val image = findViewById<ImageView>(R.id.the_image)
        radioGroup.setOnCheckedChangeListener { _, isChecked ->
            val radioButton = findViewById<RadioButton>(isChecked)
            checkedCar = radioButton.text.toString()

            if(checkedCar == "Sedan"){
                image.setImageResource(R.drawable.sedan)
            }
            else if(checkedCar == "SUV"){
                image.setImageResource(R.drawable.suv)
            }
            else{
                image.setImageResource(R.drawable.hatchback)
            }
        }

        val checkedLeather = findViewById<CheckBox>(R.id.leather)
        val checkedACC = findViewById<CheckBox>(R.id.acc)

        checkedLeather.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                leather = "Skórzana tapicerka została dobrana."
            }
        }
        checkedACC.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                acc = "Klimatyzacja została dobrana."
            }
        }

        val submit = findViewById<Button>(R.id.submit)
        val info = findViewById<TextView>(R.id.info)
        submit.setOnClickListener{
            info.text = "Pomyslnie wybrales $checkedCar. $leather $acc"
        }
    }
}