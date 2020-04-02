package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Duck Hunt's xml
 * file when the respective button is pushed.*/

public class DuckHunt extends AppCompatActivity {

  String [] DuckHuntmoves = {
          "DuckHuntBAir.gif",
          "DuckHuntBThrow.gif",
//          "DuckHuntClayShooting.png",
//          "DuckHuntClayShootingBurst.png",
          "DuckHuntDAir.gif",
          "DuckHuntDashAttack.gif",
          "DuckHuntDashGrab.gif",
          "DuckHuntDSmash.gif",
          "DuckHuntDThrow.gif",
          "DuckHuntDTilt.gif",
          "DuckHuntFAir.gif",
          "DuckHuntFSmash.gif",
          "DuckHuntFThrow.gif",
          "DuckHuntFTilt.gif",
          "DuckHuntFTiltDown.gif",
          "DuckHuntFTiltUp.gif",
          "DuckHuntGrab.gif",
          "DuckHuntJab1.gif",
          "DuckHuntJab2.gif",
          "DuckHuntJab3.gif",
          "DuckHuntJabRapid.gif",
          "DuckHuntJabRapidEnd.gif",
          "DuckHuntNAir.gif",
          "DuckHuntPivotGrab.gif",
          "DuckHuntPummel.gif",
//          "DuckHuntTrickShotExplosion.png",
//          "DuckHuntTrickShotFly.png",
//          "DuckHuntTrickShotStand.png",
          "DuckHuntUAir.gif",
          "DuckHuntUSmash.gif",
          "DuckHuntUThrow.gif",
          "DuckHuntUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_duck__hunt);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/duck_hunt/" + DuckHuntmoves[position];
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