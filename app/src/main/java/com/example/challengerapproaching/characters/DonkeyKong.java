package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Donkey Kong's xml
 * file when the respective button is pushed.*/

public class DonkeyKong extends AppCompatActivity {

  String [] DonkeyKongmoves = {
          "DonkeyKongBAir.gif",
          "DonkeyKongBThrow.gif",
          "DonkeyKongCargoBThrow.gif",
          "DonkeyKongCargoDThrow.gif",
          "DonkeyKongCargoFThrow.gif",
          "DonkeyKongCargoUThrow.gif",
          "DonkeyKongDAir.gif",
          "DonkeyKongDashAttack.gif",
          "DonkeyKongDashGrab.gif",
          "DonkeyKongDSmash.gif",
          "DonkeyKongDThrow.gif",
          "DonkeyKongDTilt.gif",
          "DonkeyKongFAir.gif",
          "DonkeyKongFSmash.gif",
          "DonkeyKongFTilt.gif",
          "DonkeyKongGiantPunchA.gif",
          "DonkeyKongGiantPunchAMax.gif",
          "DonkeyKongGiantPunchG.gif",
          "DonkeyKongGiantPunchGMax.gif",
          "DonkeyKongGrab.gif",
          "DonkeyKongHandSlapA.gif",
          "DonkeyKongHandSlapG.gif",
          "DonkeyKongHeadbuttA.gif",
          "DonkeyKongHeadbuttG.gif",
          "DonkeyKongJab1.gif",
          "DonkeyKongJab2.gif",
          "DonkeyKongNAir.gif",
          "DonkeyKongPivotGrab.gif",
          "DonkeyKongPummel.gif",
          "DonkeyKongSpinningKongA.gif",
          "DonkeyKongSpinningKongG.gif",
          "DonkeyKongUAir.gif",
          "DonkeyKongUSmash.gif",
          "DonkeyKongUThrow.gif",
          "DonkeyKongUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_donkey__kong);
    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/donkey_kong/" + DonkeyKongmoves[position];
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
