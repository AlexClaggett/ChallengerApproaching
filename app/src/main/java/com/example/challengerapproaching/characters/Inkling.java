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

/** This class sets the content view to Inkling's xml
 * file when the respective button is pushed.*/

public class Inkling extends AppCompatActivity {

  String [] Inklingmoves = {
          "InklingBAir.gif",
          "InklingBThrow.gif",
          "InklingDAir.gif",
          "InklingDashAttack.gif",
          "InklingDashGrab.gif",
          "InklingDSmash.gif",
          "InklingDThrow.gif",
          "InklingDTilt.gif",
          "InklingFAir.gif",
          "InklingFSmash.gif",
          "InklingFThrow.gif",
          "InklingFTilt.gif",
          "InklingGrab.gif",
          "InklingJab1.gif",
          "InklingJab2.gif",
          "InklingJab3.gif",
          "InklingJabRapid.gif",
          "InklingJabRapidEnd.gif",
          "InklingNAir.gif",
          "InklingPivotGrab.gif",
          "InklingPummel.gif",
          "InklingSplatBomb.gif",
          "InklingSplatBombExplosion.gif",
//          "InklingSplatRollerA.png",
//          "InklingSplatRollerG.png",
//          "InklingSplatRollerNoInk.png",
          "InklingSuperJump.gif",
          "InklingUAir.gif",
          "InklingUSmash.gif",
          "InklingUSmashNoInk.gif",
          "InklingUThrow.gif",
          "InklingUTilt_.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_inkling);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Inklingmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/inkling/" + Inklingmoves[position];
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

