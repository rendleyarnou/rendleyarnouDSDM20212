package com.example.basicscomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Arrays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays);

        ListView lista = (ListView) findViewById(R.id.lvEquipes);

        ArrayList<String> equipes = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipes);
        lista.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preencherDados () {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Mercedes");
        dados.add("Ferrari");
        dados.add("McLaren");
        dados.add("Williams");
        dados.add("Lottus");
        dados.add("Red Bull");

        return dados;
    }

    public void goToMainActivity (View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}