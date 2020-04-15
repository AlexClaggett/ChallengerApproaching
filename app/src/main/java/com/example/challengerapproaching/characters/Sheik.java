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

/** This class sets the content view to Sheik's xml
 * file when the respective button is pushed.*/

public class Sheik extends AppCompatActivity {

  String [] Sheikmoves = {
          "SheikBAir.gif",
          "SheikBouncingFish.gif",
          "SheikBThrow.gif",
          "SheikDAir.gif",
          "SheikDAirLanding.gif",
          "SheikDashAttack.gif",
          "SheikDashGrab.gif",
          "SheikDSmash.gif",
          "SheikDThrow.gif",
          "SheikDTilt.gif",
          "SheikFAir.gif",
          "SheikFSmash.gif",
          "SheikFThrow.gif",
          "SheikFTilt.gif",
          "SheikGrab.gif",
          "SheikJab1.gif",
          "SheikJab2.gif",
          "SheikJabRapid.gif",
          "SheikJabRapidEnd.gif",
          "SheikNAir.gif",
//          "SheikNeedle.png",
          "SheikPivotGrab.gif",
          "SheikPummel.gif",
          "SheikUAir.gif",
          "SheikUSmash.gif",
          "SheikUThrow.gif",
          "SheikUTilt.gif",
          "SheikVanishA.gif",
          "SheikVanishG.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sheik);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Sheikmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/sheik/" + Sheikmoves[position];
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
