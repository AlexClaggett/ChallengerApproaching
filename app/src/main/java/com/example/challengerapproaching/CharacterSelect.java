package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.characters.BanjoKazooie;
import com.example.challengerapproaching.characters.Bayonetta;
import com.example.challengerapproaching.characters.Bowser;
import com.example.challengerapproaching.characters.BowserJr;
import com.example.challengerapproaching.characters.Byleth;
import com.example.challengerapproaching.characters.CaptainFalcon;
import com.example.challengerapproaching.characters.Charizard;
import com.example.challengerapproaching.characters.Chrom;
import com.example.challengerapproaching.characters.Cloud;
import com.example.challengerapproaching.characters.Corrin;
import com.example.challengerapproaching.characters.Daisy;
import com.example.challengerapproaching.characters.DarkPit;
import com.example.challengerapproaching.characters.DarkSamus;
import com.example.challengerapproaching.characters.DiddyKong;
import com.example.challengerapproaching.characters.DonkeyKong;
import com.example.challengerapproaching.characters.DrMario;
import com.example.challengerapproaching.characters.DuckHunt;
import com.example.challengerapproaching.characters.Falco;
import com.example.challengerapproaching.characters.Fox;
import com.example.challengerapproaching.characters.Ganondorf;
import com.example.challengerapproaching.characters.Greninja;
import com.example.challengerapproaching.characters.Hero;
import com.example.challengerapproaching.characters.IceClimbers;
import com.example.challengerapproaching.characters.Ike;
import com.example.challengerapproaching.characters.Incineroar;
import com.example.challengerapproaching.characters.Inkling;
import com.example.challengerapproaching.characters.Isabelle;
import com.example.challengerapproaching.characters.Ivysaur;
import com.example.challengerapproaching.characters.Jigglypuff;
import com.example.challengerapproaching.characters.Joker;
import com.example.challengerapproaching.characters.Ken;
import com.example.challengerapproaching.characters.KingDedede;
import com.example.challengerapproaching.characters.KingKRool;
import com.example.challengerapproaching.characters.Kirby;
import com.example.challengerapproaching.characters.Link;
import com.example.challengerapproaching.characters.LittleMac;
import com.example.challengerapproaching.characters.Lucario;
import com.example.challengerapproaching.characters.Lucas;
import com.example.challengerapproaching.characters.Lucina;
import com.example.challengerapproaching.characters.Luigi;
import com.example.challengerapproaching.characters.Mario;
import com.example.challengerapproaching.characters.Marth;
import com.example.challengerapproaching.characters.MegaMan;
import com.example.challengerapproaching.characters.MetaKnight;
import com.example.challengerapproaching.characters.Mewtwo;
import com.example.challengerapproaching.characters.MiiBrawler;
import com.example.challengerapproaching.characters.MiiGunner;
import com.example.challengerapproaching.characters.MiiSwordfighter;
import com.example.challengerapproaching.characters.MrGameAndWatch;
import com.example.challengerapproaching.characters.Ness;
import com.example.challengerapproaching.characters.Olimar;
import com.example.challengerapproaching.characters.PacMan;
import com.example.challengerapproaching.characters.Palutena;
import com.example.challengerapproaching.characters.Peach;
import com.example.challengerapproaching.characters.Pichu;
import com.example.challengerapproaching.characters.Pikachu;
import com.example.challengerapproaching.characters.PiranhaPlant;
import com.example.challengerapproaching.characters.Pit;
import com.example.challengerapproaching.characters.Richter;
import com.example.challengerapproaching.characters.Ridley;
import com.example.challengerapproaching.characters.Rob;
import com.example.challengerapproaching.characters.Robin;
import com.example.challengerapproaching.characters.RosalinaAndLuma;
import com.example.challengerapproaching.characters.Roy;
import com.example.challengerapproaching.characters.Ryu;
import com.example.challengerapproaching.characters.Samus;
import com.example.challengerapproaching.characters.Sheik;
import com.example.challengerapproaching.characters.Shulk;
import com.example.challengerapproaching.characters.Simon;
import com.example.challengerapproaching.characters.Snake;
import com.example.challengerapproaching.characters.Sonic;
import com.example.challengerapproaching.characters.Squirtle;
import com.example.challengerapproaching.characters.Terry;
import com.example.challengerapproaching.characters.ToonLink;
import com.example.challengerapproaching.characters.Villager;
import com.example.challengerapproaching.characters.Wario;
import com.example.challengerapproaching.characters.WiiFitTrainer;
import com.example.challengerapproaching.characters.Wolf;
import com.example.challengerapproaching.characters.Yoshi;
import com.example.challengerapproaching.characters.YoungLink;
import com.example.challengerapproaching.characters.Zelda;
import com.example.challengerapproaching.characters.ZeroSuitSamus;

/**********************************************************************
 * This class generates the character and event select screen by
 * setting the contentview, instantiating buttons, and setting
 * their listeners to their respective classes.
 *********************************************************************/
public class CharacterSelect extends AppCompatActivity {

    /** Image Button For Bajanjo Kazooie. */
    ImageButton banjoKazooie;

