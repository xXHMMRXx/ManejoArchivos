
package com.mx.cwvm.txtarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    TextView contenido;

    private final String nomArch = "xXHMMRXx-data.txt";
    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.Name);
        contenido = findViewById(R.id.contenido);

        Buscar();

    }

    public void Recargar(View v)
    {

        ManejoArchivo manArch = new ManejoArchivo();

        manArch.Agregar(nombre.getText().toString(), data);

        if(manArch.Grabar(this, data, nomArch))
        {

            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            data = manArch.getData();

        }else
        {

            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }

    }

    public void Actualizar(View v)
    {

        Buscar();

    }

    public void Buscar()
    {

        ManejoArchivo manArch = new ManejoArchivo();

        if(manArch.Verificar(this, nomArch))
        {

            Toast.makeText(this, "The file already exists", Toast.LENGTH_LONG).show();

            if(manArch.Mostrar(this, nomArch))
            {

                data = manArch.getData();
                String tmp = "";

                for(String st : data)
                {

                    tmp += "\n"+st;
                    contenido.setText(tmp);

                }


            }

        }else
        {

            Toast.makeText(this, "The file does not exists", Toast.LENGTH_LONG).show();

        }

    }

}
