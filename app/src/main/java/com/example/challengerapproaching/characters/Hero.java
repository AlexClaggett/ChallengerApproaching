package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Hero's xml
 * file when the respective button is pushed.*/

public class Hero extends AppCompatActivity {

  String [] Heromoves = {
          "HeroBAir.gif",
          "HeroBThrow.gif",
          "HeroDAir.gif",
          "HeroDashAttack.gif",
          "HeroDashGrab.gif",
          "HeroDSmash.gif",
          "HeroDThrow.gif",
          "HeroDTilt.gif",
          "HeroFAir.gif",
          "HeroFlameSlash.gif",
          "HeroFSmash.gif",
          "HeroFThrow.gif",
          "HeroFTilt1.gif",
          "HeroFTilt2.gif",
          "HeroGrab.gif",
          "HeroHatchetMan.gif",
          "HeroJab1.gif",
          "HeroJab2.gif",
          "HeroJab3.gif",
          "Kaboom.gif",
//          "HeroKaclang.png",
          "Kamikazee.gif",
          "HeroKacrackleSlash.gif",
          "HeroKazap.gif",
          "Magic20Burst.gif",
          "HeroMetalSlash.gif",
          "HeroNAir.gif",
          "HeroPivotGrab.gif",
          "HeroPummel.gif",
          "Sizzle.gif",
          //          "Thwack.png",
          "HeroUAir.gif",
          "HeroUSmash.gif",
          "HeroUThrow.gif",
          "HeroUTilt.gif",
          "HeroZap.gif",
          "HeroZapple.gif",



  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hero);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Heromoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/hero/" + Heromoves[position];
        try {
          gifImageView.setGifImageURL(toURL);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }
}

