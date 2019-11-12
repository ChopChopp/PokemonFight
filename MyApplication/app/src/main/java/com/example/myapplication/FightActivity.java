package com.example.myapplication;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.orm.SugarContext;


public class FightActivity extends AppCompatActivity {

    private Button move1Btn;
    private Button move2Btn;
    private Button move3Btn;
    private Button move4Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_fight);

        move1Btn = findViewById(R.id.move1Btn);
        move2Btn = findViewById(R.id.move2Btn);
        move3Btn = findViewById(R.id.move3Btn);
        move4Btn = findViewById(R.id.move4Btn);

        move1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrate(move1Btn);
            }
        });
        move2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrate(move2Btn);
            }
        });
        move3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrate(move3Btn);
            }
        });
        move4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrate(move4Btn);
            }
        });

        SugarContext.init(this);
    }


    public void vibrate(Button button) {

        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final long[] pattern = {0, 200}; // sleep for 2000 milliseconds and vibrate for 1000 milliseconds

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vibrator != null) {
                    vibrator.vibrate(pattern, -1); // 0 means repeat forever, -1 not repeat
                }
            }
        });
    }
}
