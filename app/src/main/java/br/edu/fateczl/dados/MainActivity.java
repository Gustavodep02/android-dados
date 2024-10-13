package br.edu.fateczl.dados;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {

    private RadioButton rbd4, rbd6, rbd8, rbd10, rbd12, rbd20, rbd100;
    private TextView tvSaida;
    private Button btnSortear;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rbd4 = findViewById(R.id.rbD4);
        rbd4.setChecked(true);
        rbd6 = findViewById(R.id.rbD6);
        rbd8 = findViewById(R.id.rbD8);
        rbd10 = findViewById(R.id.rbD10);
        rbd12 = findViewById(R.id.rbD12);
        rbd20 = findViewById(R.id.rbD20);
        rbd100 = findViewById(R.id.rbD100);
        spinner = findViewById(R.id.spQTD);
        preencheSpinner();
        tvSaida = findViewById(R.id.tvSaida);
        btnSortear = findViewById(R.id.btnSortear);

        btnSortear.setOnClickListener(op -> sortear());
    }
    private void sortear() {
        int qtd = (int) spinner.getSelectedItem();
        int dado = 0;
        if (rbd4.isChecked()) {
            dado = 4;
        } else if (rbd6.isChecked()) {
            dado = 6;
        } else if (rbd8.isChecked()) {
            dado = 8;
        } else if (rbd10.isChecked()) {
            dado = 10;
        } else if (rbd12.isChecked()) {
            dado = 12;
        } else if (rbd20.isChecked()) {
            dado = 20;
        } else if (rbd100.isChecked()) {
            dado = 100;
        }
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < qtd; i++) {
            int valor = (int) (Math.random() * dado) + 1;
            buffer.append(valor);
            if (i < qtd - 1) {
                buffer.append(", ");
            }
            tvSaida.setText(String.valueOf(buffer));
        }
    }
    private void preencheSpinner(){
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}