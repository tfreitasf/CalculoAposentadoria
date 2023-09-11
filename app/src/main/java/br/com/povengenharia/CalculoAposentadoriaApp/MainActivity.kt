package br.com.povengenharia.CalculoAposentadoriaApp

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val spinnerGender = findViewById<Spinner>(R.id.sp_gender)
        val editTextAge = findViewById<EditText>(R.id.ed_age)
        val buttonCalculate = findViewById<Button>(R.id.bt_calculate)
        val editTextResult = findViewById<TextView>(R.id.tv_result)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino")
        )

        spinnerGender.adapter = adapter

        buttonCalculate.setOnClickListener {
            val genderSelected = spinnerGender.selectedItem as String
            val age = editTextAge.text.toString().toInt()
            var result = 0

            if (genderSelected == "Masculino") {
                result = 65 - age

            } else {
                result = 62 - age
            }

            editTextResult.text = "Faltam $result anos para você se aposentar"


        }


    }
}