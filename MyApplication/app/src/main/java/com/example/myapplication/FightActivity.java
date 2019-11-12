package com.example.myapplication;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.orm.SugarContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FightActivity extends AppCompatActivity {

    //    private GifImageView gifOwn;
    //    private GifImageView gifOpponent;
    private Button move1Btn;
    private Button move2Btn;
    private Button move3Btn;
    private Button move4Btn;
    private Button changePokemonBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_fight);

        move1Btn = findViewById(R.id.move1Btn);
        move2Btn = findViewById(R.id.move2Btn);
        move3Btn = findViewById(R.id.move3Btn);
        move4Btn = findViewById(R.id.move4Btn);
        changePokemonBtn = findViewById(R.id.changePokemonBtn);


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


//        gifOwn = (GifImageView) findViewById(R.id.gifOwn);
//        gifOpponent = (GifImageView) findViewById(R.id.gifOpponent);
//        gifOwn.setImageResource(R.drawable.charizard);
//        gifOpponent.setImageResource(R.drawable.charizard);

        SugarContext.init(this);
    }

  /*  public List<GifImageView> loadGifs() {

        List<GifImageView> gifs = new ArrayList<>();
        File file = new File("./res/drawable-v24/charizard.gif");

        GifImageView gif1 = R.id.gifOwn;


        return 0;
    }
*/

    public void vibrate(Button button) {

        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final long[] pattern = {0, 200}; // sleep for 2000 milliseconds and vibrate for 1000 milliseconds

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vibrator != null) {
                    vibrator.vibrate(pattern, -1); // 0 means repeat forever, -1 not repeat
                    System.err.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA IS VIBRATING");
                }
                System.err.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA IS NOT VIBRATING");
            }
        });
    }

}
