package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Fox's xml
 * file when the respective button is pushed.*/

public class Fox extends AppCompatActivity {


  String [] Foxmoves = {
          "FoxBAir.gif",
          "FoxBlaster.gif",
          "FoxBThrow.gif",
          "FoxDAir.gif",
          "FoxDashAttack.gif",
          "FoxDashGrab.gif",
          "FoxDSmash.gif",
          "FoxDThrow.gif",
          "FoxDTilt.gif",
          "FoxFAir.gif",
          "FoxFireFox.gif",
//          "FoxFoxIllusion.png",
          "FoxFSmash.gif",
          "FoxFThrow.gif",
          "FoxFTilt.gif",
          "FoxFTiltDown.gif",
          "FoxFTiltUp.gif",
          "FoxGrab.gif",
          "FoxJab1.gif",
          "FoxJab2.gif",
          "FoxJabRapid.gif",
          "FoxJabRapidEnd.gif",
          "FoxNAir.gif",
          "FoxPivotGrab.gif",
          "FoxPummel.gif",
          "FoxReflector.gif",
          "FoxReflectorStart.gif",
          "FoxUAir.gif",
          "FoxUSmash.gif",
          "FoxUTHrow.gif",
          "FoxUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fox);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/fox/" + Foxmoves[position];
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
