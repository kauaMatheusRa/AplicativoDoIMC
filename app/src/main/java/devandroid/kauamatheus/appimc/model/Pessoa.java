package devandroid.kauamatheus.appimc.model;

import androidx.annotation.NonNull;

public class Pessoa {
    private float peso;
    private float altura;
    private String resultado;

    public Pessoa(){

    }

    public Pessoa(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public Pessoa(float peso, float altura, String resultado) {
        this.peso = peso;
        this.altura = altura;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @NonNull

    @Override
    public String toString() {
        return "Pessoa{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
