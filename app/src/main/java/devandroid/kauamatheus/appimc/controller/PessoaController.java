package devandroid.kauamatheus.appimc.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.kauamatheus.appimc.model.Pessoa;

public class PessoaController {
    public PessoaController() {
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "PessoaController iniciada");

        return super.toString();
    }

    public double calcularIMC(Pessoa pessoa) {
        double altura = pessoa.getAltura();
        double peso = pessoa.getPeso();

        return (peso / (altura * altura));
    }
}
