package com.example.reubrojsonweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    RecyclerView recyclerView;
    private TextView mTextViewResult;
    private RequestQueue mQueue;
    String[] id;
    String[] firstName;
    String[] gender;
    String[] mail;
    String[] phoneH;
    String[] phoneO;
    String[] mobile;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);
        mQueue = Volley.newRequestQueue(this);
 //        jsonParse();
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {

        phoneH=new String[10000];
        phoneO=new String[10000];
        mobile=new String[10000];
        firstName=new String[10000];
        id=new String[10000];
        gender=new String[10000];
        mail=new String[10000];

        String url = "https://run.mocky.io/v3/b8b15165-0686-47f3-b55c-340bce926dc4";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                          //  mTextViewResult.setText("");
                            JSONArray jsonArray = response.getJSONArray("users");
                            for ( i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                JSONObject addressObject = employee.getJSONObject("contact");
                                 phoneH[i] = addressObject.getString("home");
                                 phoneO[i] = addressObject.getString("office");
                                 mobile[i] = addressObject.getString("mobile");
                                 firstName[i] = employee.getString("name");
                                 id[i] = employee.getString("id");
                                 gender[i] = employee.getString("gender");
                                 mail[i] = employee.getString("email");

                                mTextViewResult.append(id[i]+", "+firstName[i] + ", " + gender[i] + ", " + mail[i] + ", " + phoneH[i] + ", " + phoneO[i] + "\n\n");
                               // mTextViewResult.append(id+", "+firstName + ", " + gender + ", " + mail + ", " + phoneH + ", " + phoneO + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });



/*
        recyclerView=findViewById(R.id.recycler);




        myAdapter =new MyAdapter(this, id,firstName,gender, mail,phoneH,phoneO,mobile,i);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        */

        mQueue.add(request);
    }

}