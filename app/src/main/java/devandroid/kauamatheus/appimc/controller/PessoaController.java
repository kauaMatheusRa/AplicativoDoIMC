package devandroid.kauamatheus.appimc.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.kauamatheus.appimc.model.Pessoa;
import devandroid.kauamatheus.appimc.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

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

    public Pessoa salvar(Pessoa novaPessoa) {
        Log.d("MVC_Controller","Salvo"+novaPessoa.toString());

        listaVip.putFloat("peso", novaPessoa.getPeso());
        listaVip.putFloat("altura", novaPessoa.getAltura());
        listaVip.apply();
        return novaPessoa;
    }

    public Pessoa buscar(Pessoa novaPessoa){
        novaPessoa.setPeso(preferences.getFloat("peso", 0.0F));
        novaPessoa.setAltura(preferences.getFloat("altura",0.0F));
        return novaPessoa;
    }
}


