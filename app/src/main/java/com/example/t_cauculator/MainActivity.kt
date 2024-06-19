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


        binding.btnCalcular.setOnClickListener {

            val totate = binding.valorTotal.text
            val npleople = binding.numeropesoas.text
            val porcen =binding.porcentaaa.text

            if (totate?.isEmpty() == true || npleople?.isEmpty() == true || porcen?.isEmpty() == true ) {

                Snackbar.make(
                    binding.valorTotal, "Por gentileza, Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val npleople: Int = npleople.toString().toInt()
                val total: Float = totate.toString().toFloat()
                val pertenge : Int = porcen.toString().toInt()

                val totaltemp = total / npleople
                val tips = totaltemp * pertenge / 100
                val totalwh = totaltemp + tips

                intent = Intent(this, MainActivity2::class.java)
                intent.apply {
                    putExtra("total_persona", npleople)
                    putExtra("valor_conta", total)
                    putExtra("porcentage", pertenge)
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
        binding.porcentaaa.setText("")
        binding.numeropesoas.setText("")
        binding.valorTotal.setText("")

    }
}

