package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Bowser's xml
 * file when the respective button is pushed.*/

public class Bowser extends AppCompatActivity {

  String [] Bowsermoves = {
          "BowserBAir.gif",
//          "BowserBowserBomb.png",
          "BowserBowserBombG.gif",
          "BowserBowserBombLanding.gif",
          "BowserBThrow.gif",
          "BowserDAir.gif",
          "BowserDashAttack.gif",
          "BowserDashGrab.gif",
          "BowserDSmash.gif",
          "BowserDThrow.gif",
          "BowserDTilt.gif",
          "BowserFAir.gif",
          "BowserFlyingSlam.gif",
          "BowserFlyingSlamGrabA.gif",
          "BowserFlyingSlamGrabG.gif",
          "BowserFSmash.gif",
          "BowserFThrow.gif",
          "BowserFTilt.gif",
          "BowserFTiltDown.gif",
          "BowserFTiltUp.gif",
          "BowserGrab.gif",
          "BowserJab1.gif",
          "BowserJab2.gif",
          "BowserNAir.gif",
          "BowserPivotrGrab.gif",
          "BowserPummel.gif",
          "BowserUAir.gif",
          "BowserUSmash.gif",
          "BowserUThrow.gif",
          "BowserUTilt.gif",
          "BowserWhirlingFortressA.gif",
          "BowserWhirlingFortressG.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bowser);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/bowser/" + Bowsermoves[position];
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
