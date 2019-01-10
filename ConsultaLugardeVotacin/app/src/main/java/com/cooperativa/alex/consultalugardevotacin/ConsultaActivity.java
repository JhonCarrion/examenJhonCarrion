package com.cooperativa.alex.consultalugardevotacin;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsultaActivity extends AppCompatActivity {

    private Button btnConsultar, btnCancelar;
    private EditText txtCedula, txtNombres;
    ServicioWeb threadConnection;
    String ruta = "http://localhost:3000/persona/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        init();
    }

    private void init() {
        txtCedula = findViewById(R.id.txt_consulta_cedula);
        txtNombres = findViewById(R.id.txt_consulta_nombres);

        btnCancelar = findViewById(R.id.btn_consulta_cancelar);
        btnConsultar = findViewById(R.id.btn_consulta_consultar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CONSULTAR WS
                ruta += txtCedula.getText().toString();
            }
        });
    }

    public class ServicioWeb extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String cadena = strings[0];
            String devuelve = "sin datos";
            URL url;
            if (strings[1] == "1") {
                try {
                    url = new URL(cadena);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    int codeConnection = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();
                    if (codeConnection == HttpURLConnection.HTTP_OK) {
                        InputStream in = new BufferedInputStream(connection.getInputStream());
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                        //JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
                        //String r = jsonObject.getString("bancos");
                        //JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
                        //String r = "";
                        //for (int i = 0; i < jsonArray.length(); i++) {
                        //    r += jsonArray.getString(i) + "\n";
                        //}
                        return devuelve = bufferedReader.readLine();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return devuelve;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ConsultaActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
