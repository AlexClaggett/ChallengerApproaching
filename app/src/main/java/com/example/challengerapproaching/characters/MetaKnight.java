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

/** This class sets the content view to MetaKnight's xml
 * file when the respective button is pushed.*/

public class MetaKnight extends AppCompatActivity {//NOPMD

  /** Array of MetaKnight's Framedata files */
  /* default */ transient String [] metaKnightMoves = {//NOPMD
      "MetaKnightBAir.gif",
      "MetaKnightBThrow.gif",
      "MetaKnightDAir.gif",
      "MetaKnightDashAttack.gif",
      "MetaKnightDashGrab.gif",
      "MetaKnightDimensionalCapeAirBack.gif",
      "MetaKnightDimensionalCapeAirForward.gif",
      "MetaKnightDimensionalCapeGroundBack.gif",
      "MetaKnightDimensionalCapeGroundForward.gif",
      "MetaKnightDrillRush.gif",
      "MetaKnightDrillRushEnd.gif",
      "MetaKnightDSmash.gif",
      "MetaKnightDThrow.gif",
      "MetaKnightDTilt.gif",
      "MetaKnightFAir.gif",
      "MetaKnightFSmash.gif",
      "MetaKnightFThrow.gif",
      "MetaKnightFTilt1.gif",
      "MetaKnightFTilt2.gif",
      "MetaKnightFTilt3.gif",
      "MetaKnightGrab.gif",
      "MetaKnightJabRapid.gif",
      "MetaKnightJabRapidEnd.gif",
      "MetaKnightMachTornado.gif",
      "MetaKnightNAir.gif",
      "MetaKnightPivotGrab.gif",
      "MetaKnightPummel.gif",
      "MetaKnightShuttleLoopA.gif",
      "MetaKnightShuttleLoopG.gif",
      "MetaKnightUAir.gif",
      "MetaKnightUSmash.gif",
      "MetaKnightUThrow.gif",
      "MetaKnightUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_meta__knight);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MetaKnightmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/meta_knight/" + metaKnightMoves[position];
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

