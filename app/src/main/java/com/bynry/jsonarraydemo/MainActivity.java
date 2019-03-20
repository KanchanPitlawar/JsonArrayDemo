package com.bynry.jsonarraydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public final static String json_array = "{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\"," +
            "\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";

    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txt_name);
        String data = " ";
        try {
            JSONObject object = new JSONObject(json_array);
            JSONArray jsonArray = object.optJSONArray("Employee");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                Float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Node " + i + " : \n id= " + id + " \n Name= " + name + " \n Salary= " + salary + " \n ";
                txtName.setText(data);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
