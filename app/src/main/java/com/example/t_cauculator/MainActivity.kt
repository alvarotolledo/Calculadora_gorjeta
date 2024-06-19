package com.example.t_cauculator

import android.content.Intent
import android.os.Bundle


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

                intent = Intent(this, MainActivity2::class.java)
                intent.apply {
                    putExtra("total_persona", npleople)
                    putExtra("valor_conta", total)
                    putExtra("porcentage", percentage)
                    putExtra("valor_total", totalwh)
                }
                clean()
                startActivity(intent)


            }


        }

        binding.btnLimpar.setOnClickListener {

            clean()

        }


    }

    private fun clean(){

        binding.valorTotal.setText("")

    }
}

