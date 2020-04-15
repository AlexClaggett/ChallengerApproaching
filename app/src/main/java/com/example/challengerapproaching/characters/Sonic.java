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

/** This class sets the content view to Sonic's xml
 * file when the respective button is pushed.*/

public class Sonic extends AppCompatActivity {

  String [] Sonicmoves = {
          "SonicBAir.gif",
          "SonicBThrow.gif",
          "SonicDAir.gif",
          "SonicDashAttack.gif",
          "SonicDashGrab.gif",
          "SonicDSmash.gif",
          "SonicDThrow.gif",
          "SonicDTilt.gif",
          "SonicFAir.gif",
          "SonicFSmash.gif",
          "SonicFSmashDown.gif",
          "SonicFSmashUp.gif",
          "SonicFThrow.gif",
          "SonicFTilt.gif",
          "SonicFTiltDown.gif",
          "SonicFTiltUp.gif",
          "SonicGrab.gif",
//          "SonicHomingAttack.png",
          "SonicJab1.gif",
          "SonicJab2.gif",
          "SonicJab3.gif",
          "SonicNAir.gif",
          "SonicPivotGrab.gif",
          "SonicPummel.gif",
//          "SonicSpinCharge.png",
//          "SonicSpinChargeJump.png",
//          "SonicSpinDash.png",
//          "SonicSpinDashJump.png",
//          "SonicSpringJump.png",
          "SonicUAir.gif",
          "SonicUSmash.gif",
          "SonicUThrow.gif",
          "SonicUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sonic);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Sonicmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/sonic/" + Sonicmoves[position];
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
