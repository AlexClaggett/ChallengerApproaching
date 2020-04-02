package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Banjo Kazooie's xml
 * file when the respective button is pushed.*/

public class BanjoKazooie extends AppCompatActivity {

  String [] Banjo_Kazooiemoves = {
//          "BanjoKazooieBreegullBlaster1-6.png",
//          "BanjoKazooieBreegullBlaster13.png",
//          "BanjoKazooieBreegullBlaster7-12.png",
//          "BanjoKazooieEggFiring.png",
          "Banjo_KazooieBAir.gif",
          "Banjo_KazooieBThrow.gif",
          "Banjo_KazooieDAir.gif",
          "Banjo_KazooieDAirLanding.gif",
          "Banjo_KazooieDashAttack.gif",
          "Banjo_KazooieDashGrab.gif",
          "Banjo_KazooieDSmash.gif",
          "Banjo_KazooieDThrow.gif",
          "Banjo_KazooieDTilt.gif",
          "Banjo_KazooieFAir.gif",
          "Banjo_KazooieFSmash.gif",
          "Banjo_KazooieFThrow.gif",
          "Banjo_KazooieFTilt.gif",
          "Banjo_KazooieFTiltDown.gif",
          "Banjo_KazooieFTiltUp.gif",
          "Banjo_KazooieGrab.gif",
          "Banjo_KazooieJab1.gif",
          "Banjo_KazooieJab2.gif",
          "Banjo_KazooieJab3.gif",
          "Banjo_KazooieJabRapid.gif",
          "Banjo_KazooieJabRapidEnd.gif",
          "Banjo_KazooieNAir.gif",
          "Banjo_KazooiePivotGrab.gif",
          "Banjo_KazooiePummel.gif",
          "Banjo_KazooieShockSpringJump.gif",
          "Banjo_KazooieUAir.gif",
          "Banjo_KazooieUSmash.gif",
          "Banjo_KazooieUThrow.gif",
          "Banjo_KazooieUTilt.gif",
          "Banjo_KazooieWonderwing.gif",
//          "Rear20Egg.png"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_banjo__kazooie);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/banjo_and_kazooie/" + Banjo_Kazooiemoves[position];
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