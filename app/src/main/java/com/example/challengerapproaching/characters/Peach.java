package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Peach's xml
 * file when the respective button is pushed.*/

public class Peach extends AppCompatActivity {

  String [] Peachmoves = {
          "PeachBAir.gif",
          "PeachBThrow.gif",
          "PeachDAir.gif",
          "PeachDashAttack.gif",
          "PeachDashGrab.gif",
          "PeachDSmash.gif",
          "PeachDThrow.gif",
          "PeachDTilt.gif",
          "PeachFAir.gif",
          "PeachFSmashFryingPan.gif",
          "PeachFSmashGolfClub.gif",
          "PeachFSmashTennisRacket.gif",
          "PeachFThrow.gif",
          "PeachFTilt.gif",
          "PeachGrab.gif",
          "PeachJab1.gif",
          "PeachJab2.gif",
          "PeachNAir.gif",
//          "PeachPeachBomber.png",
          "PeachPeachBomberHit.gif",
          "PeachPeachParasol.gif",
          "PeachPeachParasolFall.gif",
          "PeachPivotGrab.gif",
          "PeachPummel.gif",
          "PeachUAir.gif",
          "PeachUSmash.gif",
          "PeachUThrow.gif",
          "PeachUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_peach);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/peach/" + Peachmoves[position];
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
