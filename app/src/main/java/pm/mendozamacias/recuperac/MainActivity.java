package pm.mendozamacias.recuperac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements Response.ErrorListener, Response.Listener<JSONArray> {

    RecyclerView rvCats;
    ArrayList<Cats> listCats;
    RequestQueue request;
    JsonArrayRequest jsonArrayRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCats = findViewById(R.id.recyclerCats);
        listCats =new ArrayList<>();

        rvCats.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvCats.setHasFixedSize(true);

        request = Volley.newRequestQueue(getApplicationContext());

        cargar();
    }

    private void cargar() {
        String url = "https://cataas.com/api/cats";
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonArrayRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("json", error.getMessage());

    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for (int i = 0; i<response.length(); i++){
                Cats cats = new Cats();
                JSONObject jsonObject = response.getJSONObject(i);
                cats.setId(jsonObject.getString("id"));
                cats.setTags(jsonObject.getString("tags"));

                listCats.add(cats);
            }
            Adaptador adaptadorCats = new Adaptador(listCats);
            rvCats.setAdapter(adaptadorCats);


        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "No se pudo cargar", Toast.LENGTH_SHORT).show();
        }
    }
}