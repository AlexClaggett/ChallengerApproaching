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

/** This class sets the content view to Pit's xml
 * file when the respective button is pushed.*/

public class Pit extends AppCompatActivity {

  /** Array of Pit's Framedata files */
  transient String [] pitMoves = {
      "PitBAir.gif",
      "PitBThrow.gif",
      "PitDAir.gif",
      "PitDashAttack.gif",
      "PitDashGrab.gif",
      "PitDSmash.gif",
      "PitDThrow.gif",
      "PitDTilt.gif",
      "PitFAir.gif",
      "PitFSmash.gif",
      "PitFThrow.gif",
      "PitFTilt.gif",
      "PitGrab.gif",
      "PitGuardianOrbitars.gif",
      "PitJab1.gif",
      "PitJab2.gif",
      "PitJab3.gif",
      "PitJabRapid.gif",
      "PitJabRapidEnd.gif",
      "PitNAir.gif",
      "PitPivotGrab.gif",
      "PitPummel.gif",
      "PitUAir.gif",
      "PitUpperdashArmA.gif",
      "PitUpperdashArmHitA.gif",
      "PitUpperdashArmHitG.gif",
      "PitUpperdashkArmG.gif",
      "PitUSmash.gif",
      "PitUThrow.gif",
      "PitUTilt.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_pit);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Pitmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/pit/" + pitMoves[position];
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