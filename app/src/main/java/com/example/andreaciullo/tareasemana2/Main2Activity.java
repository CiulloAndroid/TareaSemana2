package com.example.andreaciullo.tareasemana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvNombreCompleto;
    TextView tvTelCon;
    TextView tvEmailCon;
    TextView tvDescripcionCon;
    TextView tvFechaNacCon;
    Button btnEditarDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNombreCompleto= (TextView) findViewById(R.id.tvNombreCompleto);
        tvTelCon=         (TextView) findViewById(R.id.tvTelCont);
        tvEmailCon=       (TextView) findViewById(R.id.tvEmailCont);
        tvDescripcionCon= (TextView) findViewById(R.id.tvDescripcionCont);
        tvFechaNacCon=    (TextView) findViewById(R.id.tvFechNacCont);
        btnEditarDatos=    (Button)  findViewById(R.id.btnEditarDatos);

        Bundle parametros= getIntent().getExtras();
        String nombre= parametros.getString(getResources().getString(R.string.tituloNombreCompleto));
        String tel= parametros.getString(getResources().getString(R.string.tituloTel));
        String email= parametros.getString(getResources().getString(R.string.tituloEmail));
        String descripcion= parametros.getString(getResources().getString(R.string.tituloDescripcion));
        String fechanac= parametros.getString(getResources().getString(R.string.tituloFechaNac));
        tvNombreCompleto.setText(nombre);
        tvTelCon.setText(tel);
        tvEmailCon.setText(email);
        tvDescripcionCon.setText(descripcion);
        tvFechaNacCon.setText(fechanac);


        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.tituloNombreCompleto),tvNombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloTel),tvTelCon.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloEmail),tvEmailCon.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloDescripcion),tvDescripcionCon.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloFechaNac),tvFechaNacCon.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}
