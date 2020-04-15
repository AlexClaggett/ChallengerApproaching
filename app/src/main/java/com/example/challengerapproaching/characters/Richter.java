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

/** This class sets the content view to Richter's xml
 * file when the respective button is pushed.*/

public class Richter extends AppCompatActivity {

  String [] Richtermoves = {
          "RichterAxe.gif",
          "RichterBAir.gif",
          "RichterBAirDown.gif",
          "RichterBAirUp.gif",
          "RichterBThrow.gif",
//          "RichterCross.png",
          "RichterDAir.gif",
          "RichterDashAttack.gif",
          "RichterDashGrab.gif",
          "RichterDSmash.gif",
          "RichterDThrow.gif",
          "RichterDTilt1.gif",
          "RichterDTilt2.gif",
          "RichterFAir.gif",
          "RichterFAirDown.gif",
          "RichterFAirUp.gif",
          "RichterFSmash.gif",
          "RichterFSmashDown.gif",
          "RichterFSmashUp.gif",
          "RichterFThrow.gif",
          "RichterFTilt.gif",
          "RichterGrab.gif",
          "RichterJab1.gif",
          "RichterJab2.gif",
          "RichterJabRapid.gif",
          "RichterJabRapidEnd.gif",
          "RichterNAir.gif",
          "RichterPivotGrab.gif",
          "RichterPummel.gif",
          "RichterUAir.gif",
          "RichterUppercut.gif",
          "RichterUSmash.gif",
          "RichterUThrow.gif",
          "RichterUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_richter);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Richtermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/richter/" + Richtermoves[position];
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
