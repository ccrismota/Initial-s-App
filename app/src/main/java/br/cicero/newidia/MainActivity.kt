package br.cicero.newidia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

   var valorGasolina = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Carregar minha seekbar

        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasolina = findViewById<TextView>(R.id.txtvalorGasolina)
        val txtResultado = findViewById<TextView>(R.id.Resultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)


        //tamanho da seekbar
        seekbar.max = 1000

        //definir lista para a seekbar
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valorGasolina = progress
                var texto = "R$ "
                texto += this@MainActivity.formataValor(valorGasolina/100.0)
                txtGasolina.text = texto
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Selecione o  valor da Gasolina"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Click em Calcular para saber o Resultado"

            }

        })

        //listener do botão
        btnCalcular.setOnClickListener {
            var valorResultado = (valorGasolina*0.7)/100.0
            var texto = "Abasteça com Alcool se ele custar até: R$ "
            texto +=formataValor(valorResultado)
            txtResultado.text = texto

        }




    }

    private fun formataValor(valor: Double): Any? {
        return String.format(Locale.FRANCE, "%.2f",valor)
    }
}