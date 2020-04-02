package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Greninja's xml
 * file when the respective button is pushed.*/

public class Greninja extends AppCompatActivity {

  String [] Greninjamoves = {
          "GreninjaBAir.gif",
          "GreninjaBThrow.gif",
          "GreninjaDAir.gif",
          "GreninjaDashAttack.gif",
          "GreninjaDashGrab.gif",
          "GreninjaDSmash.gif",
          "GreninjaDThrow.gif",
          "GreninjaDTilt.gif",
          "GreninjaFAir.gif",
          "GreninjaFSmash.gif",
          "GreninjaFThrow.gif",
          "GreninjaFTilt.gif",
          "GreninjaFTiltDown.gif",
          "GreninjaFTiltUp.gif",
          "GreninjaGrab.gif",
          "GreninjaJab1.gif",
          "GreninjaJab2.gif",
          "GreninjaJab3.gif",
          "GreninjaJabRapid.gif",
          "GreninjaJabRapidEnd.gif",
          "GreninjaNAir.gif",
          "GreninjaPivotGrab.gif",
          "GreninjaPummel.gif",
          "GreninjaShadowSneakB.gif",
          "GreninjaShadowSneakF.gif",
          "GreninjaSubstitute.gif",
          "GreninjaSubstituteHitDiagonalDown.gif",
          "GreninjaSubstituteHitDiagonalUp.gif",
          "GreninjaSubstituteHitDown.gif",
          "GreninjaSubstituteHitSide.gif",
          "GreninjaSubstituteHitUp.gif",
          "GreninjaUAir.gif",
          "GreninjaUSmash.gif",
          "GreninjaUThrow.gif",
          "GreninjaUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_greninja);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/greninja/" + Greninjamoves[position];
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
