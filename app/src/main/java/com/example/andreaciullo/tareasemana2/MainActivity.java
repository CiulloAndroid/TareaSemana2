package com.example.andreaciullo.tareasemana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.text.format.DateFormat;

public class MainActivity extends AppCompatActivity {

    DatePicker dtFechaNac;
    EditText etNombreCompleto;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcion;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dtFechaNac= (DatePicker) findViewById(R.id.dtFechaNac);
        etNombreCompleto= (EditText) findViewById(R.id.etNombreCompleto);
        etTelefono= (EditText) findViewById(R.id.etTelefono);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etDescripcion= (EditText) findViewById(R.id.etDescripcion);
        btnSiguiente= (Button) findViewById(R.id.btnSiguiente);




        Bundle parametros= getIntent().getExtras();
        if (!(parametros== null))
        {
            String nombre= parametros.getString(getResources().getString(R.string.tituloNombreCompleto));
            String tel= parametros.getString(getResources().getString(R.string.tituloTel));
            String email= parametros.getString(getResources().getString(R.string.tituloEmail));
            String descripcion= parametros.getString(getResources().getString(R.string.tituloDescripcion));
            String fechanac= parametros.getString(getResources().getString(R.string.tituloFechaNac));

            etNombreCompleto.setText(nombre);
            etTelefono.setText(tel);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);


            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            Date mfecha;



            try {

                mfecha = formatoDelTexto.parse(fechanac);

                String dayOfTheWeek = (String) DateFormat.format("EEEE", mfecha); // Thursday
                String day          = (String) DateFormat.format("dd",   mfecha); // 20
                String monthString  = (String) DateFormat.format("MMM",  mfecha); // Jun
                String monthNumber  = (String) DateFormat.format("MM",   mfecha); // 06
                String year         = (String) DateFormat.format("yyyy", mfecha); // 2013

                int dia= Integer.parseInt(day);
                int mes= Integer.parseInt(monthNumber);
                int año  = Integer.parseInt(year);

                // set selected date into datepicker also
                  dtFechaNac.init(año, mes,  dia, null);

            } catch (ParseException ex) {

                ex.printStackTrace();

            }

           /* int dia= Integer.parseInt(day);
            int mes= Integer.parseInt(fechanac.substring(2,4));
            int año  = Integer.parseInt(fechanac.substring(5,9));*/

            // set selected date into datepicker also
//            dtFechaNac.init(año, mes,  dia, null);


        }



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int dia= dtFechaNac.getDayOfMonth();
               int mes= dtFechaNac.getMonth();
               int año  = dtFechaNac.getYear();
                mes= mes+1;
               // String sDia= getString(dia);
               // String sMes=getString(mes);
               // String sAño=getString(año) ;
                StringBuilder fecha; //= getString(dia) + '/' + getString(mes) + '/' + getString(año) ;
// set selected date into textview


              // if (sDia.length()== 1)
              //  {
              //      sDia= "0" + sDia;
              //  }
             //   if (sMes.length()== 1)
              //  {
               //     sMes= "0" + sMes;
              //  }

                fecha=(new StringBuilder().append(dia)
                        .append("/").append(mes).append("/").append(año)
                        .append(""));
                //DateFormat df = new SimpleDateFormat("dd/MM/yy");
                //String sfecha= df.format(fecha);
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(getResources().getString(R.string.tituloTel),etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloNombreCompleto),etNombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloEmail),etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloDescripcion),etDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.tituloFechaNac),fecha.toString());
                startActivity(intent);
            }
        });



    }
}
