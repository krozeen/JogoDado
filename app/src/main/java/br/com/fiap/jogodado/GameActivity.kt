package br.com.fiap.jogodado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btJogar.setOnClickListener {
            realizarJogada()
        }
    }

    private fun realizarJogada() {
        val jogador = gerarNumero()
        val adversario = gerarNumero()

        configuraImagemDoDado(jogador, ivJogador)
        configuraImagemDoDado(adversario, ivAndroid)

        verificaVencedor(jogador, adversario)
    }

    private fun exibeMensagem(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
    }

    private fun gerarNumero(): Int {
        return Random().nextInt(5) + 1
    }

    private fun configuraImagemDoDado(numeroDado: Int, imagaView: ImageView) {
        when (numeroDado) {
            1 -> {
                setImagem(imagaView, R.drawable.dice1)
            }
            2 -> {
                setImagem(imagaView, R.drawable.dice2)
            }
            3 -> {
                setImagem(imagaView, R.drawable.dice3)
            }
            4 -> {
                setImagem(imagaView, R.drawable.dice4)
            }
            5 -> {
                setImagem(imagaView, R.drawable.dice5)
            }
            6 -> {
                setImagem(imagaView, R.drawable.dice6)
            }
        }
    }

    private fun verificaVencedor(numeroJogador: Int, numeroAdversario: Int) {
        if (numeroJogador < numeroAdversario) {
            exibeMensagem("PERDEU!!!")
        } else if (numeroJogador > numeroAdversario) {
            exibeMensagem("GANHOU!!!")
        } else {
            exibeMensagem("EMPATOU!!!")
        }
    }

    private fun setImagem(imageView: ImageView, idImagem: Int) {
        imageView.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }
}
