package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Wii Fit Trainer's xml
 * file when the respective button is pushed.*/

public class WiiFitTrainer extends AppCompatActivity {

  String [] WiiFitTrainermoves = {
//          "Soccerball.png",
          "WiiFitTrainerBAir.gif",
          "WiiFitTrainerBThrow.gif",
          "WiiFitTrainerDAir.gif",
          "WiiFitTrainerDashAttack.gif",
          "WiiFitTrainerDashGrab.gif",
          "WiiFitTrainerDSmash.gif",
          "WiiFitTrainerDThrow.gif",
          "WiiFitTrainerDTilt.gif",
          "WiiFitTrainerFAir.gif",
          "WiiFitTrainerFSmash.gif",
          "WiiFitTrainerFThrow.gif",
          "WiiFitTrainerFTilt.gif",
          "WiiFitTrainerGrab.gif",
          "WiiFitTrainerHeader.gif",
          "WiiFitTrainerJab1.gif",
          "WiiFitTrainerJab2.gif",
          "WiiFitTrainerJab3.gif",
          "WiiFitTrainerNAir.gif",
          "WiiFitTrainerPivotGrab.gif",
          "WiiFitTrainerPummel.gif",
//          "WiiFitTrainerSunSalutationMax.png",
//          "WiiFitTrainerSunSalutationMin.png",
          "WiiFitTrainerSuperHoop.gif",
          "WiiFitTrainerUAir.gif",
          "WiiFitTrainerUSmash.gif",
          "WiiFitTrainerUThrow.gif",
          "WiiFitTrainerUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wii__fit__trainer);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/wii_fit_trainer/" + WiiFitTrainermoves[position];
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
