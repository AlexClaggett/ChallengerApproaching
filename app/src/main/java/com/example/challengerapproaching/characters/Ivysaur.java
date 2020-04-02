package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Ivysaur's xml
 * file when the respective button is pushed.*/

public class Ivysaur extends AppCompatActivity {

  String [] Ivysaurmoves = {
          "IvysaurBAir.gif",
          "IvysaurBThrow.gif",
          "IvysaurBulletSeedA.gif",
          "IvysaurBulletSeedG.gif",
          "IvysaurDAir.gif",
          "IvysaurDashAttack.gif",
          "IvysaurDashGrab.gif",
          "IvysaurDSmash.gif",
          "IvysaurDThrow.gif",
          "IvysaurDTilt.gif",
          "IvysaurFAir.gif",
          "IvysaurFSmash.gif",
          "IvysaurFSmashDown.gif",
          "IvysaurFSmashUp.gif",
          "IvysaurFThrow.gif",
          "IvysaurFTilt.gif",
          "IvysaurGrab.gif",
          "IvysaurJab1.gif",
          "IvysaurJab2.gif",
          "IvysaurJabRapid.gif",
          "IvysaurJabRapidEnd.gif",
          "IvysaurNAir.gif",
          "IvysaurPivotGrab.gif",
          "IvysaurPummel.gif",
          "IvysaurUAir.gif",
          "IvysaurUSmash.gif",
          "IvysaurUThrow.gif",
          "IvysaurUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ivysaur);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/pt_ivysaur/" + Ivysaurmoves[position];
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

