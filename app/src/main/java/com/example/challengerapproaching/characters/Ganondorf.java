package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Ganondorf's xml
 * file when the respective button is pushed.*/

public class Ganondorf extends AppCompatActivity {

  String [] Ganondorfmoves = {
          "GanondorfBAir.gif",
          "GanondorfBThrow.gif",
          "GanondorfDAir.gif",
          "GanondorfDarkDive.gif",
          "GanondorfDarkDiveCatch.gif",
          "GanondorfDashAttack.gif",
          "GanondorfDashGrab.gif",
          "GanondorfDSmash.gif",
          "GanondorfDThrow.gif",
          "GanondorfDTilt.gif",
          "GanondorfFAir.gif",
          "GanondorfFlameChoke.gif",
          "GanondorfFlameChokeA.gif",
          "GanondorfFlameChokeG.gif",
          "GanondorfFSmash.gif",
          "GanondorfFThrow.gif",
          "GanondorfFTilt.gif",
          "GanondorfGrab.gif",
          "GanondorfJab.gif",
          "GanondorfNAir.gif",
          "GanondorfPivotGrab.gif",
          "GanondorfPummel.gif",
          "GanondorfUAir.gif",
          "GanondorfUSmash.gif",
          "GanondorfUThrow.gif",
          "GanondorfUTilt.gif",
          "GanondorfWarlockPunchA.gif",
          "GanondorfWarlockPunchG.gif",
          "GanondorfWarlockPunchRA.gif",
          "GanondorfWarlockPunchRG.gif",
          "GanondorfWizardsFootA.gif",
          "GanondorfWizardsFootALand.gif",
          "GanondorfWizardsFootG.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ganondorf);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ganondorf/" + Ganondorfmoves[position];
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

