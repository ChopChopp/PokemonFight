package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class userName extends AppCompatActivity {

    EditText et;
    Button btn;

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
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecond();
            }

        });
    }

    private void goToSecond() {
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);
    }

}
