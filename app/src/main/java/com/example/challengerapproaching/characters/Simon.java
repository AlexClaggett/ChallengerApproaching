package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Simon's xml
 * file when the respective button is pushed.*/

public class Simon extends AppCompatActivity {

  String [] Simonmoves = {
          "SimonAxe.gif",
          "SimonBAir.gif",
          "SimonBAirDown.gif",
          "SimonBAirUp.gif",
          "SimonBThrow.gif",
//          "SimonCross.png",
          "SimonDAir.gif",
          "SimonDashAttack.gif",
          "SimonDashGrab.gif",
          "SimonDSmash.gif",
          "SimonDThrow.gif",
          "SimonDTilt1.gif",
          "SimonDTilt2.gif",
          "SimonFAir.gif",
          "SimonFAirDown.gif",
          "SimonFAirUp.gif",
          "SimonFSmash.gif",
          "SimonFSmashDown.gif",
          "SimonFSmashUp.gif",
          "SimonFThrow.gif",
          "SimonFTilt.gif",
          "SimonGrab.gif",
          "SimonJab1.gif",
          "SimonJab2.gif",
          "SimonJabRapid.gif",
          "SimonJabRapidEnd.gif",
          "SimonNAir.gif",
          "SimonPivotGrab.gif",
          "SimonPummel.gif",
          "SimonUAir.gif",
          "SimonUppercut.gif",
          "SimonUSmash.gif",
          "SimonUThrow.gif",
          "SimonUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simon);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/simon/" + Simonmoves[position];
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
