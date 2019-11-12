package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import pl.droidsonroids.gif.GifImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.orm.SugarContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FightActivity extends AppCompatActivity {

    private Button btn;
    private GifImageView gifOwn;
    private GifImageView gifOpponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_fight);

        gifOwn = (GifImageView) findViewById(R.id.gifOwn);
        gifOpponent = (GifImageView) findViewById(R.id.gifOpponent);
        gifOwn.setImageResource(R.drawable.charizard);
        gifOpponent.setImageResource(R.drawable.charizard);

        SugarContext.init(this);
    }

  /*  public List<GifImageView> loadGifs() {

        List<GifImageView> gifs = new ArrayList<>();
        File file = new File("./res/drawable-v24/charizard.gif");

        GifImageView gif1 = R.id.gifOwn;


        return 0;
    }
*/

}
