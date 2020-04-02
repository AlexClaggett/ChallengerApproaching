package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Palutena's xml
 * file when the respective button is pushed.*/

public class Palutena extends AppCompatActivity {

  String [] Palutenamoves = {
          "PalutenaAutoreticle.gif",
          "PalutenaBAir.gif",
          "PalutenaBThrow.gif",
          "PalutenaCounter.gif",
          "PalutenaCounterHit.gif",
          "PalutenaDAir.gif",
          "PalutenaDashAttack.gif",
          "PalutenaDashGrab.gif",
          "PalutenaDSmash.gif",
          "PalutenaDThrow.gif",
          "PalutenaDTilt.gif",
          "PalutenaExplosiveFlame.gif",
          "PalutenaFAir.gif",
          "PalutenaFSmash.gif",
          "PalutenaFThrow.gif",
          "PalutenaFTilt.gif",
          "PalutenaGrab.gif",
          "PalutenaJab1.gif",
          "PalutenaJabRapid.gif",
          "PalutenaJabRapidEnd.gif",
          "PalutenaNAir.gif",
          "PalutenaPivotGrab.gif",
          "PalutenaPummel.gif",
          "PalutenaReflectBarrier.gif",
          "PalutenaUAir.gif",
          "PalutenaUSmash.gif",
          "PalutenaUThrow.gif",
          "PalutenaUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_palutena);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/palutena/" + Palutenamoves[position];
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
