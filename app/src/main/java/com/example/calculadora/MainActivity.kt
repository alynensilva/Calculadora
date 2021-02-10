package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder /* Biblioteca que validará as expressões e realizará os cálculos */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Teclado numérico*/

        numUm.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        numDois.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        numTres.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        numQuatro.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        numCinco.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        numSeis.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        numSete.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        numOito.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        numNove.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        numZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operadores*/

        opSoma.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        opSub.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        opMult.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        opDiv.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        opPot.setOnClickListener {
            evaluateExpression("^", clear = true)
        }

        numPonto.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        acaoLimpar.setOnClickListener {
            txtExpressao.text = ""
            txtResultado.text = ""
        }

        /* Ação do botão de resultado que chama a função da biblioteca Expression Builder para realizar o cálculo */

        acaoResultado.setOnClickListener {
            val texto = txtExpressao.text.toString()
            val expressao = ExpressionBuilder(texto).build()

            val resultado = expressao.evaluate()
            val longResultado = resultado.toLong()
            if (resultado == longResultado.toDouble()) {
                txtResultado.text = longResultado.toString()
            } else {
                txtResultado.text = resultado.toString()
            }
        }

        acaoLimpar.setOnClickListener {
            val texto = txtExpressao.text.toString()
            if(texto.isNotEmpty()) {
                txtExpressao.text = texto.drop(1)
            }

            txtResultado.text = ""
        }

        acaoApagar.setOnClickListener {
            val texto = txtExpressao.text.toString()
            if(texto.isNotEmpty()) {
               txtExpressao.setText("")
               txtResultado.setText("")
            }

            txtResultado.text = ""
        }
    }

    /*Função para calcular o resultando utilizando a biblioteca Expression Builder*/

    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            txtResultado.text = ""
            txtExpressao.append(string)
        } else {
            txtResultado.append(txtResultado.text)
            txtExpressao.append(string)
            txtResultado.text = ""
        }
    }
}
