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

/** This class sets the content view to PacMan's xml
 * file when the respective button is pushed.*/

public class PacMan extends AppCompatActivity {

  String [] pacManMoves = {
      "PacManBAir.gif",
      "PacManBThrow.gif",
      "PacManDAir.gif",
      "PacManDashAttack.gif",
      "PacManDashGrab.gif",
      "PacManDSmash.gif",
      "PacManDThrow.gif",
      "PacManDTilt.gif",
      "PacManFAir.gif",
      "PacManFSmash.gif",
      "PacManFThrow.gif",
      "PacManFTilt.gif",
      "PacManFTiltDown.gif",
      "PacManFTiltUp.gif",
      "PacManGrab.gif",
      "PacManJab1.gif",
      "PacManJab2.gif",
      "PacManJab3.gif",
      "PacManNAir.gif",
      "PacManPivotGrab.gif",
      "PacManPowerPelletEarly.gif",
      "PacManPowerPelletLate.gif",
      "PacManPummel.gif",
      "PacManUAir.gif",
      "PacManUSmash.gif",
      "PacManUThrow.gif",
      "PacManUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_pac__man);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.PacManmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/pac_man/" + pacManMoves[position];
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