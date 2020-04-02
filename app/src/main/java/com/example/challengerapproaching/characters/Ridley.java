package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Ridley's xml
 * file when the respective button is pushed.*/

public class Ridley extends AppCompatActivity {

  String [] Ridleymoves = {
          "RidleyBAir.gif",
          "RidleyBThrow.gif",
          "RidleyDAir.gif",
          "RidleyDashAttack.gif",
          "RidleyDashGrab.gif",
          "RidleyDSmash.gif",
          "RidleyDThrow.gif",
          "RidleyDTilt.gif",
          "RidleyFAir.gif",
          "RidleyFSmash.gif",
          "RidleyFThrow.gif",
          "RidleyFTilt.gif",
          "RidleyFTiltDown.gif",
          "RidleyFTiltUp.gif",
          "RidleyGrab.gif",
          "RidleyJab1.gif",
          "RidleyJab2.gif",
          "RidleyJab3.gif",
          "RidleyJabRapid.gif",
          "RidleyJabRapidEnd.gif",
          "RidleyNAir.gif",
          "RidleyPivotGrab.gif",
          "RidleyPummel.gif",
          "RidleySkewer.gif",
          "RidleySpacePirateRushA.gif",
          "RidleySpacePirateRushDrag.gif",
          "RidleySpacePirateRushDragStart.gif",
          "RidleySpacePirateRushG.gif",
          "RidleyUAir.gif",
          "RidleyUSmash.gif",
          "RidleyUThrow.gif",
          "RidleyUTilt.gif",
          "RidleyWingBlitzBack.gif",
          "RidleyWingBlitzDown.gif",
          "RidleyWingBlitzDownLanding.gif",
          "RidleyWingBlitzForward.gif",
          "RidleyWingBlitzUp.gif",
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ridley);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ridley/" + Ridleymoves[position];
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
