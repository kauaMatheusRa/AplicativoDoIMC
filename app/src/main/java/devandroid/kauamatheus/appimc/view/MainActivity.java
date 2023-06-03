package devandroid.kauamatheus.appimc.view;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import devandroid.kauamatheus.appimc.R;
import devandroid.kauamatheus.appimc.controller.PessoaController;
import devandroid.kauamatheus.appimc.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;

    EditText inputAltura;
    EditText inputPeso;

    Button btnCalcularImc;

    TextView resultadoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController();

        inputAltura = findViewById(R.id.editTextAltura);
        inputPeso = findViewById(R.id.editTextPeso);
        btnCalcularImc = findViewById(R.id.button_calcular);
        resultadoImc = findViewById(R.id.textView);

        btnCalcularImc.setOnClickListener(view -> calcularImc());
    }

    private void calcularImc(){
        Pessoa novaPessoa;

        double alturaValue;
        double pesoValue;
        double calculoImc;
        String calculoImcFormated;

        try{
            alturaValue = Double.parseDouble(inputAltura.getText().toString());
            pesoValue = Double.parseDouble(inputPeso.getText().toString());

            if(alturaValue > 0 && pesoValue > 0){
                novaPessoa = new Pessoa(pesoValue, alturaValue);

                calculoImc = Math.ceil(controller.calcularIMC(novaPessoa));
                calculoImcFormated = format(Locale.ENGLISH,"Resultado: %.2f%n", calculoImc);

                resultadoImc.setText(calculoImcFormated);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            Toast.makeText(MainActivity.this, "Valor inválido", Toast.LENGTH_LONG).show();
        }
    }
}