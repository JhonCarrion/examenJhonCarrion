package com.cooperativa.alex.consultalugardevotacin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class RecintoActivity extends AppCompatActivity {

    private TextView txtNombre, txtDireccion, txtProvincia, txtCanton, txtParroquia, txtZona, txtnrojuntasM, txtnrojuntasF;
    private Button btnCancelar, btnGuardar;

    String url = "http://10.20.13.30:3000/institucion/create";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recinto);
        init();
    }

    private void init() {
        txtNombre = findViewById(R.id.txt_recinto_nombre);
        txtDireccion = findViewById(R.id.txt_recinto_direccion);
        txtProvincia = findViewById(R.id.txt_recinto_provincia);
        txtCanton = findViewById(R.id.txt_recinto_canton);
        txtParroquia = findViewById(R.id.txt_recinto_parroquia);
        txtZona = findViewById(R.id.txt_recinto_zona);
        txtnrojuntasM = findViewById(R.id.txt_recinto_nro_juntasm);
        txtnrojuntasF = findViewById(R.id.txt_recinto_nro_juntasf);

        btnCancelar = findViewById(R.id.btn_recinto_cancelar);
        btnGuardar = findViewById(R.id.btn_recinto_guardar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                Map params = new HashMap();
                params.put("nombre", txtNombre.getText().toString());
                params.put("direccion", txtDireccion.getText().toString());
                params.put("provincia", txtProvincia.getText().toString());
                params.put("canton", txtCanton.getText().toString());
                params.put("parroquia", txtParroquia.getText().toString());
                params.put("zona", txtZona.getText().toString());
                params.put("juntasm", txtnrojuntasM.getText().toString());
                params.put("juntasf", txtnrojuntasF.getText().toString());


            }

        });
    }

    private void registerUser() {
        final String nombre = txtNombre.getText().toString();
        final String direccion = txtDireccion.getText().toString();
        final String provincia = txtProvincia.getText().toString();
        final String canton = txtCanton.getText().toString();
        final String parroquia = txtParroquia.getText().toString();
        final String zona = txtZona.getText().toString();
        final String juntasm = txtnrojuntasM.getText().toString();
        final String juntasf = txtnrojuntasF.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nombre", txtNombre.getText().toString());
                params.put("direccion", txtDireccion.getText().toString());
                params.put("provincia", txtProvincia.getText().toString());
                params.put("canton", txtCanton.getText().toString());
                params.put("parroquia", txtParroquia.getText().toString());
                params.put("zona", txtZona.getText().toString());
                params.put("juntasm", txtnrojuntasM.getText().toString());
                params.put("juntasf", txtnrojuntasF.getText().toString());
                return params;
            }
        };

        queue.add(strRequest);
    }
}