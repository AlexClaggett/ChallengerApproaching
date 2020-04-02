package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Little Mac's xml
 * file when the respective button is pushed.*/

public class LittleMac extends AppCompatActivity {

  String [] LittleMacmoves = {
          "LittleMacBAir.gif",
          "LittleMacBThrow.gif",
          "LittleMacDAir.gif",
          "LittleMacDashAttack.gif",
          "LittleMacDashGrab.gif",
          "LittleMacDSmash.gif",
          "LittleMacDThrow.gif",
          "LittleMacDTilt.gif",
          "LittleMacFAir.gif",
          "LittleMacFSmash.gif",
          "LittleMacFSmashDown.gif",
          "LittleMacFSmashUp.gif",
          "LittleMacFThrow.gif",
          "LittleMacFTilt.gif",
          "LittleMacGrab.gif",
          "LittleMacJab1.gif",
          "LittleMacJab2.gif",
          "LittleMacJab3.gif",
          "LittleMacJabRapid.gif",
          "LittleMacJabRapidEnd.gif",
          "LittleMacJoltHaymakerA.gif",
          "LittleMacJoltHaymakerG.gif",
          "LittleMacKOPunchA.gif",
          "LittleMacKOPunchG.gif",
          "LittleMacNAir.gif",
          "LittleMacPivotGrab.gif",
          "LittleMacPummel.gif",
          "LittleMacRisingUppercut.gif",
          "LittleMacSlipCounter.gif",
          "LittleMacSlipCounterHitA.gif",
          "LittleMacSlipCounterHitG.gif",
          "LittleMacStraightLungeA.gif",
          "LittleMacStraightLungeMaxA.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_little__mac);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/little_mac/" + LittleMacmoves[position];
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
