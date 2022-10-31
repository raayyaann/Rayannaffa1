package com.example.rayannaffa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etMail, etpassword;
    private Button btnRegister, btnCancel;
    private TextView Createanewaccount;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etMail = findViewById(R.id.editTextEmailAddress);
        etpassword = findViewById(R.id.editTextPassword);
        btnRegister =findViewById(R.id.buttonRegister);
        btnCancel = findViewById(R.id.buttonCancel);

        preferences = getSharedPreferences("userinfo",0);

    }

    public void register(View view) {
        String input_mail = etMail.getText().toString();
        String input_password = etpassword.getText().toString();
        if (input_mail.length()>0) {
            // open preferences file
            SharedPreferences.Editor editor = preferences.edit();
            //save key , value data
            editor.putString("username", input_mail);
            editor.putString("password", input_password);

            editor.apply();
            Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show();
            Intent intent_main = new Intent(this,MainActivity.class);
            startActivity(intent_main);
        }else {
            Toast.makeText(this,"Empty Values,Please Insert",Toast.LENGTH_SHORT).show();
        }
    }
    public void signIn(View view){
        Intent intent_main = new Intent(this,MainActivity.class);
        startActivity(intent_main);
    }
}