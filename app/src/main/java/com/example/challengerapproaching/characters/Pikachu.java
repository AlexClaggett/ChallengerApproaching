package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Pikachu's xml
 * file when the respective button is pushed.*/

public class Pikachu extends AppCompatActivity {

  String [] Pikachumoves = {
          "PikachuBAir.gif",
          "PikachuBThrow.gif",
          "PikachuDAir.gif",
          "PikachuDashAttack.gif",
          "PikachuDashGrab.gif",
          "PikachuDSmash.gif",
          "PikachuDThrow.gif",
          "PikachuDTilt.gif",
          "PikachuFAir.gif",
          "PikachuFSmash.gif",
          "PikachuFThrow.gif",
          "PikachuFTilt.gif",
          "PikachuFTiltDown.gif",
          "PikachuFTiltUp.gif",
          "PikachuGrab.gif",
          "PikachuJab.gif",
          "PikachuNAir.gif",
          "PikachuPivotGrab.gif",
          "PikachuPummel.gif",
          "PikachuQuickAttack.gif",
          "PikachuSkullBash.gif",
          "PikachuThunderHit.gif",
          "PikachuUAir.gif",
          "PikachuUSmash.gif",
          "PikachuUThrow.gif",
          "PikachuUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pikachu);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/pikachu/" + Pikachumoves[position];
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