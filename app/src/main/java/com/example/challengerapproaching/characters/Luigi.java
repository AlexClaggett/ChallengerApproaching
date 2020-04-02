package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Luigi's xml
 * file when the respective button is pushed.*/

public class Luigi extends AppCompatActivity {

  String [] Luigimoves = {
          "LuigiBAir.gif",
          "LuigiBThrow.gif",
          "LuigiCycloneA.gif",
          "LuigiCycloneG.gif",
          "LuigiDAir.gif",
          "LuigiDashAttack.gif",
          "LuigiDashGrab.gif",
          "LuigiDSmash.gif",
          "LuigiDTaunt.png",
          "LuigiDThrow.gif",
          "LuigiDTilt.gif",
          "LuigiFAir.gif",
          "LuigiFireball.gif",
          "LuigiFSmash.gif",
          "LuigiFSmashDown.gif",
          "LuigiFSmashUp.gif",
          "LuigiFThrow.gif",
          "LuigiFTilt.gif",
          "LuigiFTiltDown.gif",
          "LuigiFTiltUp.gif",
          "LuigiGrab.gif",
          "LuigiGreenMissile.gif",
          "LuigiGreenMissileMisfire.gif",
          "LuigiJab1.gif",
          "LuigiJab2.gif",
          "LuigiJab3.gif",
          "LuigiNAir.gif",
          "LuigiPivotGrab.gif",
          "LuigiPummel.gif",
          "LuigiSuperJumpPunchA.gif",
          "LuigiSuperJumpPunchG.gif",
          "LuigiUAir.gif",
          "LuigiUSmash.gif",
          "LuigiUThrow.gif",
          "LuigiUTilt.gif",
//          "LuigiZAirHitbox.png"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_luigi);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/luigi/" + Luigimoves[position];
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
