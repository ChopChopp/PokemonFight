package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beans.Move;
import com.example.beans.Pokemon;
import com.orm.SugarContext;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;


public class FightActivity extends AppCompatActivity {

    private Button move1Btn;
    private Button move2Btn;
    private Button move3Btn;
    private Button move4Btn;
    private Button switchPkmn;
    private ImageButton musicToggle;
    private GifImageView ownGif;
    private GifImageView ownGif2;
    private GifImageView ownGif3;
    private GifImageView ownGif4;
    private GifImageView attackGifCharizard;
    private GifImageView attackGifGreninja;
    private GifImageView attackGifSceptile;
    private GifImageView attackGifLuxray;
    private TextView ownName;
    private ProgressBar healthOwn;
    private ProgressBar healthOpponent;
    static private boolean hpBarSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_fight);

        SugarContext.init(this);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        final String name = bd.getString("name");

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.battlemusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        final int[] currentMusicPosition = new int[1];
        final List<Pokemon> pkmnlist = Pokemon.listAll(Pokemon.class);

        ownGif = findViewById(R.id.gifOwn);
        ownGif2 = findViewById(R.id.gifOwn2);
        ownGif3 = findViewById(R.id.gifOwn3);
        ownGif4 = findViewById(R.id.gifOwn4);
        ownName = findViewById(R.id.pokemonNameOwn);
        attackGifCharizard = findViewById(R.id.gifAttackCharizard);
        attackGifGreninja = findViewById(R.id.gifAttackGreninja);
        attackGifSceptile = findViewById(R.id.gifAttackSceptile);
        attackGifLuxray = findViewById(R.id.gifAttackLuxray);
        healthOwn = findViewById(R.id.hpBarOwn);
        healthOpponent = findViewById(R.id.hpBarOpponent);
        setHp(name, pkmnlist);

        move1Btn = findViewById(R.id.move1Btn);
        move2Btn = findViewById(R.id.move2Btn);
        move3Btn = findViewById(R.id.move3Btn);
        move4Btn = findViewById(R.id.move4Btn);

        switchPkmn = findViewById(R.id.changePokemonBtn);

        for (Pokemon p : pkmnlist) {
            System.out.println(p.getMove1().getName());
            System.out.println(p.getId());
        }

        if (name.equals("Charizard")) {
            ownGif.setVisibility(View.VISIBLE);
            ownName.setText(pkmnlist.get(0).getName());
            move1Btn.setText(pkmnlist.get(0).getMove1().getName());
            move2Btn.setText(pkmnlist.get(0).getMove2().getName());
            move3Btn.setText(pkmnlist.get(0).getMove3().getName());
            move4Btn.setText(pkmnlist.get(0).getMove4().getName());
        } else if (name.equals("Greninja")) {
            ownGif2.setVisibility(View.VISIBLE);
            ownName.setText(pkmnlist.get(1).getName());
            move1Btn.setText(pkmnlist.get(1).getMove1().getName());
            move2Btn.setText(pkmnlist.get(1).getMove2().getName());
            move3Btn.setText(pkmnlist.get(1).getMove3().getName());
            move4Btn.setText(pkmnlist.get(1).getMove4().getName());
        } else if (name.equals("Sceptile")) {
            ownGif3.setVisibility(View.VISIBLE);
            ownName.setText(pkmnlist.get(2).getName());
            move1Btn.setText(pkmnlist.get(2).getMove1().getName());
            move2Btn.setText(pkmnlist.get(2).getMove2().getName());
            move3Btn.setText(pkmnlist.get(2).getMove3().getName());
            move4Btn.setText(pkmnlist.get(2).getMove4().getName());
        } else if (name.equals("Luxray")) {
            ownGif4.setVisibility(View.VISIBLE);
            ownName.setText(pkmnlist.get(3).getName());
            move1Btn.setText(pkmnlist.get(3).getMove1().getName());
            move2Btn.setText(pkmnlist.get(3).getMove2().getName());
            move3Btn.setText(pkmnlist.get(3).getMove3().getName());
            move4Btn.setText(pkmnlist.get(3).getMove4().getName());
        } else
            System.out.println("Why");

        musicToggle = findViewById(R.id.soundToggle);
        musicToggle.setBackgroundResource(R.drawable.ic_lock_ringer_on_alpha);

        move1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attackOpponent(name, view, pkmnlist);
                System.out.println("AHJDSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                vibrate(move1Btn);
            }
        });
        move2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attackOpponent(name, view, pkmnlist);
                vibrate(move2Btn);
            }
        });
        move3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attackOpponent(name, view, pkmnlist);
                vibrate(move3Btn);
            }
        });
        move4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attackOpponent(name, view, pkmnlist);
                vibrate(move4Btn);
                view.clearFocus();
            }
        });

        switchPkmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchPkmn();
            }
        });

        musicToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    musicToggle.setBackgroundResource(R.drawable.ic_lock_ringer_off_alpha);
                    mediaPlayer.pause();
                    currentMusicPosition[0] = mediaPlayer.getCurrentPosition();
                    System.out.println(currentMusicPosition[0]);
                    vibrate(move4Btn);
                } else {
                    musicToggle.setBackgroundResource(R.drawable.ic_lock_ringer_on_alpha);
                    mediaPlayer.seekTo(currentMusicPosition[0]);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    vibrate(move4Btn);
                }
            }
        });

    }

    private void setHp(String name, List<Pokemon> pkmnlist) {
        if (!hpBarSet) {
            switch (name) {
                case "Charizard":
                    healthOwn.setMax(pkmnlist.get(0).getHp());
                    healthOwn.setProgress(pkmnlist.get(0).getHp());
                    break;
                case "Greninja":
                    healthOwn.setMax(pkmnlist.get(1).getHp());
                    healthOwn.setProgress(pkmnlist.get(1).getHp());
                    break;
                case "Sceptile":
                    healthOwn.setMax(pkmnlist.get(2).getHp());
                    healthOwn.setProgress(pkmnlist.get(2).getHp());
                    break;
                case "Luxray":
                    healthOwn.setMax(pkmnlist.get(3).getHp());
                    healthOwn.setProgress(pkmnlist.get(3).getHp());
                    break;
                default:
                    break;
            }
            healthOpponent.setMax(pkmnlist.get(1).getHp());
            healthOpponent.setProgress(pkmnlist.get(1).getHp());
            FightActivity.hpBarSet = true;
        }
    }

    private void attackOpponent(String name, View view, List<Pokemon> pkmnlist) {
        switch (name) {
            case "Charizard":
                switch (view.getId()) {
                    case R.id.move1Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(0).getMove1().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(0).setHp(pkmnlist.get(0).getHp() - pkmnlist.get(1).getMove1().getDamage());
                        healthOwn.setProgress(pkmnlist.get(0).getHp());

                        break;
                    case R.id.move2Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(0).getMove2().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(0).setHp(pkmnlist.get(0).getHp() - pkmnlist.get(1).getMove2().getDamage());
                        healthOwn.setProgress(pkmnlist.get(0).getHp());
                        break;
                    case R.id.move3Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(0).getMove3().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(0).setHp(pkmnlist.get(0).getHp() - pkmnlist.get(1).getMove3().getDamage());
                        healthOwn.setProgress(pkmnlist.get(0).getHp());
                        break;
                    case R.id.move4Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(0).getMove4().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(0).setHp(pkmnlist.get(0).getHp() - pkmnlist.get(1).getMove4().getDamage());
                        healthOwn.setProgress(pkmnlist.get(0).getHp());
                        break;
                }
                break;
            case "Greninja":
                switch (view.getId()) {
                    case R.id.move1Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove1().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove1().getDamage());
                        healthOwn.setProgress(pkmnlist.get(1).getHp());
                        break;
                    case R.id.move2Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove2().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove2().getDamage());
                        healthOwn.setProgress(pkmnlist.get(1).getHp());
                        break;
                    case R.id.move3Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove3().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove3().getDamage());
                        healthOwn.setProgress(pkmnlist.get(1).getHp());
                        break;
                    case R.id.move4Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove4().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(1).getMove4().getDamage());
                        healthOwn.setProgress(pkmnlist.get(1).getHp());
                        break;
                }
                break;

            case "Sceptile":
                switch (view.getId()) {
                    case R.id.move1Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(2).getMove1().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(2).setHp(pkmnlist.get(2).getHp() - pkmnlist.get(1).getMove1().getDamage());
                        healthOwn.setProgress(pkmnlist.get(2).getHp());
                        break;
                    case R.id.move2Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(2).getMove2().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(2).setHp(pkmnlist.get(2).getHp() - pkmnlist.get(1).getMove2().getDamage());
                        healthOwn.setProgress(pkmnlist.get(2).getHp());
                        break;
                    case R.id.move3Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(2).getMove3().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(2).setHp(pkmnlist.get(2).getHp() - pkmnlist.get(1).getMove3().getDamage());
                        healthOwn.setProgress(pkmnlist.get(2).getHp());
                        break;
                    case R.id.move4Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(2).getMove4().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(2).setHp(pkmnlist.get(2).getHp() - pkmnlist.get(1).getMove4().getDamage());
                        healthOwn.setProgress(pkmnlist.get(2).getHp());
                        break;
                }
                break;

            case "Luxray":
                switch (view.getId()) {
                    case R.id.move1Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(3).getMove1().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(3).setHp(pkmnlist.get(3).getHp() - pkmnlist.get(1).getMove1().getDamage());
                        healthOwn.setProgress(pkmnlist.get(3).getHp());
                        break;
                    case R.id.move2Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(3).getMove2().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(3).setHp(pkmnlist.get(3).getHp() - pkmnlist.get(1).getMove2().getDamage());
                        healthOwn.setProgress(pkmnlist.get(3).getHp());
                        break;
                    case R.id.move3Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(3).getMove3().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(3).setHp(pkmnlist.get(3).getHp() - pkmnlist.get(1).getMove3().getDamage());
                        healthOwn.setProgress(pkmnlist.get(3).getHp());
                        break;
                    case R.id.move4Btn:
                        pkmnlist.get(1).setHp(pkmnlist.get(1).getHp() - pkmnlist.get(3).getMove4().getDamage());
                        healthOpponent.setProgress(pkmnlist.get(1).getHp());
                        pkmnlist.get(3).setHp(pkmnlist.get(3).getHp() - pkmnlist.get(1).getMove4().getDamage());
                        healthOwn.setProgress(pkmnlist.get(3).getHp());
                        break;
                }
                break;

            default:
                break;
        }
    }

    public void switchPkmn() {
        Intent intent = new Intent(this, ChoosePokemon.class);
        startActivity(intent);
    }

    private void changeToAttackGif(String name) {

        Timer timer = new Timer();

//        try {
        switch (name) {
            case "Charizard":
                ownGif.setVisibility(View.INVISIBLE);
                attackGifCharizard.setVisibility(View.VISIBLE);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("hello");
                    }
                }, 1000, 1000);
                ownGif.setVisibility(View.VISIBLE);
                attackGifCharizard.setVisibility(View.INVISIBLE);
                break;
            case "Greninja":
                ownGif2.setVisibility(View.INVISIBLE);
                attackGifGreninja.setVisibility(View.VISIBLE);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("hello");
                    }
                }, 1000, 1000);
                ownGif2.setVisibility(View.VISIBLE);
                attackGifGreninja.setVisibility(View.INVISIBLE);
                break;
            case "Sceptile":
                ownGif3.setVisibility(View.INVISIBLE);
                attackGifSceptile.setVisibility(View.VISIBLE);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("hello");
                    }
                }, 1000, 1000);
                ownGif3.setVisibility(View.VISIBLE);
                attackGifSceptile.setVisibility(View.INVISIBLE);
                break;
            case "Luxray":
                ownGif4.setVisibility(View.INVISIBLE);
                attackGifLuxray.setVisibility(View.VISIBLE);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("hello");
                    }
                }, 1000, 1000);
                ownGif4.setVisibility(View.VISIBLE);
                attackGifLuxray.setVisibility(View.INVISIBLE);
                break;
            default:
                System.out.println("EEEEEEEEEEEXIT");
        }
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void vibrate(Button button) {

        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final long[] pattern = {0, 200}; // sleep for 0 milliseconds and vibrate for 200 milliseconds

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
