package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Zelda's xml
 * file when the respective button is pushed.*/

public class Zelda extends AppCompatActivity {

  String [] Zeldamoves = {
          "PhantomKick.gif",
          "PhantomPunch.gif",
          "PhantomSwing1.gif",
          "PhantomSwing2.gif",
          "PhantomSwing3.gif",
          "ZeldaBAir.gif",
          "ZeldaBThrow.gif",
          "ZeldaDAir.gif",
          "ZeldaDashAttack.gif",
          "ZeldaDashGrab.gif",
//          "ZeldaDinsFire.png",
          "ZeldaDSmash.gif",
          "ZeldaDThrow.gif",
          "ZeldaDTilt.gif",
          "ZeldaFAir.gif",
          "ZeldaFSmash.gif",
          "ZeldaFThrow.gif",
          "ZeldaFTilt.gif",
          "ZeldaFTiltDown.gif",
          "ZeldaFTiltUp.gif",
          "ZeldaGrab.gif",
          "ZeldaJab.gif",
          "ZeldaJabRapid.gif",
          "ZeldaJabRapidEnd.gif",
          "ZeldaNAir.gif",
          "ZeldaNayrusLove.gif",
          "ZeldaNFaroresWindA.gif",
          "ZeldaNFaroresWindG.gif",
          "ZeldaPivotGrab.gif",
          "ZeldaPummel.gif",
          "ZeldaUAir.gif",
          "ZeldaUSmash.gif",
          "ZeldaUThrow.gif",
          "ZeldaUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zelda);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/zelda/" + Zeldamoves[position];
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