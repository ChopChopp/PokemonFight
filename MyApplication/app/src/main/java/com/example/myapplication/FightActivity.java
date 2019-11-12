package com.example.myapplication;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.orm.SugarContext;

import pl.droidsonroids.gif.GifImageView;


public class FightActivity extends AppCompatActivity {

    private Button move1Btn;
    private Button move2Btn;
    private Button move3Btn;
    private Button move4Btn;
    private GifImageView ownGif;
    private GifImageView ownGif2;
    private GifImageView ownGif3;
    private GifImageView ownGif4;

    private Bundle extras = getIntent().getExtras();
    private int id = extras.getInt("id");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_fight);

        ownGif = findViewById(R.id.gifOwn);
        ownGif2 = findViewById(R.id.gifOwn2);
        ownGif3 = findViewById(R.id.gifOwn3);
        ownGif4 = findViewById(R.id.gifOwn4);

        switch (id){
            case 1:
                ownGif2.setVisibility(View.VISIBLE);
                ownGif.setVisibility(View.INVISIBLE);
            case 2:
                ownGif3.setVisibility(View.VISIBLE);
                ownGif.setVisibility(View.INVISIBLE);
            case 3:
                ownGif4.setVisibility(View.VISIBLE);
                ownGif.setVisibility(View.INVISIBLE);
            default:
                ownGif.setVisibility(View.VISIBLE);
        }

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
