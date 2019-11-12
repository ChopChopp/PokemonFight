package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beans.Move;
import com.orm.SugarContext;

import java.sql.SQLOutput;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(this);

        Button btn = (Button) findViewById(R.id.fightBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUsername();
            }

        });
    }

    private void goToUsername() {

        List<Move> moves = Move.listAll(Move.class);
        DAO dao = new DAO();

        if(moves.size() == 0){
            dao.createMoves();
            dao.createPokemon();
            System.out.println("Pokemon & Moves where initialized");
        }
        else{
            System.out.println("Moves & Pokemon are already initialized in the database");
        }


       for(Move m: moves) {
           System.out.println(m.getName());
           System.out.println(m.getId());
       }

        Intent intent = new Intent(this, UserName.class);
        startActivity(intent);
    }
}
