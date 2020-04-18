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

/** This class sets the content view to Ridley's xml
 * file when the respective button is pushed.*/

public class Ridley extends AppCompatActivity {

  /** Array of Ridley's Framedata files */
  /* default */ transient String [] ridleyMoves = {
      "RidleyBAir.gif",
      "RidleyBThrow.gif",
      "RidleyDAir.gif",
      "RidleyDashAttack.gif",
      "RidleyDashGrab.gif",
      "RidleyDSmash.gif",
      "RidleyDThrow.gif",
      "RidleyDTilt.gif",
      "RidleyFAir.gif",
      "RidleyFSmash.gif",
      "RidleyFThrow.gif",
      "RidleyFTilt.gif",
      "RidleyFTiltDown.gif",
      "RidleyFTiltUp.gif",
      "RidleyGrab.gif",
      "RidleyJab1.gif",
      "RidleyJab2.gif",
      "RidleyJab3.gif",
      "RidleyJabRapid.gif",
      "RidleyJabRapidEnd.gif",
      "RidleyNAir.gif",
      "RidleyPivotGrab.gif",
      "RidleyPummel.gif",
      "RidleySkewer.gif",
      "RidleySpacePirateRushA.gif",
      "RidleySpacePirateRushDrag.gif",
      "RidleySpacePirateRushDragStart.gif",
      "RidleySpacePirateRushG.gif",
      "RidleyUAir.gif",
      "RidleyUSmash.gif",
      "RidleyUThrow.gif",
      "RidleyUTilt.gif",
      "RidleyWingBlitzBack.gif",
      "RidleyWingBlitzDown.gif",
      "RidleyWingBlitzDownLanding.gif",
      "RidleyWingBlitzForward.gif",
      "RidleyWingBlitzUp.gif",
  };


  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_ridley);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Ridleymoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/ridley/" + ridleyMoves[position];
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
