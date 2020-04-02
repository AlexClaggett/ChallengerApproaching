package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Samus's xml
 * file when the respective button is pushed.*/

public class Samus extends AppCompatActivity {


  String [] Samusmoves = {
          "SamusBAir.gif",
          "SamusBomb.png",
//          "SamusBombExplosion.png",
          "SamusBThrow.gif",
          "SamusChargeShotMax.gif",
          "SamusChargeShotMin.gif",
          "SamusDAir.gif",
          "SamusDashAttack.gif",
          "SamusDSmash.gif",
          "SamusDThrow.gif",
          "SamusDTilt.gif",
          "SamusFAir.gif",
          "SamusFSmash.gif",
          "SamusFSmashDown.gif",
          "SamusFSmashUp.gif",
          "SamusFThrow.gif",
          "SamusFTilt.gif",
          "SamusFTiltDown.gif",
          "SamusFTiltUp.gif",
          "SamusJab1.gif",
          "SamusJab2.gif",
//          "SamusMissile.png",
          "SamusNAir.gif",
          "SamusPummel.gif",
          "SamusScrewAttackA.gif",
          "SamusScrewAttackG.gif",
//          "SamusSuperMissile.png",
          "SamusUAir.gif",
          "SamusUSmash.gif",
          "SamusUThrow.gif",
          "SamusUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_samus);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/samus/" + Samusmoves[position];
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
