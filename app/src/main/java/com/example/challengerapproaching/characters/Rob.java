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

  /** Array of Rob's Framedata files */
  transient String [] robMoves = {
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
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_rob);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.ROBmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/rob/" + robMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });

  }
}
