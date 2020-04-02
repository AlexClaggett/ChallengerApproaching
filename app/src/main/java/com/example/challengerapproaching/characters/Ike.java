package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Ike's xml
 * file when the respective button is pushed.*/

public class Ike extends AppCompatActivity {

  String [] Ikemoves = {
          "IkeAetherA.gif",
          "IkeAetherFall.gif",
          "IkeAetherG.gif",
          "IkeAetherLanding.gif",
          "IkeAetherSword.gif",
          "IkeBAir.gif",
          "IkeBThrow.gif",
          "IkeCounter.gif",
          "IkeCounterHit.gif",
          "IkeDAir.gif",
          "IkeDashAttack.gif",
          "IkeDashGrab.gif",
          "IkeDSmash.gif",
          "IkeDThrow.gif",
          "IkeDTilt.gif",
          "IkeEruption.gif",
          "IkeEruptionMax.gif",
          "IkeEruptionMid.gif",
          "IkeFAir.gif",
          "IkeFSmash.gif",
          "IkeFThrow.gif",
          "IkeFTilt.gif",
          "IkeFTiltDown.gif",
          "IkeFTiltUp.gif",
          "IkeGrab.gif",
          "IkeJab1.gif",
          "IkeJab2.gif",
          "IkeJab3.gif",
          "IkeNAir.gif",
          "IkePivotGrab.gif",
          "IkePummel.gif",
          "IkeQuickDraw.gif",
          "IkeUAir.gif",
          "IkeUSmash.gif",
          "IkeUThrow.gif",
          "IkeUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ike);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ike/" + Ikemoves[position];
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
