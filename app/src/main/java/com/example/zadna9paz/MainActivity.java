package com.example.zadna9paz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
private EditText editTextName; //deklaracja zmiennych do pracy na przyszłych widokach
private EditText editTextSurname;
private EditText editTextEmail;
private EditText editTextPhoneNumber;
private EditText editTextPassword;
private EditText editTextConfirmPassword;
private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phoneNumber = editTextPhoneNumber.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmPassword = editTextConfirmPassword.getText().toString().trim();
                if(name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imie", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                } else if(phoneNumber.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                } else if(phoneNumber.length() < 9){
                    Toast.makeText(MainActivity.this, "Niepoprawny numer telefonu", Toast.LENGTH_SHORT).show();
                } else if(password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić haslo", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6){
                    Toast.makeText(MainActivity.this, "haslo jest za krotkie", Toast.LENGTH_SHORT).show();
                } else if (confirmPassword.isEmpty() || !(confirmPassword.equals(password))) {
                    Toast.makeText(MainActivity.this, "Proszę potwiedzic haslo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz przeslany poprawnie", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}