package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Ness's xml
 * file when the respective button is pushed.*/

public class Ness extends AppCompatActivity {

  String [] Nessmoves = {
          "NessBAir.gif",
          "NessBThrow.gif",
          "NessDAir.gif",
          "NessDashAttack.gif",
          "NessDashGrab.gif",
          "NessDSmash.gif",
//          "NessDSmashCharge.png",
          "NessDThrow.gif",
          "NessDTilt.gif",
          "NessFAir.gif",
          "NessFSmash.gif",
          "NessFThrow.gif",
          "NessFTilt.gif",
          "NessFTiltDown.gif",
          "NessFTiltUp.gif",
          "NessGrab.gif",
          "NessJab1.gif",
          "NessJab2.gif",
          "NessJab3.gif",
          "NessNAir.gif",
          "NessPivotGrab.gif",
          "NessPKFireA.gif",
          "NessPKFireG.gif",
//          "NessPKFirePillar.png",
//          "NessPKFlash.png",
          "NessPKThunder2.gif",
          "NessPSIMagnet.gif",
          "NessPSIMagnetEnd.gif",
          "NessPummel.gif",
          "NessUAir.gif",
//          "NessUSmash.png",
//          "NessUSmashCharge.png",
          "NessUThrow.gif",
          "NessUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ness);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ness/" + Nessmoves[position];
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
