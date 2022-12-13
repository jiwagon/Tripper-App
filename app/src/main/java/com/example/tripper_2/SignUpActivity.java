package com.example.tripper_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EMAIL_KEY = "EMAIL";
    public static final String PASSWORD_KEY = "PASSWORD";
    public static final String FIRST_NAME_KEY = "FIRST_NAME";
    public static final String LAST_NAME_KEY = "LAST_NAME";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button registerButton = findViewById(R.id.createAccount_button);
        registerButton.setOnClickListener(this);
        sharedPreferences = getSharedPreferences(EMAIL_KEY, MODE_PRIVATE);
    }

    /**
     * Returns user entered text from an EditText instance
     * @param id: Id of the EditText instance
     * @return User entered text
     */
    String getInputFromEditText(int id) {
        EditText v = findViewById(id);
        return v.getText().toString();
    }

    /**
     * Registers a new user.
     * It involves two steps: 1) extract user inputs; and 2) save those values.
     */
    void registerUser() {
        String email = getInputFromEditText(R.id.email_editText_signup);
        String lastName = getInputFromEditText(R.id.editTextTextPersonName);
        String firstName = getInputFromEditText(R.id.editTextTextLastName);
        String password = getInputFromEditText(R.id.editTextTextPassword);



        saveUserInformation(email, firstName, lastName,password);
    }

    /**
     * Saves user information using SharedPreferences
     *
     */
    void saveUserInformation( String email, String firstName,
                              String lastName, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL_KEY, email);
        editor.putString(FIRST_NAME_KEY, firstName);
        editor.putString(LAST_NAME_KEY, lastName);
        editor.putString(PASSWORD_KEY, password);

        editor.apply();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.createAccount_button) {
            registerUser();
            Button button = findViewById(R.id.createAccount_button);
            Snackbar.make(button,
                    "Registered!",
                    Snackbar.LENGTH_LONG).show();
            Intent LoginIntent = new Intent(this, LoginActivity.class);
            startActivity(LoginIntent);
        }
    }
}

