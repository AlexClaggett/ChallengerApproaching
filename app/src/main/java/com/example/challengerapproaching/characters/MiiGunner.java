package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Mii Gunner's xml
 * file when the respective button is pushed.*/

public class MiiGunner extends AppCompatActivity {

  String [] MiiGunnermoves = {
//          "MiiGunnerBombDrop.png",
//          "MiiGunnerBombDropExplosion.png",
//          "MiiGunnerGrenadeLauncher.png",
//          "MiiGunnerGrenadeLauncherExplosion.png",
//          "MiiGunnerMiiMissile.png",
//          "MiiGunnerSuperMissile.png",
          "SansAbsorbingVortex.gif",
          "SansBAir.gif",
          "SansBThrow.gif",
          "SansCannonJumpKick.gif",
          "SansDAir.gif",
          "SansDashAttack.gif",
          "SansDashGrab.gif",
          "SansDSmash.gif",
          "SansDThrow.gif",
          "SansDTilt.gif",
          "SansEchoReflector.gif",
          "SansEchoReflectorStart.gif",
          "SansFAir.gif",
          "SansFSmash.gif",
          "SansFThrow.gif",
          "SansFTilt.gif",
          "SansGrab.gif",
          "SansJab1.gif",
          "SansJab2.gif",
          "SansJab3.gif",
          "SansNAir.gif",
          "SansPivotGrab.gif",
          "SansPummel.gif",
          "SansUAir.gif",
          "SansUSmash.gif",
          "SansUThrow.gif",
          "SansUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mii__gunner);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/mii_gunner/" + MiiGunnermoves[position];
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