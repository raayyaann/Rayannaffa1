package com.example.rayannaffa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonregister;
    EditText editTextTextEmailAddress, editTextTextPassword;
    Button buttonlogin;
    SharedPreferences preferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonlogin = findViewById(R.id.buttonlogin);

        preferences = getSharedPreferences("Userinfo",0);
    }

    public void login(View view) {
        if (editTextTextEmailAddress.getText().toString().equals(""))
            Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show();
        else if (editTextTextPassword.getText().toString().equals(""))
            Toast.makeText(this, "Empty Password", Toast.LENGTH_LONG).show();
        else {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
    }
    /*
     this method loads the menu design into this activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // in case user chose Setting menu
        if (item.getItemId() == R.id.setting_menu) {
            //open the setting activity when the about menu item selected
            //this is from where, and the second parameter is to where
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.help_menu) {
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back button was pressed!");
        dialog.setMessage("Are you sure you want to Exit");
        // in case the user No, Nothing Happen , the dialog closes
        dialog.setNegativeButton("No",null);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_whatshot_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
    public void register (View view) {
        Intent i_register = new Intent(this,RegisterActivity.class);
        startActivity(i_register);
    }
    }



