package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UserName extends AppCompatActivity {

    EditText et;
    Button btn;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        et = (EditText) findViewById(R.id.userNameInput);
        btn  = (Button)findViewById(R.id.continueTeam);

        et.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btn.setEnabled(false);
            }

            public void afterTextChanged(Editable s) {
                btn.setEnabled(true);
                username = s.toString();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecond(username);
            }

        });
    }

    private void goToSecond(String user) {
        Intent intent = new Intent(this, ChoosePokemon.class);
        intent.putExtra("user", user);
        startActivity(intent);
        System.out.println(username);
    }

}
