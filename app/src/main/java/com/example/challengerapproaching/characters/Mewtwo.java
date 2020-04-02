package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Mewtwo's xml
 * file when the respective button is pushed.*/

public class Mewtwo extends AppCompatActivity {

  String [] Mewtwomoves = {
          "MewtwoBAir.gif",
          "MewtwoBThrow.gif",
          "MewtwoConfusion.gif",
          "MewtwoDAir.gif",
          "MewtwoDashAttack.gif",
          "MewtwoDashGrab.gif",
          "MewtwoDisable.gif",
          "MewtwoDSmash.gif",
          "MewtwoDThrow.gif",
          "MewtwoDTilt.gif",
          "MewtwoFAir.gif",
          "MewtwoFSmash.gif",
          "MewtwoFSmashDown.gif",
          "MewtwoFSmashUp.gif",
          "MewtwoFThrow.gif",
          "MewtwoFTilt.gif",
          "MewtwoFTiltDown.gif",
          "MewtwoFTiltUp.gif",
          "MewtwoGrab.gif",
          "MewtwoJab.gif",
          "MewtwoJabRapid.gif",
          "MewtwoJabRapidEnd.gif",
          "MewtwoNAir.gif",
          "MewtwoPivotGrab.gif",
          "MewtwoPummel.gif",
          "MewtwoUAir.gif",
          "MewtwoUSmash.gif",
          "MewtwoUThrow.gif",
          "MewtwoUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mewtwo);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/mewtwo/" + Mewtwomoves[position];
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

