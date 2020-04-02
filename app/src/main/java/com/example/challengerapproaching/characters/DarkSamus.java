package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Dark Samus's xml
 * file when the respective button is pushed.*/

public class DarkSamus extends AppCompatActivity {

  String [] DarkSamusmoves = {
          "DarkSamusBAir.gif",
//          "DarkSamusBomb.png",
//          "DarkSamusBombExplosion.png",
          "DarkSamusBThrow.gif",
          "DarkSamusChargeShotMax.gif",
          "DarkSamusChargeShotMin.gif",
          "DarkSamusDAir.gif",
          "DarkSamusDashAttack.gif",
          "DarkSamusDSmash.gif",
          "DarkSamusDThrow.gif",
          "DarkSamusDTilt.gif",
          "DarkSamusFAir.gif",
          "DarkSamusFSmash.gif",
          "DarkSamusFSmashDown.gif",
          "DarkSamusFSmashUp.gif",
          "DarkSamusFThrow.gif",
          "DarkSamusFTilt.gif",
          "DarkSamusFTiltDown.gif",
          "DarkSamusFTiltUp.gif",
          "DarkSamusJab1.gif",
          "DarkSamusJab2.gif",
//          "DarkSamusMissile.png",
          "DarkSamusNAir.gif",
          "DarkSamusPummel.gif",
          "DarkSamusScrewAttackA.gif",
          "DarkSamusScrewAttackG.gif",
//          "DarkSamusSuperMissile.png",
          "DarkSamusUAir.gif",
          "DarkSamusUSmash.gif",
          "DarkSamusUThrow.gif",
          "DarkSamusUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dark_samus);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/dark_samus/" + DarkSamusmoves[position];
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