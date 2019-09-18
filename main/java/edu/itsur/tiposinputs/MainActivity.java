package edu.itsur.tiposinputs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner_etiqueta);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.
                createFromResource(
                        this,
                        R.array.spinner_arreglo,
                        android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null){
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClick(View view) {
        boolean checked = ((RadioButton) view) .isChecked();
        switch (view.getId()) {
            case R.id.mujer_radio:
                if (checked){
                    Toast.makeText(this,
                            "Selecciono Mujer",
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.hombre_radio:
                if (checked){
                    Toast.makeText(this,
                            "Selecciono Hombre",
                            Toast.LENGTH_LONG).show();
                }
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerEtiqueta =
                parent.getItemAtPosition(position).toString();

        Toast.makeText(this,
                spinnerEtiqueta, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
