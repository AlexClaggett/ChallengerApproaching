package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Jigglypuff's xml
 * file when the respective button is pushed.*/

public class Jigglypuff extends AppCompatActivity {

  String [] Jigglypuffmoves = {
          "JigglypuffBAir.gif",
          "JigglypuffBThrow.gif",
          "JigglypuffDAir.gif",
          "JigglypuffDashAttack.gif",
          "JigglypuffDashGrab.gif",
          "JigglypuffDSmash.gif",
          "JigglypuffDThrow.gif",
          "JigglypuffDTilt.gif",
          "JigglypuffFAir.gif",
          "JigglypuffFSmash.gif",
          "JigglypuffFThrow.gif",
          "JigglypuffFTilt.gif",
          "JigglypuffFTiltDown.gif",
          "JigglypuffFTiltUp.gif",
          "JigglypuffGrab.gif",
          "JigglypuffJab1.gif",
          "JigglypuffJab2.gif",
          "JigglypuffNAir.gif",
          "JigglypuffPivotGrab.gif",
          "JigglypuffPound.gif",
          "JigglypuffPummel.gif",
          "JigglypuffRest.gif",
//          "JigglypuffRolloutA.png",
//          "JigglypuffRolloutG.png",
          "JigglypuffSing.gif",
          "JigglypuffUAir.gif",
          "JigglypuffUSmash.gif",
          "JigglypuffUThrow.gif",
          "JigglypuffUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_jigglypuff);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/jigglypuff/" + Jigglypuffmoves[position];
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
