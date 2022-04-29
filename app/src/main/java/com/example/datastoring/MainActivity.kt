package com.example.datastoring

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.datastoring.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreference : SharedPreferences

    var storedData : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences
        sharedPreference = this.getSharedPreferences("com.example.datastoring", Context.MODE_PRIVATE)
        storedData = sharedPreference.getString("Data","-1")
        binding.textView.text = "Entered Data: $storedData"

    }


    fun save(view: View){

        var myText = binding.editText.text.toString()
        binding.textView.text = "Entered Data: ${myText}"

        sharedPreference.edit().putString("Data",myText).apply()
    }

    fun delete(view:View){
        storedData = sharedPreference.getString("Data","-1")

        if (storedData != "-1"){
            sharedPreference.edit().remove("Data").apply()
            binding.textView.text = "Entered Data: "
        }
    }






}