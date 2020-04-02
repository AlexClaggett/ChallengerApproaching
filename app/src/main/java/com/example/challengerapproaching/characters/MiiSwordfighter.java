package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Mii Swordfighter's xml
 * file when the respective button is pushed.*/

public class MiiSwordfighter extends AppCompatActivity {

  String [] MiiSwordfightermoves = {
          "MiiSwordfighterAirborneAssault.gif",
          "MiiSwordfighterAirborneAssaultHit.gif",
          "MiiSwordfighterBAir.gif",
          "MiiSwordfighterBladeCounter.gif",
          "MiiSwordfighterBladeCounterHit.gif",
          "MiiSwordfighterBlurringBlade.gif",
          "MiiSwordfighterBThrow.gif",
          "MiiSwordfighterChakram.png",
          "MiiSwordfighterDAir.gif",
          "MiiSwordfighterDashAttack.gif",
          "MiiSwordfighterDashGrab.gif",
          "MiiSwordfighterDSmash.gif",
          "MiiSwordfighterDThrow.gif",
          "MiiSwordfighterDTilt.gif",
          "MiiSwordfighterFAir.gif",
          "MiiSwordfighterFSmash.gif",
          "MiiSwordfighterFThrow.gif",
          "MiiSwordfighterFTilt.gif",
          "MiiSwordfighterGaleStabHit.gif",
          "MiiSwordfighterGrab.gif",
          "MiiSwordfighterHerosSpinA.gif",
          "MiiSwordfighterHerosSpinG.gif",
          "MiiSwordfighterJab1.gif",
          "MiiSwordfighterJab2.gif",
          "MiiSwordfighterJab3.gif",
          "MiiSwordfighterNAir.gif",
          "MiiSwordfighterPivotGrab.gif",
          "MiiSwordfighterPowerThrustA.gif",
          "MiiSwordfighterPowerThrustALanding.gif",
          "MiiSwordfighterPowerThrustG.gif",
          "MiiSwordfighterPummel.gif",
          "MiiSwordfighterReversalSlash.gif",
          "MiiSwordfighterSkywardSlashDash.gif",
          "MiiSwordfighterStoneScabbard.gif",
          "MiiSwordfighterStoneScabbardLanding.gif",
          "MiiSwordfighterUAir.gif",
          "MiiSwordfighterUSmash.gif",
          "MiiSwordfighterUThrow.gif",
          "MiiSwordfighterUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mii__swordfighter);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/mii_swordfighte/" + MiiSwordfightermoves[position];
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
