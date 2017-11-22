package com.example.android.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tip = 0.15
        val spinner = findViewById<Spinner>(R.id.percent_spinner)
        spinner.adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                resources.getStringArray(R.array.percent_array))
        spinner.setSelection(1)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You have selected " + spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
                tip = if (position == 0) {0.10}
                else if (position == 2) {0.2}
                else if (position == 3) {0.25}
                else{0.15}
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        val button = findViewById<Button>(R.id.calculate_button)
        val totalAmountText = findViewById<EditText>(R.id.total_amount)
        val totalText = findViewById<TextView>(R.id.total_amt)
        button.setOnClickListener {
            Toast.makeText(this@MainActivity, "total amount value is " + totalAmountText.text, Toast.LENGTH_SHORT).show()
            var total = (totalAmountText.text.toString().toFloat()) * tip
            totalText.text = total.toString()
        }

    }
}
