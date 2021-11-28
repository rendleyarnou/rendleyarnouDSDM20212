package com.rendley.trabalho2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Toast;

import com.rendley.trabalho2.model.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button editButton;
    Button addButton;
    EditText etId;

    PersonAdapter personAdapter;

    int nextId = 2;

    ArrayList<Person> people = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListViewAdapter();
        setEditButton();
        setAddButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        etId.setText("");
        etId.clearFocus();
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    String action = (String) intent.getSerializableExtra("action");
                    Person person = (Person) intent.getSerializableExtra("person");
                    if(action != null && action.equals("edit")){
                        Person bookFromArray = getPersonById(person.getId());
                        bookFromArray.setNome(person.getNome());
                        bookFromArray.setCpf(person.getCpf());
                        bookFromArray.setEmail(person.getEmail());
                    }
                    else if(action != null && action.equals("add")){
                        people.add(person);
                    }
                    personAdapter.notifyDataSetChanged();
                } else if(result.getResultCode() == Activity.RESULT_CANCELED){
                    Intent intent = result.getData();
                    String action = (String) intent.getSerializableExtra("action");
                    if(action != null && action.equals("add")){
                        nextId--;
                    }
                }
            });

    private void setEditButton() {
        editButton = findViewById(R.id.btnEdit);
        etId = findViewById(R.id.etId);
        editButton.setOnClickListener(v -> {
            String idInput = etId.getText().toString();
            if(idInput.isEmpty()){
                Toast.makeText(MainActivity.this, "Insira um ID", Toast.LENGTH_SHORT).show();
                return;
            } else if(!people.isEmpty()) {
                Person person = getPersonById(idInput);
                if(person != null) {
                    Intent intent = new Intent(this, MainActivity2.class);
                    intent.putExtra("person", person);
                    intent.putExtra("action", "edit");
                    activityResultLauncher.launch(intent);
                    return;
                }
            }
            Toast.makeText(MainActivity.this, "ID inexistente", Toast.LENGTH_SHORT).show();
        });
    }

    private void setAddButton() {
        addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("action", "add");
            intent.putExtra("id", getNextId());
            activityResultLauncher.launch(intent);
        });
    }

    private Person getPersonById(String id) {
        for (Person person: people) {
            if(person.getId().equals(id)) return person;
        }
        return null;
    }

    private int getNextId() {
        nextId++;
        return nextId;
    }

    private void setListViewAdapter() {
        personAdapter = new PersonAdapter(this, people);
        listView = findViewById(R.id.lvPeople);
        listView.setAdapter(personAdapter);

        Person person1 = new Person("1", "Márcio", "0004.003.002-01", "marcioespindola@ufc.br");
        Person person2 = new Person("2", "Rendley", "001.002.0003-04", "rendleyarnou@alu.ufc.br");

        people.addAll(Arrays.asList(person1, person2));
    }
}