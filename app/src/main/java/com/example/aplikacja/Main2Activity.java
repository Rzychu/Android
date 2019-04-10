package com.example.aplikacja;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.sql.Time;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.icu.text.DisplayContext.LENGTH_SHORT;


public class Main2Activity extends AppCompatActivity {
    private List<Dane> listaDanych = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loadData();

        petla();

        final RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler_vi);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        final MainAdapter adapter = new MainAdapter(listaDanych);
        recycler.setAdapter(adapter);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView date = findViewById(R.id.wypiszDate);
                EditText ilo = findViewById(R.id.Ilosc1);
                EditText ko = findViewById(R.id.Koszt1);
                EditText pole = findViewById(R.id.Km1);


                if (ko.getText().toString().isEmpty() || ilo.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wprowadź poprawne dane", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (pole.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wprowadź poprawne dane", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (pole.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wprowadź ", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Float km1 = Float.valueOf(pole.getText().toString());
                    Float num1 = Float.valueOf(ilo.getText().toString());
                    Float num2 = Float.valueOf(ko.getText().toString());
                    Float sum = num1 * num2;
                    String currentDate = DateFormat.getDateInstance().format(new Date());


                    Dane nowyWpis = new Dane(sum, km1, currentDate, num1, num2 );
                    listaDanych.add(nowyWpis);

                    petla();
                    czas();

                    adapter.notifyDataSetChanged();
                    saveData();
                }
            }

        });

        Button button_reset = findViewById(R.id.button5);
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaDanych.clear();
                saveData();
            }
        });
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Dane>>() {
        }.getType();

        if (json != null) {
            listaDanych = gson.fromJson(json, type);
        }
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listaDanych);
        editor.putString("task list", json);
        editor.apply();
    }

    private void petla() {
        TextView pokazujekoszt = findViewById(R.id.wynikkoszt);
        TextView pokazujedystans = findViewById(R.id.wynikdystans);
        Float calyKoszt = 0.0f;
        Float calyDystans = 0.0f;

        for (Dane danaZListy : listaDanych) {
            calyKoszt = calyKoszt + danaZListy.getKoszt();
            calyDystans = calyDystans + danaZListy.getDystans();
        }
        String str1 = String.format("%.2f", calyKoszt);
        pokazujekoszt.setText(str1);

        String str2 = String.format("%.2f", calyDystans);
        pokazujedystans.setText(str2);
    }

    private void czas() {
        TextView date = findViewById(R.id.wypiszDate);
        String currentDate = DateFormat.getDateInstance().format(new Date());
        if (currentDate == null) {
            date.setText(currentDate);
        }
    }
}