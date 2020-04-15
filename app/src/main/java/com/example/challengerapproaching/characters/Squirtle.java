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

/** This class sets the content view to Squirtle's xml
 * file when the respective button is pushed.*/

public class Squirtle extends AppCompatActivity {

  String [] Squirtlemoves = {
          "SquirtleBAir.gif",
          "SquirtleBAirLanding.gif",
          "SquirtleBThrow.gif",
          "SquirtleDAir.gif",
          "SquirtleDashAttack.gif",
          "SquirtleDashGrab.gif",
          "SquirtleDSmash.gif",
          "SquirtleDThrow.gif",
          "SquirtleDTilt.gif",
          "SquirtleFAir.gif",
          "SquirtleFSmash.gif",
          "SquirtleFSmashDown.gif",
          "SquirtleFSmashUp.gif",
          "SquirtleFThrow.gif",
          "SquirtleFTilt.gif",
          "SquirtleFTiltDown.gif",
          "SquirtleFTiltUp.gif",
          "SquirtleGrab.gif",
          "SquirtleJab1.gif",
          "SquirtleJab2.gif",
          "SquirtleJab3.gif",
          "SquirtleNAir.gif",
          "SquirtlePivotGrab.gif",
          "SquirtlePummel.gif",
          "SquirtleUAir.gif",
          "SquirtleUSmash.gif",
          "SquirtleUThrow.gif",
          "SquirtleUTilt.gif",
          "SquirtleWaterfall.gif",
          "SquirtleWithdraw.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_squirtle);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Squirtlemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/pt_squirtle/" + Squirtlemoves[position];
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
