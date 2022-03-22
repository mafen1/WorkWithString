package com.example.task1

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.task1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "TAG"
    private var string = ""
    private var stringDelete = ""
    val i = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton(){
        binding.btnDeleteFirstChar.setOnClickListener {
            val imm = getSystemService(
                INPUT_METHOD_SERVICE
            ) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.edText.getWindowToken(), 0)

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
            val imm = getSystemService(
                INPUT_METHOD_SERVICE
            ) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.edText.getWindowToken(), 0)

            if (binding.edText.text.toString() != "") {

                string = binding.edText.text.toString()
                Log.d(TAG,string)
                val deleteLastChar = string.dropLast(1)
                Log.d(TAG, deleteLastChar)
                binding.tvResult.text = deleteLastChar
            } else {
                Snackbar.make(
                    binding.root,
                    "Введите хотя бы одно значение",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.btnConfirm.setOnClickListener{
            //binding.edText.text.contains(binding.edDeleteText.text)
            val imm = getSystemService(
                INPUT_METHOD_SERVICE
            ) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.edDeleteText.getWindowToken(), 0)
            if (binding.edText.text.contains(binding.edDeleteText.text)){
                string = binding.edText.text.toString()
                stringDelete = binding.edDeleteText.text.toString()

                val lengthText = stringDelete.length
                Log.d(TAG, lengthText.toString())
                val text = string.replace(stringDelete, "")
                Log.d(TAG, text)
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
    fun String.chunked(size: Int): List<String> {
        val nChunks = length / size
        return (0 until nChunks).map { substring(it * size, (it + 1) * size) }
    }
}