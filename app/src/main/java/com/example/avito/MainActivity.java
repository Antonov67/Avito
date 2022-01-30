package com.example.avito;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static RecyclerView listResistors;
    static ResistorAdapter adapter;
    static int n;
    static ArrayList<Resistor> resistorsList;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        EditText countResistors = findViewById(R.id.count_resistors);
        Button createEmtyListButtom = findViewById(R.id.create_list_button);
        //список
       RecyclerView listResistors = findViewById(R.id.list_resisors);
       listResistors.setLayoutManager(new LinearLayoutManager(this));

        context = MainActivity.this;
        createEmtyListButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = Integer.parseInt(countResistors.getText().toString());
                resistorsList = new ArrayList<>();

                for (int i=0;i<n;i++){
                    resistorsList.add(new Resistor(0.0f));
                }
                //Adapter
                ResistorAdapter adapter = new ResistorAdapter(context, resistorsList);
                listResistors.setAdapter(adapter);
            }
        });

        Button calcButton = findViewById(R.id.calc_button);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }
}