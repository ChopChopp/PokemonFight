package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.beans.Pokemon;

import java.util.List;

public class ChoosePokemon extends AppCompatActivity {

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

    }
}
