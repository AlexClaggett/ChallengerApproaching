package com.example.challengerapproaching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.challengerapproaching.Characters.Banjo_Kazooie;
import com.example.challengerapproaching.Characters.Bayonetta;
import com.example.challengerapproaching.Characters.Bowser;
import com.example.challengerapproaching.Characters.Bowser_Jr;
import com.example.challengerapproaching.Characters.Bylthe;
import com.example.challengerapproaching.Characters.Captain_Falcon;
import com.example.challengerapproaching.Characters.Charizard;
import com.example.challengerapproaching.Characters.Chrom;
import com.example.challengerapproaching.Characters.Cloud;
import com.example.challengerapproaching.Characters.Corrin;
import com.example.challengerapproaching.Characters.Daisy;
import com.example.challengerapproaching.Characters.Dark_Pit;
import com.example.challengerapproaching.Characters.Dark_Samus;
import com.example.challengerapproaching.Characters.Diddy_Kong;
import com.example.challengerapproaching.Characters.Donkey_Kong;
import com.example.challengerapproaching.Characters.Dr_Mario;
import com.example.challengerapproaching.Characters.Duck_Hunt;
import com.example.challengerapproaching.Characters.Falco;
import com.example.challengerapproaching.Characters.Fox;
import com.example.challengerapproaching.Characters.Ganondorf;
import com.example.challengerapproaching.Characters.Greninja;
import com.example.challengerapproaching.Characters.Hero;
import com.example.challengerapproaching.Characters.Ice_Climbers;
import com.example.challengerapproaching.Characters.Ike;
import com.example.challengerapproaching.Characters.Incineroar;
import com.example.challengerapproaching.Characters.Inkling;
import com.example.challengerapproaching.Characters.Isabelle;
import com.example.challengerapproaching.Characters.Ivysaur;
import com.example.challengerapproaching.Characters.Jigglypuff;
import com.example.challengerapproaching.Characters.Joker;
import com.example.challengerapproaching.Characters.Ken;
import com.example.challengerapproaching.Characters.King_Dedede;
import com.example.challengerapproaching.Characters.King_K_Rool;
import com.example.challengerapproaching.Characters.Kirby;
import com.example.challengerapproaching.Characters.Link;
import com.example.challengerapproaching.Characters.Little_Mac;
import com.example.challengerapproaching.Characters.Lucario;
import com.example.challengerapproaching.Characters.Lucas;
import com.example.challengerapproaching.Characters.Lucina;
import com.example.challengerapproaching.Characters.Luigi;
import com.example.challengerapproaching.Characters.Mario;
import com.example.challengerapproaching.Characters.Marth;
import com.example.challengerapproaching.Characters.Mega_Man;
import com.example.challengerapproaching.Characters.Meta_Knight;
import com.example.challengerapproaching.Characters.Mewtwo;
import com.example.challengerapproaching.Characters.Mii_Brawler;
import com.example.challengerapproaching.Characters.Mii_Gunner;
import com.example.challengerapproaching.Characters.Mii_Swordfighter;
import com.example.challengerapproaching.Characters.Mr_Game_and_Watch;
import com.example.challengerapproaching.Characters.Ness;
import com.example.challengerapproaching.Characters.Olimar;
import com.example.challengerapproaching.Characters.Pac_Man;
import com.example.challengerapproaching.Characters.Palutena;
import com.example.challengerapproaching.Characters.Peach;
import com.example.challengerapproaching.Characters.Pichu;
import com.example.challengerapproaching.Characters.Pikachu;
import com.example.challengerapproaching.Characters.Piranha_Plant;
import com.example.challengerapproaching.Characters.Pit;
import com.example.challengerapproaching.Characters.ROB;
import com.example.challengerapproaching.Characters.Richter;
import com.example.challengerapproaching.Characters.Ridley;
import com.example.challengerapproaching.Characters.Robin;
import com.example.challengerapproaching.Characters.Rosalina_and_Luma;
import com.example.challengerapproaching.Characters.Roy;
import com.example.challengerapproaching.Characters.Ryu;
import com.example.challengerapproaching.Characters.Samus;
import com.example.challengerapproaching.Characters.Sheik;
import com.example.challengerapproaching.Characters.Shulk;
import com.example.challengerapproaching.Characters.Simon;
import com.example.challengerapproaching.Characters.Snake;
import com.example.challengerapproaching.Characters.Sonic;
import com.example.challengerapproaching.Characters.Squirtle;
import com.example.challengerapproaching.Characters.Terry;
import com.example.challengerapproaching.Characters.Toon_Link;
import com.example.challengerapproaching.Characters.Villager;
import com.example.challengerapproaching.Characters.Wario;
import com.example.challengerapproaching.Characters.Wii_Fit_Trainer;
import com.example.challengerapproaching.Characters.Wolf;
import com.example.challengerapproaching.Characters.Yoshi;
import com.example.challengerapproaching.Characters.Young_Link;
import com.example.challengerapproaching.Characters.Zelda;
import com.example.challengerapproaching.Characters.Zero_Suit_Samus;

