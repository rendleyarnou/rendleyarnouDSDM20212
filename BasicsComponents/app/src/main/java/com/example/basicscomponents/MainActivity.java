package com.example.basicscomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToToggleButton (View view) {
        Intent intent = new Intent(getApplicationContext(), ToggleButton.class);
        startActivity(intent);
    }

    public void goToEditText (View view) {
        Intent intent = new Intent(getApplicationContext(), EditText.class);
        startActivity(intent);
    }

    public void goToArrays (View view) {
        Intent intent = new Intent(getApplicationContext(), Arrays.class);
        startActivity(intent);
    }

    public void goToAutocomplete (View view) {
        Intent intent = new Intent(getApplicationContext(), Autocomplete.class);
        startActivity(intent);
    }

    public void goToBackgroundImg (View view) {
        Intent intent = new Intent(getApplicationContext(), BackgroundIMG.class);
        startActivity(intent);
    }

    public void goToSpinner (View view) {
        Intent intent = new Intent(getApplicationContext(), SpinnerScreen.class);
        startActivity(intent);
    }

    public void goToRadioButtons (View view) {
        Intent intent = new Intent(getApplicationContext(), RadioButtons.class);
        startActivity(intent);
    }

    public void goToOptionsMenu (View view) {
        Intent intent = new Intent(getApplicationContext(), OptionsMenu.class);
        startActivity(intent);
    }

    public void goToGridView (View view) {
        Intent intent = new Intent(getApplicationContext(), GridView.class);
        startActivity(intent);
    }
}