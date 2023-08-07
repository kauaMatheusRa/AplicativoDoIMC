package devandroid.kauamatheus.appimc.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.kauamatheus.appimc.database.Lista_DB;
import devandroid.kauamatheus.appimc.model.Pessoa;
import devandroid.kauamatheus.appimc.view.MainActivity;

public class PessoaController extends Lista_DB {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
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

    public void salvar(Pessoa lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("peso", lista.getPeso());
        dados.put("altura",lista.getAltura());
        dados.put("resultado",lista.getResultado());

        salvarDados("Lista",dados);
    }

    public Pessoa buscar(Pessoa novaPessoa){
        novaPessoa.setPeso(preferences.getFloat("peso", 0.0F));
        novaPessoa.setAltura(preferences.getFloat("altura",0.0F));
        return novaPessoa;
    }
}


