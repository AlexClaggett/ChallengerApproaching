package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Kirby's xml
 * file when the respective button is pushed.*/

public class Kirby extends AppCompatActivity {

  String [] Kirbymoves = {
          "KirbyBAir.gif",
          "KirbyBThrow.gif",
          "KirbyDAir.gif",
          "KirbyDashAttack.gif",
          "KirbyDashGrab.gif",
          "KirbyDSmash.gif",
          "KirbyDThrow.gif",
          "KirbyDTilt.gif",
          "KirbyFAir.gif",
          "KirbyFinalCutter.gif",
          "KirbyFSmash.gif",
          "KirbyFSmashDown.gif",
          "KirbyFSmashUp.gif",
          "KirbyFThrow.gif",
          "KirbyFTilt.gif",
          "KirbyFTiltDown.gif",
          "KirbyFTiltUp.gif",
          "KirbyGrab.gif",
          "KirbyHammerFlipA.gif",
          "KirbyHammerFlipAMax.gif",
          "KirbyHammerFlipG.gif",
          "KirbyHammerFlipGMax.gif",
          "KirbyInhale.gif",
          "KirbyInhaleStar.gif",
          "KirbyJab1.gif",
          "KirbyJab2.gif",
          "KirbyJabRapid.gif",
          "KirbyJabRapidEnd.gif",
          "KirbyNAir.gif",
          "KirbyPivotGrab.gif",
          "KirbyPummel.gif",
          "KirbyStone.png",
//          "KirbyStoneLanding.png",
          "KirbyUAir.gif",
          "KirbyUSmash.gif",
          "KirbyUThrow.gif",
          "KirbyUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kirby);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/kirby/" + Kirbymoves[position];
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

