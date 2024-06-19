package com.example.t_cauculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t_cauculator.databinding.ActivityMain2Binding

private lateinit var binding: ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val total_pessoas = intent.getIntExtra("total_persona", 0)
        val valor_conta = intent.getFloatExtra("valor_conta", 0.0F)
        val Porcentagem = intent.getIntExtra("porcentage",0)
        val valor_total = intent.getFloatExtra("valor_total", 0F)



        binding.tvValorConta.text = valor_conta.toString()
        binding.tvNumeropessoas.text = total_pessoas.toString()
        binding.tvPorcentagem.text = Porcentagem.toString()
        binding.tvTotal.text = valor_total.toString()


        binding.button6.setOnClickListener{
            finish()
        }

    }
}