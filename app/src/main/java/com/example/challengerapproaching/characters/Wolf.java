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

/** This class sets the content view to Wolf's xml
 * file when the respective button is pushed.*/

public class Wolf extends AppCompatActivity {

  String [] Wolfmoves = {
          "WolfBAir.gif",
          "WolfBlaster.gif",
          "WolfBThrow.gif",
          "WolfDAir.gif",
          "WolfDashAttack.gif",
          "WolfDashGrab.gif",
          "WolfDSmash.gif",
          "WolfDThrow.gif",
          "WolfDTilt.gif",
          "WolfFAir.gif",
          "WolfFireWolf.gif",
          "WolfFSmash.gif",
          "WolfFThrow.gif",
          "WolfFTilt.gif",
          "WolfFTiltDown.gif",
          "WolfFTiltUp.gif",
          "WolfGrab.gif",
          "WolfJab1.gif",
          "WolfJab2.gif",
          "WolfJab3.gif",
          "WolfNAir.gif",
          "WolfPivotGrab.gif",
          "WolfPummel.gif",
          "WolfReflector.gif",
          "WolfReflectorStart.gif",
          "WolfUAir.gif",
          "WolfUSmash.gif",
          "WolfUThrow.gif",
          "WolfUTilt.gif",
          "WolfWolfFlash.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wolf);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Wolfmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/wolf/" + Wolfmoves[position];
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