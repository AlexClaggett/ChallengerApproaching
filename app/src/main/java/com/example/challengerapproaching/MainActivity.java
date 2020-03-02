package com.example.challengerapproaching;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.challengerapproaching.Characters.*;

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

    Button [] buttons = {banjoKazooie, Bayonetta, Bowser, bowserJr, Byleth,
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
            Zelda, zeroSuitSamus};

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
            Bylthe.class, Captain_Falcon.class, Chrom.class, Cloud.class, Corrin.class, Daisy.class, Dark_Pit.class,
            Dark_Samus.class, Diddy_Kong.class, Donkey_Kong.class, Dr_Mario.class, Duck_Hunt.class,
            Falco.class, Fox.class, Ganondorf.class, Greninja.class, Hero.class, Ice_Climbers.class,
            Ike.class, Incineroar.class, Inkling.class, Isabelle.class, Jigglypuff.class,
            Joker.class, Ken.class, King_Dedede.class, King_K_Rool.class, Kirby.class, Link.class,
            Little_Mac.class, Lucario.class, Lucas.class, Lucina.class, Luigi.class, Mario.class,
            Marth.class, Mega_Man.class, Meta_Knight.class, Mewtwo.class, Mii_Brawler.class,
            Mii_Gunner.class, Mii_Swordfighter.class, Mr_Game_and_Watch.class,
            Ness.class, Olimar.class, Pac_Man.class, Palutena.class, Peach.class, Pichu.class,
            Pikachu.class, Piranha_Plant.class, Pit.class, Squirtle.class, Ivysaur.class,
            Charizard.class, Richter.class, Ridley.class, ROB.class, Robin.class,
            Rosalina_and_Luma.class, Roy.class, Ryu.class, Samus.class, Sheik.class,
            Shulk.class, Simon.class, Snake.class, Sonic.class, Terry.class, Toon_Link.class, Villager.class,
            Wario.class, Wii_Fit_Trainer.class, Wolf.class, Yoshi.class, Young_Link.class,
            Zelda.class, Zero_Suit_Samus.class};

    String [] names = {"banjoKazooie", "Bayonetta", "Bowser", "bowserJr", "Byleth",
            "captainFalcon", "Chrom", "Cloud", "Corrin", "Daisy", "darkPit",
            "darkSamus", "diddyKong", "donkeyKong", "drMario", "duckHunt",
            "Falco", "Fox", "Ganondorf", "Greninja", "Hero", "iceClimbers",
            "Ike", "Incineroar", "Inkling", "Isabelle", "Jigglypuff",
            "Joker", "Ken", "kingDedede", "kingKRool", "Kirby", "Link",
            "littleMac", "Lucario", "Lucas", "Lucina", "Luigi", "Mario",
            "Marth", "megaMan", "metaKnight", "Mewtwo", "miiBrawler",
            "miiGunner", "miiSwordfighter", "mrGameandWatch",
            "Ness", "Olimar", "pacMan", "Palutena", "Peach", "Pichu",
            "Pikachu", "piranhaPlant", "Pit", "Squirtle", "Ivysaur",
            "Charizard", "Richter", "Ridley", "ROB", "Robin",
            "rosalinaAndLuma", "Roy", "Ryu", "Samus", "Sheik",
            "Shulk", "Simon", "Snake", "Sonic", "Terry", "toonLink", "Villager",
            "Wario", "wiiFitTrainer", "Wolf", "Yoshi", "youngLink",
            "Zelda", "zeroSuitSamus"};

    character[] characters = new character [names.length];

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = 0;
        for(String n: names){
            characters[i] = new character(n);
            i++;
        }

        i = 0;

        for (Button b: buttons){
            b = (Button)findViewById(ids[i]);
            final Intent tosend = new Intent(MainActivity.this, charClasses[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = tosend;
                    startActivity(i);
                }
            });
            i++;
        }
    }
}
