package com.example.t_cauculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

import androidx.appcompat.app.AppCompatActivity

import com.example.t_cauculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var percentage = 0
        var numpeopleselect = 0


        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item

        )

        binding.spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    numpeopleselect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinner.adapter = adapter







        binding.optionOn.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                percentage = 10
            }

        }

        binding.optionTrue.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                percentage = 15
            }

        }

        binding.optionTri.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                percentage = 20
            }
        }









        binding.btnCalcular.setOnClickListener {

            val totate = binding.valorTotal.text

            if (totate?.isEmpty() == true) {

                Snackbar.make(
                    binding.valorTotal, "Por gentileza, Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val npleople: Int = numpeopleselect
                val total: Float = totate.toString().toFloat()

                val totaltemp = total / npleople
                val tips = totaltemp * percentage / 100
                val totalwh = totaltemp + tips

                binding.tvResult.text = "total tips : $totalwh"

            }


        }

        binding.btnLimpar.setOnClickListener {

            binding.tvResult.text = ""
            binding.valorTotal.setText("")
            binding.spinner.isSelected = false
            binding.optionOn.isChecked = false
            binding.optionTrue.isChecked = false
            binding.optionTri.isChecked = false


            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }


    }
}

