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

/** This class sets the content view to Piranha Plant's xml
 * file when the respective button is pushed.*/

public class PiranhaPlant extends AppCompatActivity {

  //Array of Piranha Plant's Framedata files
  transient String [] piranhaPlantMoves = {
      "PiranhaPlantBAir.gif",
      "PiranhaPlantBThrow.gif",
      "PiranhaPlantDAir.gif",
      "PiranhaPlantDashAttack.gif",
      "PiranhaPlantDashGrab.gif",
      "PiranhaPlantDSmash.gif",
      "PiranhaPlantDThrow.gif",
      "PiranhaPlantDTilt.gif",
      "PiranhaPlantFAir.gif",
      "PiranhaPlantFootstoolAttack.gif",
      "PiranhaPlantFSmash.gif",
      "PiranhaPlantFThrow.gif",
      "PiranhaPlantFTilt1.gif",
      "PiranhaPlantFTilt2.gif",
      "PiranhaPlantGrab.gif",
      "PiranhaPlantJab1.gif",
      "PiranhaPlantJab2.gif",
      "PiranhaPlantJab3.gif",
      "PiranhaPlantJabRapid.gif",
      "PiranhaPlantJabRapidEnd.gif",
      "PiranhaPlantLong-StemStrike.gif",
      "PiranhaPlantNAir.gif",
      "PiranhaPlantPiranhacopter.gif",
      "PiranhaPlantPivotGrab.gif",
      "PiranhaPlantPoisonBreathMax.gif",
      "PiranhaPlantPoisonBreathMin.gif",
      "PiranhaPlantPtooie.gif",
      "PiranhaPlantPummel.gif",
      "PiranhaPlantUAir.gif",
      "PiranhaPlantUSmash.gif",
      "PiranhaPlantUThrow.gif",
      "PiranhaPlantUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_piranha__plant);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.PiranhaPlantmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/piranha_plant/" + piranhaPlantMoves[position];
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
