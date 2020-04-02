package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Wario's xml
 * file when the respective button is pushed.*/

public class Wario extends AppCompatActivity {

  String [] Wariomoves = {
          "WarioBAir.gif",
          "WarioBikeDrive.gif",
          "WarioBikeTurn.gif",
          "WarioBikeWheelie.gif",
          "WarioBThrow.gif",
          "WarioChomp.gif",
          "WarioChompBite.gif",
          "WarioChompBomb.gif",
          "WarioCorkscrew.gif",
          "WarioDAir.gif",
          "WarioDashAttack.gif",
          "WarioDashGrab.gif",
          "WarioDSmash.gif",
          "WarioDThrow.gif",
          "WarioDTilt.gif",
          "WarioFAir.gif",
          "WarioFSmash.gif",
          "WarioFThrow.gif",
          "WarioFTilt.gif",
          "WarioFTiltDown.gif",
          "WarioFTiltUp.gif",
          "WarioGrab.gif",
          "WarioJab1.gif",
          "WarioJab2.gif",
          "WarioNAir.gif",
          "WarioPivotGrab.gif",
          "WarioPummel.gif",
          "WarioUAir.gif",
          "WarioUSmash.gif",
          "WarioUThrow.gif",
          "WarioUTilt.gif",
          "WarioWarioWaftFull.gif",
          "WarioWarioWaftHalf.gif",
          "WarioWarioWaftLow.gif",
          "WarioWarioWaftToot.gif",
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wario);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/wario/" + Wariomoves[position];
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