    /** Image Button for Bayonetta. */
    ImageButton bayonetta;

    /** Image Button for Bowser. */
    ImageButton bowser;

    /** Image Button for Bowser Jr. */
    ImageButton bowserJr;

    /** Image Button for Byleth. */
    ImageButton byleth;

    /** Image Button for Captain Falcon. */
    ImageButton captainFalcon;

    /** Image Button for Chrom. */
    ImageButton chrom;

    /** Image Button for Cloud. */
    ImageButton cloud;

    /** Image Button for Corrin. */
    ImageButton corrin;

    /** Image Button for Daisy.*/
    ImageButton daisy;

    /** Image Button for Dark Pit. */
    ImageButton darkPit;

    /** Image Button for Dark Samus. */
    ImageButton darkSamus;

    /** Image Button for Diddy Kong. */
    ImageButton diddyKong;

    /** Image Button for Donkey Kong. */
    ImageButton donkeyKong;

    /** Image Button for Dr. Mario. */
    ImageButton drMario;

    /** Image Button for Duck Hunt. */
    ImageButton duckHunt;

    /** Image Button for Falco. */
    ImageButton falco;

    /** Image Button for Fox. */
    ImageButton fox;

    /** Image Button for Ganondorf. */
    ImageButton ganondorf;

    /** Image Button for Greninja. */
    ImageButton greninja;

    /** Image Button for Hero. */
    ImageButton hero;

    /** Image Button for Ice Climbers. */
    ImageButton iceClimbers;

    /** Image Button for Ike. */
    ImageButton ike;

    /** Image Button for Incineroar. */
    ImageButton incineroar;

    /** Image Button for Inkling. */
    ImageButton inkling;

    /** Image Button for Isabelle. */
    ImageButton isabelle;

    /** Image Button for Jigglypuff. */
    ImageButton jigglypuff;

    /** Image Button for Joker. */
    ImageButton joker;

    /** Image Button for Ken. */
    ImageButton ken;

    /** Image Button for King Dedede. */
    ImageButton kingDedede;

    /** Image Button for King K.Rool. */
    ImageButton kingKRool;

    /** Image Button for Kirby. */
    ImageButton kirby;

    /** Image Button for Link. */
    ImageButton link;

    /** Image Button for LittleMac. */
    ImageButton littleMac;

    /** Image Button for Lucario. */
    ImageButton lucario;

    /** Image Button for Lucas. */
    ImageButton lucas;

    /** Image Button for Lucina. */
    ImageButton lucina;

    /** Image Button for Luigi. */
    ImageButton luigi;

    /** Image Button for Mario. */
    ImageButton mario;

    /** Image Button for Marth. */
    ImageButton marth;

    /** Image Button for Mega Man. */
    ImageButton megaMan;

    /** Image Button for MetaKnight. */
    ImageButton metaKnight;

    /** Image Button for Mewtwo. */
    ImageButton mewtwo;

    /** Image Button for Mii Brawler. */
    ImageButton miiBrawler;

    /** Image Button for Mii Gunner. */
    ImageButton miiGunner;

    /** Image Button for Mii Sword Fighter. */
    ImageButton miiSwordfighter;

    /** Image Button for Mr. Game and Watch. */
    ImageButton mrGameandWatch;

    /** Image Button for Ness. */
    ImageButton ness;

    /** Image Button for Olimar. */
    ImageButton olimar;

    /** Image Button for PacMan. */
    ImageButton pacMan;

    /** Image Button for Palutena. */
    ImageButton palutena;

    /** Image Button for Peach. */
    ImageButton peach;

    /** Image Button for Pichu. */
    ImageButton pichu;

    /** Image Button for Pikachu. */
    ImageButton pikachu;

    /** Image Button for Piranha Plant.*/
    ImageButton piranhaPlant;

    /** Image Button for Pit. */
    ImageButton pit;

    /** Image Button for Squirtle.*/
    ImageButton squirtle;

    /** Image Button for Ivysaur. */
    ImageButton ivysaur;

    /** Image Button for Charizard. */
    ImageButton charizard;

    /** Image Button for Richter.*/
    ImageButton richter;

    /** Image Button for Ridley. */
    ImageButton ridley;

    /** Image Button for Rob. */
    ImageButton rob;

    /** Image Button for Robin. */
    ImageButton robin;

    /** Image Button for Rosalina and Luma. */
    ImageButton rosalinaAndLuma;

    /** Image Button for Roy. */
    ImageButton roy;

    /** Image Button for Ryu. */
    ImageButton ryu;

    /** Image Button for Samus. */
    ImageButton samus;

    /** Image Button for Sheik. */
    ImageButton sheik;

    /** Image Button for Shulk. */
    ImageButton shulk;

    /** Image Button for Simon. */
    ImageButton simon;

    /** Image Button for Snake. */
    ImageButton snake;

    /** Image Button for Sonic. */
    ImageButton sonic;

    /** Image Button for Terry. */
    ImageButton terry;

    /** Image Button for Toon Link.*/
    ImageButton toonLink;

