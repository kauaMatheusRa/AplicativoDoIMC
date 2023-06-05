package devandroid.kauamatheus.appimc.view;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    Pessoa novaPessoa;

    EditText inputAltura;
    EditText inputPeso;

    Button btnCalcularImc;

    TextView resultadoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        novaPessoa = new Pessoa();
        controller.buscar(novaPessoa);


        inputAltura = findViewById(R.id.editTextAltura);
        inputPeso = findViewById(R.id.editTextPeso);

        btnCalcularImc = findViewById(R.id.button_calcular);
        resultadoImc = findViewById(R.id.textView);

        btnCalcularImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularImc();
                novaPessoa.setPeso(Float.parseFloat(inputPeso.getText().toString()));
                novaPessoa.setAltura(Float.parseFloat(inputAltura.getText().toString()));
                controller.salvar(novaPessoa);
            }
        });

    }

    private void calcularImc(){

        float alturaValue;
        float pesoValue;
        double calculoImc;
        String calculoImcFormated;

        try{
            alturaValue = Float.parseFloat(inputAltura.getText().toString());
            pesoValue = Float.parseFloat(inputPeso.getText().toString());

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