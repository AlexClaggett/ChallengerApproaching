package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {

  ImageButton banjoKazooie;
  ImageButton bayonetta;
  ImageButton bowser;
  ImageButton bowserJr;
  ImageButton byleth;
  ImageButton captainFalcon;
  ImageButton chrom;
  ImageButton cloud;
  ImageButton corrin;
  ImageButton daisy;
  ImageButton darkPit;
  ImageButton darkSamus;
  ImageButton diddyKong;
  ImageButton donkeyKong;
  ImageButton drMario;
  ImageButton duckHunt;
  ImageButton falco;
  ImageButton fox;
  ImageButton ganondorf;
  ImageButton greninja;
  ImageButton hero;
  ImageButton iceClimbers;
  ImageButton ike;
  ImageButton incineroar;
  ImageButton inkling;
  ImageButton isabelle;
  ImageButton jigglypuff;
  ImageButton joker;
  ImageButton ken;
  ImageButton kingDedede;
  ImageButton kingKRool;
  ImageButton kirby;
  ImageButton link;
  ImageButton littleMac;
  ImageButton lucario;
  ImageButton lucas;
  ImageButton lucina;
  ImageButton luigi;
  ImageButton mario;
  ImageButton marth;
  ImageButton megaMan;
  ImageButton metaKnight;
  ImageButton mewtwo;
  ImageButton miiBrawler;
  ImageButton miiGunner;
  ImageButton miiSwordfighter;
  ImageButton mrGameandWatch;
  ImageButton ness;
  ImageButton olimar;
  ImageButton pacMan;
  ImageButton palutena;
  ImageButton peach;
  ImageButton pichu;
  ImageButton pikachu;
  ImageButton piranhaPlant;
  ImageButton pit;
  ImageButton squirtle;
  ImageButton ivysaur;
  ImageButton charizard;
  ImageButton richter;
  ImageButton ridley;
  ImageButton rob;
  ImageButton robin;
  ImageButton rosalinaAndLuma;
  ImageButton roy;
  ImageButton ryu;
  ImageButton samus;
  ImageButton sheik;
  ImageButton shulk;
  ImageButton simon;
  ImageButton snake;
  ImageButton sonic;
  ImageButton terry;
  ImageButton toonLink;
  ImageButton villager;
  ImageButton wario;
  ImageButton wiiFitTrainer;
  ImageButton wolf;
  ImageButton yoshi;
  ImageButton youngLink;
  ImageButton zelda;
  ImageButton zeroSuitSamus;

  ImageButton [] buttons = {banjoKazooie, bayonetta, bowser, bowserJr, byleth,
    captainFalcon, chrom, cloud, corrin, daisy, darkPit,
    darkSamus, diddyKong, donkeyKong, drMario, duckHunt,
    falco, fox, ganondorf, greninja, hero, iceClimbers,
    ike, incineroar, inkling, isabelle, jigglypuff,
    joker, ken, kingDedede, kingKRool, kirby, link,
    littleMac, lucario, lucas, lucina, luigi, mario,
    marth, megaMan, metaKnight, mewtwo, miiBrawler,
    miiGunner, miiSwordfighter, mrGameandWatch,
    ness, olimar, pacMan, palutena, peach, pichu,
    pikachu, piranhaPlant, pit, squirtle, ivysaur,
    charizard, richter, ridley, rob, robin,
    rosalinaAndLuma, roy, ryu, samus, sheik,
    shulk, simon, snake, sonic, terry, toonLink, villager,
    wario, wiiFitTrainer, wolf, yoshi, youngLink,
    zelda, zeroSuitSamus};

  int [] ids = {R.id.banjoKazooie, R.id.bayonetta, R.id.bowser, R.id.bowserJr, R.id.bylthe,
    R.id.captainFalcon, R.id.chrom, R.id.cloud, R.id.corrin, R.id.daisy, R.id.darkPit,
    R.id.darkSamus, R.id.diddyKong, R.id.donkeyKong, R.id.dr_mario, R.id.duckHunt,
    R.id.falco, R.id.fox, R.id.ganondorf, R.id.greninja, R.id.hero, R.id.iceClimbers,
    R.id.ike, R.id.incineroar, R.id.inkling, R.id.isabelle, R.id.jigglypuff,
    R.id.joker, R.id.ken, R.id.kingDedede, R.id.kingK_Rool, R.id.kirby, R.id.link,
    R.id.littleMac, R.id.lucario, R.id.lucas, R.id.lucina, R.id.Luigi, R.id.mario,
    R.id.marth, R.id.megaMan, R.id.metaKnight, R.id.mewtwo, R.id.miiBrawler,
    R.id.miiGunner, R.id.miiSwordfighter, R.id.mr_GameWatch,
    R.id.ness, R.id.olimar, R.id.pacMan, R.id.palutena, R.id.peach, R.id.pichu,
    R.id.pikachu, R.id.piranhaPlant, R.id.pit, R.id.squirtle, R.id.ivysaur,
    R.id.charizard, R.id.richter, R.id.ridley, R.id.r_o_b_, R.id.robin,
    R.id.rosalinaAndLuma, R.id.roy, R.id.ryu, R.id.samus, R.id.sheik,
    R.id.shulk, R.id.simon, R.id.snake, R.id.sonic, R.id.terry, R.id.toonLink, R.id.villager,
    R.id.wario, R.id.wiiFitTrainer, R.id.wolf, R.id.yoshi, R.id.youngLink,
    R.id.zelda, R.id.zeroSuitSamus};

  Class [] charClasses = {Banjo_Kazooie.class, Bayonetta.class, Bowser.class, Bowser_Jr.class,
    Bylthe.class, Captain_Falcon.class, Chrom.class, Cloud.class, Corrin.class, Daisy.class,
    Dark_Pit.class, Dark_Samus.class, Diddy_Kong.class, Donkey_Kong.class, Dr_Mario.class,
    Duck_Hunt.class, Falco.class, Fox.class, Ganondorf.class, Greninja.class, Hero.class,
    Ice_Climbers.class, Ike.class, Incineroar.class, Inkling.class, Isabelle.class,
    Jigglypuff.class, Joker.class, Ken.class, King_Dedede.class, King_K_Rool.class, Kirby.class,
    Link.class, Little_Mac.class, Lucario.class, Lucas.class, Lucina.class, Luigi.class,
    Mario.class, Marth.class, Mega_Man.class, Meta_Knight.class, Mewtwo.class, Mii_Brawler.class,
    Mii_Gunner.class, Mii_Swordfighter.class, Mr_Game_and_Watch.class,
    Ness.class, Olimar.class, Pac_Man.class, Palutena.class, Peach.class, Pichu.class,
    Pikachu.class, Piranha_Plant.class, Pit.class, Squirtle.class, Ivysaur.class,
    Charizard.class, Richter.class, Ridley.class, ROB.class, Robin.class,
    Rosalina_and_Luma.class, Roy.class, Ryu.class, Samus.class, Sheik.class,
    Shulk.class, Simon.class, Snake.class, Sonic.class, Terry.class, Toon_Link.class,
    Villager.class, Wario.class, Wii_Fit_Trainer.class, Wolf.class, Yoshi.class, Young_Link.class,
    Zelda.class, Zero_Suit_Samus.class};

  ImageButton eventButton;

  @RequiresApi(api = Build.VERSION_CODES.M)
  @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int i = 0;

    for (ImageButton b: buttons) {
      b = findViewById(ids[i]);
      final Intent tosend = new Intent(MainActivity.this, charClasses[i]);
      b.setOnClickListener(v -> startActivity(tosend));
      i++;
    }

    eventButton = findViewById(R.id.ButtonEvent);
    eventButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          final Intent event = new Intent(MainActivity.this, Events.class);
            startActivity(event);
          }
        });
  }
}
