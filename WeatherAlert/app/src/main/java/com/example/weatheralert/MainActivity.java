package com.example.weatheralert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtxt;
    Button btnpsq;
    TextView txtDados;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpsq = findViewById(R.id.btnpesquisar);
        edtxt = findViewById(R.id.edText);
        txtDados = findViewById(R.id.txtdados);


//        btnpsq.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    public void get(View v) {

        String apikey = "2149d54fcd11c00b1e2128c705bc55c5";
        String city = edtxt.getText().toString();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=+" + city + "+&appid=2149d54fcd11c00b1e2128c705bc55c5";

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String temperature = object.getString("temp");
                    Double temp = Double.parseDouble(temperature)-273.15;

                    txtDados.setText("Temperatura em "+city+" = "+temp.toString().substring(0,5)+"°c");

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Digite uma cidade válida", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }

}


//                city city = new city();
//                city.execute("https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=YOUR_API_KEY");
//        private class city extends AsyncTask<String, String, String> {
//
//            @Override
//            protected String doInBackground(String... strings) {
//                String retorno;
//                retorno = Conn.getDados(strings[0]);
//                return retorno;
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                txtCity.setText(s);
//            }
//        }


//        RequestQueue queue = Volley.newRequestQueue(this);
//
//        StringRequest request = new StringRequest(
//                Request.Method.GET,
//                "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=YOUR_API_KEY", //URL da API
//                new Response.Listener<String>() {  //Tratar as respostas bem, sucedidas
//                    @Override
//                    public void onResponse(String response) { //Processar as respostas da API
//                        try {
////                            cria um objeto JSON a partir da resposta da API
//                            JSONObject json = new JSONObject(response);
//
//                            String city = json.getString("name");
//                            String temperature = json.getJSONObject("main").getString("temp");
//
//                        } catch (JSONException e) {
//                            Toast.makeText(MainActivity.this, "Error on response", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() { //tratador de erro
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//        );
//
//        queue.add(request);
