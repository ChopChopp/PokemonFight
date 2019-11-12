package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.beans.Pokemon;

import java.util.List;

public class ChoosePokemon extends AppCompatActivity {

    boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pokemon);

        TextView pokemonName1 = findViewById(R.id.pokemonName1);
        TextView pokemonName2 = findViewById(R.id.pokemonName2);
        TextView pokemonName3 = findViewById(R.id.pokemonName3);
        TextView pokemonName4 = findViewById(R.id.pokemonName4);

        List<Pokemon> pkmnlist = Pokemon.listAll(Pokemon.class);

        pokemonName1.setText(pkmnlist.get(0).getName());
        pokemonName2.setText(pkmnlist.get(1).getName());
        pokemonName3.setText(pkmnlist.get(2).getName());
        pokemonName4.setText(pkmnlist.get(3).getName());

        ConstraintLayout cl1 = findViewById(R.id.charizardLayout);
        ConstraintLayout cl2 = findViewById(R.id.greninjaLayout);
        ConstraintLayout cl3 = findViewById(R.id.sceptileLayout);
        ConstraintLayout cl4 = findViewById(R.id.luxrayLayout);

        clicked = false;

        cl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting();
            }
        });
        cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting();
            }
        });
        cl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting();
            }
        });
        cl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting();
            }
        });



    }

    public void goToFighting() {
        Intent intent = new Intent(this, FightActivity.class);
        startActivity(intent);
    }
}