import javax.xml.parsers.FactoryConfigurationError;

public class MainActivity extends AppCompatActivity {
   Button banjoKazooie, Bayonetta, Bowser, bowserJr, Byleth,
    captainFalcon, Chrom, Cloud, Corrin, Daisy, darkPit,
   darkSamus, diddyKong, donkeyKong, drMario, duckHunt,
    Falco, Fox, Ganondorf, Greninja, Hero, iceClimbers,
    Ike, Incineroar, Inkling, Isabelle, Jigglypuff,
    Joker, Ken, kingDedede, kingKRool, Kirby, Link,
    littleMac, Lucario, Lucas, Lucina, Luigi, Mario,
    Marth, megaMan, metaKnight, Mewtwo, miiBrawler,
    miiGunner, miiSwordfighter, mrGameandWatch,
    Ness, Olimar, pacMan, Palutena, Peach, Pichu,
    Pikachu, piranhaPlant, Pit, Squirtle, Ivysaur,
    Charizard, Richter, Ridley, ROB, Robin,
    rosalinaAndLuma, Roy, Ryu, Samus, Sheik,
    Shulk, Simon, Snake, Sonic, Terry, toonLink, Villager,
    Wario, wiiFitTrainer, Wolf, Yoshi, youngLink,
    Zelda, zeroSuitSamus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banjoKazooie = (Button)findViewById(R.id.banjoKazooie);
        banjoKazooie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Banjo_Kazooie.class);
                startActivity(i);
            }
        });
        Bayonetta = (Button)findViewById(R.id.bayonetta);
        Bayonetta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Bayonetta.class);
                startActivity(i);
            }
        });
        Bowser = (Button)findViewById(R.id.bowser);
        Bowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Bowser.class);
                startActivity(i);
            }
        });
        bowserJr = (Button)findViewById(R.id.bowserJr);
        bowserJr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Bowser_Jr.class);
                startActivity(i);
            }
        });
        Byleth = (Button)findViewById(R.id.bylthe);
        Byleth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Bylthe.class);
                startActivity(i);
            }
        });
        captainFalcon = (Button)findViewById(R.id.captainFalcon);
        captainFalcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Captain_Falcon.class);
                startActivity(i);
            }
        });
        Charizard = (Button)findViewById(R.id.charizard);
        Charizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Charizard.class);
                startActivity(i);
            }
        });
        Chrom = (Button)findViewById(R.id.chrom);
        Chrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Chrom.class);
                startActivity(i);
            }
        });
        Cloud = (Button)findViewById(R.id.cloud);
        Cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Cloud.class);
                startActivity(i);
            }
        });
        Corrin = (Button)findViewById(R.id.corrin);
        Corrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Corrin.class);
                startActivity(i);
            }
        });
        Daisy = (Button)findViewById(R.id.daisy);
        Daisy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Daisy.class);
                startActivity(i);
            }
        });
        darkPit = (Button)findViewById(R.id.darkPit);
        darkPit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Dark_Pit.class);
                startActivity(i);
            }
        });
        darkSamus = (Button)findViewById(R.id.darkSamus);
        darkSamus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Dark_Samus.class);
                startActivity(i);
            }
        });
        diddyKong = (Button)findViewById(R.id.diddyKong);
        diddyKong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Diddy_Kong.class);
                startActivity(i);
            }
        });
        donkeyKong = (Button)findViewById(R.id.donkeyKong);
        donkeyKong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Donkey_Kong.class);
                startActivity(i);
            }
        });
        drMario = (Button)findViewById(R.id.dr_mario);
        drMario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Dr_Mario.class);
                startActivity(i);
            }
        });
        duckHunt = (Button)findViewById(R.id.duckHunt);
        duckHunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Duck_Hunt.class);
                startActivity(i);
            }
        });
        Falco = (Button)findViewById(R.id.falco);
        Falco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Falco.class);
                startActivity(i);
            }
        });
        Fox = (Button)findViewById(R.id.fox);
        Fox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Fox.class);
                startActivity(i);
            }
        });
        Ganondorf = (Button)findViewById(R.id.ganondorf);
        Ganondorf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ganondorf.class);
                startActivity(i);
            }
        });
        Greninja = (Button)findViewById(R.id.greninja);
        Greninja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Greninja.class);
                startActivity(i);
            }
        });
        Hero = (Button)findViewById(R.id.hero);
        Hero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Hero.class);
                startActivity(i);
            }
        });
        iceClimbers = (Button)findViewById(R.id.iceClimbers);
        iceClimbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ice_Climbers.class);
                startActivity(i);
            }
        });
        Ike = (Button)findViewById(R.id.ike);
        Ike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ike.class);
                startActivity(i);
            }
        });
        Incineroar = (Button)findViewById(R.id.incineroar);
        Incineroar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Incineroar.class);
                startActivity(i);
            }
        });
        Inkling = (Button)findViewById(R.id.inkling);
        Inkling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Inkling.class);
                startActivity(i);
            }
        });
        Isabelle = (Button)findViewById(R.id.isabelle);
        Isabelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Isabelle.class);
                startActivity(i);
            }
        });
        Ivysaur = (Button)findViewById(R.id.ivysaur);
        Ivysaur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ivysaur.class);
                startActivity(i);
            }
        });
        Jigglypuff = (Button)findViewById(R.id.jigglypuff);
        Jigglypuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Jigglypuff.class);
                startActivity(i);
            }
        });
        Joker = (Button)findViewById(R.id.joker);
        Joker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Joker.class);
                startActivity(i);
            }
        });
        Ken = (Button)findViewById(R.id.ken);
        Ken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ken.class);
                startActivity(i);
            }
        });
        kingDedede = (Button)findViewById(R.id.kingDedede);
        kingDedede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, King_Dedede.class);
                startActivity(i);
            }
        });
        kingKRool = (Button)findViewById(R.id.kingK_Rool);
        kingKRool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, King_K_Rool.class);
                startActivity(i);
            }
        });
        Kirby = (Button)findViewById(R.id.kirby);
        Kirby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Kirby.class);
                startActivity(i);
            }
        });
        Link = (Button)findViewById(R.id.link);
        Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Link.class);
                startActivity(i);
            }
        });
        littleMac = (Button)findViewById(R.id.littleMac);
        littleMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Little_Mac.class);
                startActivity(i);
            }
        });
        Lucario = (Button)findViewById(R.id.lucario);
        Lucario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lucario.class);
                startActivity(i);
            }
        });
        Lucas = (Button)findViewById(R.id.lucas);
        Lucas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lucas.class);
                startActivity(i);
            }
        });
        Lucina = (Button)findViewById(R.id.lucina);
        Lucina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lucina.class);
                startActivity(i);
            }
        });
        Luigi = (Button)findViewById(R.id.Luigi);
        Luigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Luigi.class);
                startActivity(i);
            }
        });
        Mario = (Button)findViewById(R.id.mario);
        Mario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mario.class);
                startActivity(i);
            }
        });
        Marth = (Button)findViewById(R.id.marth);
        Marth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Marth.class);
                startActivity(i);
            }
        });
        megaMan = (Button)findViewById(R.id.megaMan);
        megaMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mega_Man.class);
                startActivity(i);
            }
        });
        metaKnight = (Button)findViewById(R.id.metaKnight);
        metaKnight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Meta_Knight.class);
                startActivity(i);
            }
        });
        Mewtwo = (Button)findViewById(R.id.mewtwo);
        Mewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mewtwo.class);
                startActivity(i);
            }
        });
        miiBrawler = (Button)findViewById(R.id.miiBrawler);
        miiBrawler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mii_Brawler.class);
                startActivity(i);
            }
        });
        miiGunner = (Button)findViewById(R.id.miiGunner);
        miiGunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mii_Gunner.class);
                startActivity(i);
            }
        });
        miiSwordfighter = (Button)findViewById(R.id.miiSwordfighter);
        miiSwordfighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mii_Swordfighter.class);
                startActivity(i);
            }
        });
        mrGameandWatch = (Button)findViewById(R.id.mr_GameWatch);
        mrGameandWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mr_Game_and_Watch.class);
                startActivity(i);
            }
        });
        Ness = (Button)findViewById(R.id.ness);
        Ness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ness.class);
                startActivity(i);
            }
        });
        Olimar = (Button)findViewById(R.id.olimar);
        Olimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Olimar.class);
                startActivity(i);
            }
        });
        pacMan = (Button)findViewById(R.id.pacMan);
        pacMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Pac_Man.class);
                startActivity(i);
            }
        });
        Palutena = (Button)findViewById(R.id.palutena);
        Palutena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Palutena.class);
                startActivity(i);
            }
        });
        Peach = (Button)findViewById(R.id.peach);
        Peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Peach.class);
                startActivity(i);
            }
        });
        Pichu = (Button)findViewById(R.id.pichu);
        Pichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Pichu.class);
                startActivity(i);
            }
        });
        Pikachu = (Button)findViewById(R.id.pikachu);
        Pikachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Pikachu.class);
                startActivity(i);
            }
        });
        piranhaPlant = (Button)findViewById(R.id.piranhaPlant);
        piranhaPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Piranha_Plant.class);
                startActivity(i);
            }
        });
        Pit = (Button)findViewById(R.id.pit);
        Pit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Pit.class);
                startActivity(i);
            }
        });
        Richter = (Button)findViewById(R.id.richter);
        Richter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Richter.class);
                startActivity(i);
            }
        });
        Ridley = (Button)findViewById(R.id.ridley);
        Ridley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ridley.class);
                startActivity(i);
            }
        });
        ROB = (Button)findViewById(R.id.r_o_b_);
        ROB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ROB.class);
                startActivity(i);
            }
        });
        Robin = (Button)findViewById(R.id.robin);
        Robin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Robin.class);
                startActivity(i);
            }
        });
        rosalinaAndLuma = (Button)findViewById(R.id.rosalinaAndLuma);
        rosalinaAndLuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Rosalina_and_Luma.class);
                startActivity(i);
            }
        });
        Roy = (Button)findViewById(R.id.roy);
        Roy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Roy.class);
                startActivity(i);
            }
        });
        Ryu = (Button)findViewById(R.id.ryu);
        Ryu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ryu.class);
                startActivity(i);
            }
        });
        Samus = (Button)findViewById(R.id.samus);
        Samus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Samus.class);
                startActivity(i);
            }
        });
        Sheik = (Button)findViewById(R.id.sheik);
        Sheik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Sheik.class);
                startActivity(i);
            }
        });
        Shulk = (Button)findViewById(R.id.shulk);
        Shulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Shulk.class);
                startActivity(i);
            }
        });
        Simon = (Button)findViewById(R.id.simon);
        Simon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Simon.class);
                startActivity(i);
            }
        });
        Snake = (Button)findViewById(R.id.snake);
        Snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Snake.class);
                startActivity(i);
            }
        });
        Sonic = (Button)findViewById(R.id.sonic);
        Sonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Sonic.class);
                startActivity(i);
            }
        });
        Squirtle = (Button)findViewById(R.id.squirtle);
        Squirtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Squirtle.class);
                startActivity(i);
            }
        });
        Terry = (Button)findViewById(R.id.terry);
        Terry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Terry.class);
                startActivity(i);
            }
        });
        toonLink = (Button)findViewById(R.id.toonLink);
        toonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Toon_Link.class);
                startActivity(i);
            }
        });
        Villager = (Button)findViewById(R.id.villager);
        Villager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Villager.class);
                startActivity(i);
            }
        });
        Wario = (Button)findViewById(R.id.wario);
        Wario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Wario.class);
                startActivity(i);
            }
        });
        wiiFitTrainer = (Button)findViewById(R.id.wiiFitTrainer);
        wiiFitTrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Wii_Fit_Trainer.class);
                startActivity(i);
            }
        });
        Wolf = (Button)findViewById(R.id.wolf);
        Wolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Wolf.class);
                startActivity(i);
            }
        });
        Yoshi = (Button)findViewById(R.id.yoshi);
        Yoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Yoshi.class);
                startActivity(i);
            }
        });
        youngLink = (Button)findViewById(R.id.youngLink);
        youngLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Young_Link.class);
                startActivity(i);
            }
        });
        Zelda = (Button)findViewById(R.id.zelda);
        Zelda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Zelda.class);
                startActivity(i);
            }
        });
        zeroSuitSamus = (Button)findViewById(R.id.zeroSuitSamus);
        zeroSuitSamus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Zero_Suit_Samus.class);
                startActivity(i);
            }
        });
    }
}
