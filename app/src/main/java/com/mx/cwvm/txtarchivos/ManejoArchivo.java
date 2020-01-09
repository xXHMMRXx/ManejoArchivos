package com.mx.cwvm.txtarchivos;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ManejoArchivo
{

    private ArrayList <String> data = new ArrayList<String>();

    public ArrayList<String> getData()
    {

        return data;

    }

    public boolean Verificar(Context context, String nomArch)
    {

        String [] files = context.fileList();
        for (String list: files)
        {

            if(list.equals(nomArch))
            {

                return true;

            }
        }

        return false;
    }

    public boolean Grabar(Context context, ArrayList<String> dato, String nomArch)
    {

        try {

            OutputStreamWriter Archivo = new OutputStreamWriter(context.openFileOutput(nomArch, Activity.MODE_PRIVATE));

            for (String st: dato)
            {

                Archivo.write(st+"\n");

            }

            Archivo.flush();
            Archivo.close();


        } catch (Exception e)
        {

            e.printStackTrace();
            return false;

        }

        return true;

    }

    public boolean Mostrar(Context context, String nomArch)
    {

        try {

            InputStreamReader file = new InputStreamReader(context.openFileInput(nomArch));
            BufferedReader br = new BufferedReader(file);
            String st = br.readLine();

            while (st != null)
            {

                data.add(st);
                st = br.readLine();

            }

        }catch (Exception e)
        {

            e.printStackTrace();
            return false;

        }

        return true;

    }

    public void Agregar(String dato, ArrayList<String> data)
    {

        this.data = data;
        this.data.add(dato);

    }

}
