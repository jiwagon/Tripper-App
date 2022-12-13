package com.example.tripper_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences sharedPreferences;
    private static final String TAG = "Activity 2";
    private static final int[] ACTION_BUTTONS_IDS = {
            R.id.login_button,
            R.id.Signup_button
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        for (int id : ACTION_BUTTONS_IDS) {
            findViewById(id).setOnClickListener(this);
        }

        sharedPreferences = getSharedPreferences(SignUpActivity.EMAIL_KEY, MODE_PRIVATE);
    }





    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.login_button) {
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), R.string.login_text, Snackbar.LENGTH_SHORT);
            snackbar.show();
            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
            finish();
        } else if (id == R.id.Signup_button) {
            Intent SignUpIntent = new Intent(this, SignUpActivity.class);
            startActivity(SignUpIntent);
        }


        EditText emailEditText = findViewById(R.id.email_editText);
        String email = emailEditText.getText().toString();

        EditText passwordEditText = findViewById(R.id.password_editText);
        String password = passwordEditText.getText().toString();


        String userAllowed = retrieveSavedEmail();
        String correctPassword = retrieveSavedPassword();
        if (email.equals(userAllowed) &&
                password.equals(correctPassword)) {
            Button button = findViewById(R.id.login_button);
            Snackbar.make(button,
                    "Logged In!",
                    Snackbar.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle(R.string.login_error_title);
            d.setMessage(R.string.login_error_message);
            d.setPositiveButton(android.R.string.ok, null);
            d.show();
        }
    }

    private String retrieveSavedEmail() {
        return sharedPreferences.getString(SignUpActivity.EMAIL_KEY, null);
    }

    private String retrieveSavedPassword() {
        return sharedPreferences.getString(SignUpActivity.PASSWORD_KEY, null);
    }


}
