package com.example.defapp.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.defapp.R;

import com.example.defapp.global.Constants;

public class LoginActivity extends AppCompatActivity {
    EditText txt_email,txt_password;
    EditText edt_email,edt_password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_email=findViewById(R.id.et_email);
        txt_password=findViewById(R.id.et_password);

        edt_email=findViewById(R.id.et_email);
        edt_password=findViewById(R.id.et_password);
        login=findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(verifyUser()){
                    saveUser();
                    redirectUser();
                }
            }
        });


    }

    private Boolean verifyUser() {

        boolean verif=true;
        String user=txt_email.getText().toString().trim();
        String pwd=txt_password.getText().toString().trim();

        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd) || Patterns.EMAIL_ADDRESS.matcher(user).matches()==false)
        {
            Toast.makeText(getApplicationContext(),"Wrong user data",Toast.LENGTH_LONG).show();
            verif=false;

        }
        return verif;

    }

    private void saveUser() {
        SharedPreferences preferences = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constants.USER_CONNECTED, true);
        editor.apply();
    }


    private void redirectUser() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


}