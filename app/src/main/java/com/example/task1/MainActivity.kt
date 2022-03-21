package com.example.task1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.task1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "TAG"
    private var string = ""
    private var string1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton(){
        binding.btnDeleteFirstChar.setOnClickListener {
            if (binding.edText.text.toString() == "") {
                Snackbar.make(
                    binding.root,
                    "Введите хотя бы одно значение",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                string = binding.edText.text.toString()
                val deleteFirstChar = string.drop(1)
                binding.tvResult.text = deleteFirstChar
            }
        }
        binding.btnDeleteLastChar.setOnClickListener {
            if (binding.edText.text.toString() == "") {
                Snackbar.make(
                    binding.root,
                    "Введите хотя бы одно значение",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                string = binding.edText.text.toString()
                val deleteLastChar = string.dropLast(1)
                binding.tvResult.text = deleteLastChar
            }
        }

        binding.btnConfirm.setOnClickListener{
            string1 = binding.edDeleteText.text.toString()
            if (binding.edDeleteText.text.toString() == binding.edText.text.toString()){
                val lengthText = binding.edDeleteText.text.length
                val text = string1.drop(lengthText)
                binding.tvResult.text = text
            }else{
                Snackbar.make(
                    binding.root,
                    "Нет совпадений",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

}