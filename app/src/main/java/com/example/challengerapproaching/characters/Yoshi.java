package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Yoshi's xml
 * file when the respective button is pushed.*/

public class Yoshi extends AppCompatActivity {

  String [] Yoshimoves = {
          "YoshiBAir.gif",
          "YoshiBThrow.gif",
          "YoshiDAir.gif",
          "YoshiDashAttack.gif",
          "YoshiDashGrab.gif",
          "YoshiDSmash.gif",
          "YoshiDThrow.gif",
          "YoshiDTilt.gif",
          "YoshiEggLay.gif",
          "YoshiEggRoll.png",
          "YoshiEggThrow.png",
//          "YoshiEggThrowBurst.png",
          "YoshiFAir.gif",
          "YoshiFSmash.gif",
          "YoshiFSmashDown.gif",
          "YoshiFSmashUp.gif",
          "YoshiFThrow.gif",
          "YoshiFTilt.gif",
          "YoshiFTiltDown.gif",
          "YoshiFTiltUp.gif",
          "YoshiGrab.gif",
          "YoshiJab1.gif",
          "YoshiJab2.gif",
          "YoshiNAir.gif",
          "YoshiPivotGrab.gif",
          "YoshiPummel.gif",
          "YoshiUAir.gif",
          "YoshiUSmash.gif",
          "YoshiUThrow.gif",
          "YoshiUTilt.gif",
//          "YoshiYoshiBombFall.png",
          "YoshiYoshiBombG.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_yoshi);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/yoshi/" + Yoshimoves[position];
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