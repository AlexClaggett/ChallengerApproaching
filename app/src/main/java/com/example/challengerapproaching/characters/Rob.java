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

/** This class sets the content view to ROB's xml
 * file when the respective button is pushed.*/

public class Rob extends AppCompatActivity {

  String [] robMoves = {
      "ROBArmRotor.gif",
      "ROBArmRotorEnd.gif",
      "ROBBAir.gif",
      "ROBBThrow.gif",
      "ROBDAir.gif",
      "ROBDashAttack.gif",
      "ROBDashGrab.gif",
      "ROBDSmash.gif",
      "ROBDThrow.gif",
      "ROBDTilt.gif",
      "ROBFAir.gif",
      "ROBFSmash.gif",
      "ROBFSmashDown.gif",
      "ROBFSmashUp.gif",
      "ROBFThrow.gif",
      "ROBFTilt.gif",
      "ROBFTiltDown.gif",
      "ROBFTiltUp.gif",
      "ROBGrab.gif",
      "ROBJab1.gif",
      "ROBJab2.gif",
      "ROBNAir.gif",
      "ROBPivotGrab.gif",
      "ROBPummel.gif",
      "ROBRoboBeam.gif",
      "ROBUAir.gif",
      "ROBUSmash.gif",
      "ROBUThrow.gif",
      "ROBUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rob);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.ROBmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/rob/" + robMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
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
