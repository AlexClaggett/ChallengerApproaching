package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Corrin's xml
 * file when the respective button is pushed.*/

public class Corrin extends AppCompatActivity {

  String [] Corrinmoves = {
          "CorrinBAir.gif",
          "CorrinBThrow.gif",
          "CorrinCounterSurge.gif",
          "CorrinCounterSurgeHit.gif",
          "CorrinDAir.gif",
          "CorrinDAirLanding.gif",
          "CorrinDashAttack.gif",
          "CorrinDashGrab.gif",
          "CorrinDragonAscent.gif",
//          "CorrinDragonLunge.png",
          "CorrinDragonLungeKick.gif",
          "CorrinDragonLungeKickBack.gif",
          "CorrinDSmash.gif",
          "CorrinDThrow.gif",
          "CorrinDTilt.gif",
          "CorrinFAir.gif",
//          "CorrinFSmash.png",
          "CorrinFSmashCharge.gif",
          "CorrinFThrow.gif",
          "CorrinFTilt.gif",
          "CorrinGrab.gif",
          "CorrinJab1.gif",
          "CorrinJab2.gif",
          "CorrinJab3.gif",
          "CorrinJabRapid.gif",
          "CorrinJabRapidEnd.gif",
          "CorrinNAir.gif",
          "CorrinPivotGrab.gif",
          "CorrinPummel.gif",
          "CorrinUAir.gif",
          "CorrinUSmash.gif",
          "CorrinUThrow.gif",
          "CorrinUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_corrin);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Corrinmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);
    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);

    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/corrin/" + Corrinmoves[position];
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