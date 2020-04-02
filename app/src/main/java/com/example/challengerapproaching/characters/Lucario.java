package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Lucario's xml
 * file when the respective button is pushed.*/

public class Lucario extends AppCompatActivity {

  String [] Lucariomoves = {
          "LucarioBAir.gif",
          "LucarioBThrow.gif",
          "LucarioDAir.gif",
          "LucarioDashAttack.gif",
          "LucarioDashGrab.gif",
          "LucarioDoubleTeam.gif",
          "LucarioDoubleTeamHit.gif",
          "LucarioDSmash.gif",
          "LucarioDThrow.gif",
          "LucarioDTilt.gif",
          "LucarioExtremeSpeedA.gif",
          "LucarioExtremeSpeedG.gif",
          "LucarioFAir.gif",
          "LucarioForcePalm.gif",
          "LucarioFSmash.gif",
          "LucarioFThrow.gif",
          "LucarioFTilt.gif",
          "LucarioFTiltDown.gif",
          "LucarioFTiltUp.gif",
          "LucarioGrab.gif",
          "LucarioJab1.gif",
          "LucarioJab2.gif",
          "LucarioJab3.gif",
          "LucarioNAir.gif",
          "LucarioPivotGrab.gif",
          "LucarioPummel.gif",
          "LucarioUAir.gif",
          "LucarioUSmash.gif",
          "LucarioUThrow.gif",
          "LucarioUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lucario);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/lucario/" + Lucariomoves[position];
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

