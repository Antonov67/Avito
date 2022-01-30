package com.example.avito;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  //  static RecyclerView listResistors;
  //  static ResistorAdapter adapter;
    static int n;
    static ArrayList<Resistor> resistorsList;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getSupportActionBar().hide();
      //  EditText countResistors = findViewById(R.id.count_resistors);
      //  Button createEmtyListButtom = findViewById(R.id.create_list_button);
        //список
       RecyclerView listResistors = findViewById(R.id.list_resisors);
       listResistors.setLayoutManager(new LinearLayoutManager(this));

     //   context = MainActivity.this;
        n = 5;
    //    n = Integer.parseInt(countResistors.getText().toString());
        resistorsList = new ArrayList<>();

        for (int i=0;i<n;i++){
            resistorsList.add(new Resistor((float) i));
        }
        Log.d("Di", n+"");
        Log.d("Di", resistorsList.get(1).resistance+"");
        Log.d("Di", resistorsList.get(2).resistance+"");
        Log.d("Di", resistorsList.size() + "");
        //Adapter
       ResistorAdapter adapter = new ResistorAdapter(this, resistorsList);
        Log.d("Di", "adapter");
        listResistors.setAdapter(adapter);
        Log.d("Di", "list");





    }
}