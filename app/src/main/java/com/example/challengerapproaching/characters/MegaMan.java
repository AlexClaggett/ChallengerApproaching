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

/** This class sets the content view to MegaMan's xml
 * file when the respective button is pushed.*/

public class MegaMan extends AppCompatActivity {

  String [] MegaManmoves = {
          "MegaManBAir.gif",
          "MegaManBThrow.gif",
//          "MegaManCrashBomber.png",
          "MegaManCrashBomberExplosion.gif",
          "MegaManDAir.gif",
          "MegaManDashAttack.gif",
          "MegaManDashGrab.gif",
          "MegaManDSmash.gif",
          "MegaManDThrow.gif",
          "MegaManDTilt.gif",
          "MegaManFAir.gif",
          "MegaManFSmashMaximum.gif",
          "MegaManFSmashMinimum.gif",
          "MegaManFThrow.gif",
          "MegaManGrab.gif",
          "MegaManJab.gif",
          "MegaManLeafShield.gif",
          "MegaManLeafShieldFly.gif",
          "MegaManNAir.gif",
          "MegaManPivotGrab.gif",
          "MegaManPummel.gif",
          "MegaManUAir.gif",
          "MegaManUSmash.gif",
          "MegaManUThrow.gif",
          "MegaManUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mega__man);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MegaManmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/mega_man/" + MegaManmoves[position];
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

