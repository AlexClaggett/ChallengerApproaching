package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Dark Pit's xml
 * file when the respective button is pushed.*/

public class DarkPit extends AppCompatActivity {

  String [] DarkPitmoves = {
          "DarkPitBAir.gif",
          "DarkPitBThrow.gif",
          "DarkPitDAir.gif",
          "DarkPitDashAttack.gif",
          "DarkPitDashGrab.gif",
          "DarkPitDSmash.gif",
          "DarkPitDThrow.gif",
          "DarkPitDTilt.gif",
          "DarkPitElectroshockArmA.gif",
          "DarkPitElectroshockArmG.gif",
          "DarkPitElectroshockArmHitA.gif",
          "DarkPitElectroshockArmHitG.gif",
          "DarkPitFAir.gif",
          "DarkPitFSmash.gif",
          "DarkPitFThrow.gif",
          "DarkPitFTilt.gif",
          "DarkPitGrab.gif",
          "DarkPitGuardianOrbitars.gif",
          "DarkPitJab1.gif",
          "DarkPitJab2.gif",
          "DarkPitJab3.gif",
          "DarkPitJabRapid.gif",
          "DarkPitJabRapidEnd.gif",
          "DarkPitNAir.gif",
          "DarkPitPivotGrab.gif",
          "DarkPitPummel.gif",
          "DarkPitUAir.gif",
          "DarkPitUSmash.gif",
          "DarkPitUThrow.gif",
          "DarkPitUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dark_pit);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/dark_pit/" + DarkPitmoves[position];
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