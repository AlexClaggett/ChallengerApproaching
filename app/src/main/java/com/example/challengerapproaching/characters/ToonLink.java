package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Toon Link's xml
 * file when the respective button is pushed.*/

public class ToonLink extends AppCompatActivity {

  String [] ToonLinkmoves = {
//          "ToonLinkArrow.png",
          "ToonLinkBAir.gif",
//          "ToonLinkBoomerang.png",
          "ToonLinkBThrow.gif",
          "ToonLinkDAir.gif",
          "ToonLinkDAirLanding.gif",
          "ToonLinkDashAttack.gif",
          "ToonLinkDashGrab.gif",
          "ToonLinkDSmash.gif",
          "ToonLinkDThrow.gif",
          "ToonLinkDTilt.gif",
          "ToonLinkFAir.gif",
          "ToonLinkFSmash.gif",
          "ToonLinkFThrow.gif",
          "ToonLinkFTilt.gif",
          "ToonLinkGrab.gif",
          "ToonLinkJab1.gif",
          "ToonLinkJab2.gif",
          "ToonLinkJab3.gif",
          "ToonLinkNAir.gif",
          "ToonLinkPivotGrab.gif",
          "ToonLinkPummel.gif",
          "ToonLinkSpinAttackA.gif",
          "ToonLinkSpinAttackG.gif",
          "ToonLinkUAir.gif",
          "ToonLinkUSmash.gif",
          "ToonLinkUThrow.gif",
          "ToonLinkUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_toon__link);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/toon_link/" + ToonLinkmoves[position];
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
