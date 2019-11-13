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

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pokemon);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(intent != null)
            name=bd.getString("user");
        else
            name=null;


        TextView pokemonName1 = findViewById(R.id.pokemonName1);
        TextView pokemonName2 = findViewById(R.id.pokemonName2);
        TextView pokemonName3 = findViewById(R.id.pokemonName3);
        TextView pokemonName4 = findViewById(R.id.pokemonName4);
        TextView username = findViewById(R.id.user);

        final List<Pokemon> pkmnlist = Pokemon.listAll(Pokemon.class);

        pokemonName1.setText(pkmnlist.get(0).getName());
        pokemonName2.setText(pkmnlist.get(1).getName());
        pokemonName3.setText(pkmnlist.get(2).getName());
        pokemonName4.setText(pkmnlist.get(3).getName());
        username.setText(name);

        ConstraintLayout cl1 = findViewById(R.id.charizardLayout);
        ConstraintLayout cl2 = findViewById(R.id.greninjaLayout);
        ConstraintLayout cl3 = findViewById(R.id.sceptileLayout);
        ConstraintLayout cl4 = findViewById(R.id.luxrayLayout);

        cl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting(pkmnlist.get(0).getName());
            }   
        });
        cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting( pkmnlist.get(1).getName());
            }
        });
        cl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting( pkmnlist.get(2).getName());
            }
        });
        cl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToFighting(pkmnlist.get(3).getName());
            }
        });
    }

    public void goToFighting(String name) {
        Intent intent = new Intent(this, FightActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
