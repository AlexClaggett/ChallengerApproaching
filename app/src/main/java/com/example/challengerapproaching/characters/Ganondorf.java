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

/** This class sets the content view to Ganondorf's xml
 * file when the respective button is pushed.*/

public class Ganondorf extends AppCompatActivity {//NOPMD

  /** Array of Ganondorf's Framedata files */
  /* default */ transient String [] ganondorfMoves = {//NOPMD
      "GanondorfBAir.gif",
      "GanondorfBThrow.gif",
      "GanondorfDAir.gif",
      "GanondorfDarkDive.gif",
      "GanondorfDarkDiveCatch.gif",
      "GanondorfDashAttack.gif",
      "GanondorfDashGrab.gif",
      "GanondorfDSmash.gif",
      "GanondorfDThrow.gif",
      "GanondorfDTilt.gif",
      "GanondorfFAir.gif",
      "GanondorfFlameChoke.gif",
      "GanondorfFlameChokeA.gif",
      "GanondorfFlameChokeG.gif",
      "GanondorfFSmash.gif",
      "GanondorfFThrow.gif",
      "GanondorfFTilt.gif",
      "GanondorfGrab.gif",
      "GanondorfJab.gif",
      "GanondorfNAir.gif",
      "GanondorfPivotGrab.gif",
      "GanondorfPummel.gif",
      "GanondorfUAir.gif",
      "GanondorfUSmash.gif",
      "GanondorfUThrow.gif",
      "GanondorfUTilt.gif",
      "GanondorfWarlockPunchA.gif",
      "GanondorfWarlockPunchG.gif",
      "GanondorfWarlockPunchRA.gif",
      "GanondorfWarlockPunchRG.gif",
      "GanondorfWizardsFootA.gif",
      "GanondorfWizardsFootALand.gif",
      "GanondorfWizardsFootG.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_ganondorf);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Ganondorfmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/ganondorf/" + ganondorfMoves[position];
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

