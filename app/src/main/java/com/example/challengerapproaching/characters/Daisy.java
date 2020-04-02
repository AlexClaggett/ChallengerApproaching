package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Daisy's xml
 * file when the respective button is pushed.*/

public class Daisy extends AppCompatActivity {

  String [] Daisymoves = {
          "DaisyBAir.gif",
          "DaisyBThrow.gif",
          "DaisyDAir.gif",
//          "DaisyDaisyBomber.png",
          "DaisyDaisyBomberHit.gif",
          "DaisyDaisyParasol.gif",
          "DaisyDaisyParasolFall.gif",
          "DaisyDashAttack.gif",
          "DaisyDashGrab.gif",
          "DaisyDSmash.gif",
          "DaisyDThrow.gif",
          "DaisyDTilt.gif",
          "DaisyFAir.gif",
          "DaisyFSmashFryingPan.gif",
          "DaisyFSmashGolfClub.gif",
          "DaisyFSmashTennisRacket.gif",
          "DaisyFThrow.gif",
          "DaisyFTilt.gif",
          "DaisyGrab.gif",
          "DaisyJab1.gif",
          "DaisyJab2.gif",
          "DaisyNAir.gif",
          "DaisyPivotGrab.gif",
          "DaisyPummel.gif",
          "DaisyToad.gif",
          "DaisyUAir.gif",
          "DaisyUSmash.gif",
          "DaisyUThrow.gif",
          "DaisyUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_daisy);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/daisy/" + Daisymoves[position];
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
