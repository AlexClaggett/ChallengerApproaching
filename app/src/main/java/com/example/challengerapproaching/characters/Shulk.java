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

/** This class sets the content view to Shulk's xml
 * file when the respective button is pushed.*/

public class Shulk extends AppCompatActivity {

  String [] Shulkmoves = {
          "ShulkAirSlash1.gif",
          "ShulkAirSlash2.gif",
          "ShulkBackSlash.gif",
          "ShulkBackSlashStart.gif",
          "ShulkBAir.gif",
          "ShulkBThrow.gif",
          "ShulkDAir.gif",
          "ShulkDashAttack.gif",
          "ShulkDashGrab.gif",
          "ShulkDSmash.gif",
          "ShulkDThrow.gif",
          "ShulkDTilt.gif",
          "ShulkFAir.gif",
          "ShulkFSmash.gif",
          "ShulkFSmashDown.gif",
          "ShulkFSmashUp.gif",
          "ShulkFThrow.gif",
          "ShulkFTilt.gif",
          "ShulkGrab.gif",
          "ShulkJab1.gif",
          "ShulkJab2.gif",
          "ShulkJab3.gif",
//          "monado.png",
//          "monadodir.png",
          "ShulkNAir.gif",
          "ShulkPivotGrab.gif",
          "ShulkPummel.gif",
          "ShulkUAir.gif",
          "ShulkUSmash.gif",
          "ShulkUThrow.gif",
          "ShulkUTilt.gif",
          "ShulkVision.gif",
          "ShulkVisionForward.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shulk);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Shulkmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/shulk/" + Shulkmoves[position];
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
