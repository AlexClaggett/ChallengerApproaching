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

/** This class sets the content view to Dark Pit's xml
 * file when the respective button is pushed.*/

public class DarkPit extends AppCompatActivity {

  /** Array of Dark Pit's Framedata files */
  /* default */ transient String [] darkPitMoves = {
      "DarkPitBAir.gif",
      "DarkPitBThrow.gif",
      "DarkPitDAir.gif",
      "DarkPitDashAttack.gif",
      "DarkPitDashGrab.gif",
      "DarkPitDSmash.gif",
      "DarkPitDThrow.gif",
      "DarkPitDTilt.gif",
      "DarkPitElectroshockArmA.gif",
      "DarkPitElectroshockArmG.gif",
      "DarkPitElectroshockArmHitA.gif",
      "DarkPitElectroshockArmHitG.gif",
      "DarkPitFAir.gif",
      "DarkPitFSmash.gif",
      "DarkPitFThrow.gif",
      "DarkPitFTilt.gif",
      "DarkPitGrab.gif",
      "DarkPitGuardianOrbitars.gif",
      "DarkPitJab1.gif",
      "DarkPitJab2.gif",
      "DarkPitJab3.gif",
      "DarkPitJabRapid.gif",
      "DarkPitJabRapidEnd.gif",
      "DarkPitNAir.gif",
      "DarkPitPivotGrab.gif",
      "DarkPitPummel.gif",
      "DarkPitUAir.gif",
      "DarkPitUSmash.gif",
      "DarkPitUThrow.gif",
      "DarkPitUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_dark_pit);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.DarkPitmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/dark_pit/" + darkPitMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          gifImageView.setVisibility(View.INVISIBLE);
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setVisibility(View.INVISIBLE);
      }
    });

  }
}