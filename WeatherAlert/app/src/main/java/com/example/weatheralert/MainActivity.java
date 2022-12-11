package com.example.weatheralert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(
                Request.Method.GET,
                "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=YOUR_API_KEY", //URL da API
                new Response.Listener<String>() {  //Tratar as respostas bem, sucedidas
                    @Override
                    public void onResponse(String response) { //Processar as respostas da API
                        try {
//                            cria um objeto JSON a partir da resposta da API
                            JSONObject json = new JSONObject(response);

                            String city = json.getString("name");
                            String temperature = json.getJSONObject("main").getString("temp");

                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "Error on response", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() { //tratador de erro
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        queue.add(request);

    }
}