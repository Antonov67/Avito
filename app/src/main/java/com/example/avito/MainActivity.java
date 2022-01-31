package com.example.avito;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static RecyclerView listResistors;
    static ResistorAdapter adapter;
    static int n;
    static ArrayList<Resistor> resistorsList;
    static Context context;
    static float summa=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        EditText countResistors = findViewById(R.id.count_resistors);
        TextView resultText = findViewById(R.id.result_text);
        Button createEmtyListButtom = findViewById(R.id.create_list_button);
        //список
       listResistors = findViewById(R.id.list_resisors);
       listResistors.setLayoutManager(new LinearLayoutManager(this));


        context = MainActivity.this;
        createEmtyListButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = Integer.parseInt(countResistors.getText().toString());
                resistorsList = new ArrayList<>();

                for (int i=0;i<n;i++){
                    resistorsList.add(new Resistor(0.0f, "резистор №" + (i+1)));
                }
                //Adapter
                adapter = new ResistorAdapter(context, resistorsList);
                listResistors.setAdapter(adapter);

            }
        });

        Button calcButton = findViewById(R.id.calc_button);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setText(calc(adapter.getResistorList()) + "");
                //обновим список
                adapter = new ResistorAdapter(context, adapter.getResistorList());
                listResistors.setAdapter(adapter);
            }
        });
    }
    public float calc(List<Resistor> list){
        summa = 0;

        //примерный подсчет, обычная сумма всех сопротивлений
        for (Resistor resistor: list
             ) {
            summa+=resistor.resistance;
        }
        return summa;
    }
}