    /** Image Button for Villager. */
    ImageButton villager;

    /** Image Button for Wario. */
    ImageButton wario;

    /** Image Button for Wii Fit Trainer. */
    ImageButton wiiFitTrainer;

    /** Image Button for Wolf. */
    ImageButton wolf;

    /** Image Button for Yoshi. */
    ImageButton yoshi;

    /** Image Button for Young Link. */
    ImageButton youngLink;

    /** Image Button for Zelda. */
    ImageButton zelda;

    /** Image Button for Zero Suit Samus. */
    ImageButton zeroSuitSamus;

    /** Image Button array of the character buttons. */
    ImageButton [] buttons = {banjoKazooie, bayonetta, bowser, bowserJr,
            byleth, captainFalcon, chrom, cloud, corrin, daisy, darkPit,
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

    /** Array of integers of the character ids found in the XML. */
    int [] ids = {R.id.banjoKazooie, R.id.bayonetta, R.id.bowser,
            R.id.bowserJr, R.id.bylthe, R.id.captainFalcon, R.id.chrom,
            R.id.cloud, R.id.corrin, R.id.daisy, R.id.darkPit,
            R.id.darkSamus, R.id.diddyKong, R.id.donkeyKong,
            R.id.dr_mario, R.id.duckHunt, R.id.falco, R.id.fox,
            R.id.ganondorf, R.id.greninja, R.id.hero, R.id.iceClimbers,
            R.id.ike, R.id.incineroar, R.id.inkling, R.id.isabelle,
            R.id.jigglypuff, R.id.joker, R.id.ken, R.id.kingDedede,
            R.id.kingK_Rool, R.id.kirby, R.id.link, R.id.littleMac,
            R.id.lucario, R.id.lucas, R.id.lucina, R.id.Luigi,
            R.id.mario, R.id.marth, R.id.megaMan, R.id.metaKnight,
            R.id.mewtwo, R.id.miiBrawler, R.id.miiGunner,
            R.id.miiSwordfighter, R.id.mr_GameWatch, R.id.ness,
            R.id.olimar, R.id.pacMan, R.id.palutena, R.id.peach,
            R.id.pichu, R.id.pikachu, R.id.piranhaPlant, R.id.pit,
            R.id.squirtle, R.id.ivysaur, R.id.charizard, R.id.richter,
            R.id.ridley, R.id.r_o_b_, R.id.robin, R.id.rosalinaAndLuma,
            R.id.roy, R.id.ryu, R.id.samus, R.id.sheik, R.id.shulk,
            R.id.simon, R.id.snake, R.id.sonic, R.id.terry,
            R.id.toonLink, R.id.villager, R.id.wario, R.id.wiiFitTrainer,
            R.id.wolf, R.id.yoshi, R.id.youngLink, R.id.zelda,
            R.id.zeroSuitSamus};

    /** Array of Classes for each character. */
    Class [] charClasses = {BanjoKazooie.class, Bayonetta.class,
            Bowser.class, BowserJr.class, Byleth.class,
            CaptainFalcon.class, Chrom.class, Cloud.class, Corrin.class,
            Daisy.class, DarkPit.class, DarkSamus.class, DiddyKong.class,
            DonkeyKong.class, DrMario.class, DuckHunt.class, Falco.class,
            Fox.class, Ganondorf.class, Greninja.class, Hero.class,
            IceClimbers.class, Ike.class, Incineroar.class,
            Inkling.class, Isabelle.class, Jigglypuff.class, Joker.class,
            Ken.class, KingDedede.class, KingKRool.class, Kirby.class,
            Link.class, LittleMac.class, Lucario.class, Lucas.class,
            Lucina.class, Luigi.class, Mario.class, Marth.class,
            MegaMan.class, MetaKnight.class, Mewtwo.class,
            MiiBrawler.class, MiiGunner.class, MiiSwordfighter.class,
            MrGameAndWatch.class, Ness.class, Olimar.class, PacMan.class,
            Palutena.class, Peach.class, Pichu.class, Pikachu.class,
            PiranhaPlant.class, Pit.class, Squirtle.class, Ivysaur.class,
            Charizard.class, Richter.class, Ridley.class, Rob.class,
            Robin.class, RosalinaAndLuma.class, Roy.class, Ryu.class,
            Samus.class, Sheik.class, Shulk.class, Simon.class,
            Snake.class, Sonic.class, Terry.class, ToonLink.class,
            Villager.class, Wario.class, WiiFitTrainer.class, Wolf.class,
            Yoshi.class, YoungLink.class, Zelda.class,
            ZeroSuitSamus.class};

    /** Image button for The Events. */
    ImageButton eventButton;

    /********************************************************************
     * Upon app start up this method sets the content view to main
     * activity which is then used to create all the buttons for the
     * characters and the button for events.
     *******************************************************************/
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        int i = 0;

        for (ImageButton b: buttons) {
            b = findViewById(ids[i]);
            final Intent tosend = new Intent(CharacterSelect.this,
                    charClasses[i]);
            b.setOnClickListener(v -> startActivity(tosend));
            i++;
        }

    }
}
