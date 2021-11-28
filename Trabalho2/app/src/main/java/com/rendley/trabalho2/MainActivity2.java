package com.rendley.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rendley.trabalho2.model.Person;

public class MainActivity2 extends AppCompatActivity {

    EditText etId;
    EditText etName;
    EditText etCpf;
    EditText etEmail;
    TextView tvInfo;
    Button btnAction;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etId = findViewById(R.id.etIdMainActivity2);
        etId.setEnabled(false);
        etName = findViewById(R.id.etNameMainActivity2);
        etCpf = findViewById(R.id.etCpfMainActivity2);
        etEmail = findViewById(R.id.etEmailMainActivity2);
        tvInfo = findViewById(R.id.tvInfo);
        btnAction = findViewById(R.id.btnAction);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        String action = (String) intent.getSerializableExtra("action");
        if(action.equals("edit")) {
            Person person = (Person) intent.getSerializableExtra("person");
            etId.setText(person.getId());
            etName.setText(person.getNome());
            etCpf.setText(person.getCpf());
            etEmail.setText(person.getEmail());
            tvInfo.setText(R.string.tvInfoEdit);
            btnAction.setText(R.string.btnActionEdit);
            setEditButton();
        } else {
            int id = (int) intent.getSerializableExtra("id");
            etId.setText(String.valueOf(id));
            tvInfo.setText(R.string.tvInfoAdd);
            btnAction.setText(R.string.btnActionAdd);
            setAddButton();
        }

        btnCancel.setOnClickListener(v -> {
            Intent intentCancel = new Intent(this, MainActivity.class);
            intentCancel.putExtra("action", action);
            setResult(Activity.RESULT_CANCELED, intentCancel);
            finish();
        });


    }

    private void setEditButton() {
        btnAction.setOnClickListener(v -> {
            String id = etId.getText().toString();
            String name = etName.getText().toString();
            String cpf = etCpf.getText().toString();
            String email = etEmail.getText().toString();
            if(name.isEmpty() || cpf.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Todos os campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();
                return;
            }
            Person person = new Person(id, name, cpf, email);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("action", "edit");
            intent.putExtra("person", person);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }

    private void setAddButton() {
        btnAction.setOnClickListener(v -> {
            String id = etId.getText().toString();
            String name = etName.getText().toString();
            String cpf = etCpf.getText().toString();
            String email = etEmail.getText().toString();
            if(name.isEmpty() || cpf.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
                return;
            }
            Person person = new Person(id, name, cpf, email);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("action", "add");
            intent.putExtra("person", person);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}