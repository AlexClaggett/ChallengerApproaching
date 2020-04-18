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

/** This class sets the content view to Marth's xml
 * file when the respective button is pushed.*/

public class Marth extends AppCompatActivity {//NOPMD

  /** Array of Marth's Framedata files */
  /* default */ transient String [] marthMoves = {//NOPMD
      "MarthBAir.gif",
      "MarthBThrow.gif",
      "MarthCounter.gif",
      "MarthCounterHit.gif",
      "MarthDAir.gif",
      "MarthDancingBlade1.gif",
      "MarthDancingBlade2.gif",
      "MarthDancingBlade2Up.gif",
      "MarthDancingBlade3.gif",
      "MarthDancingBlade3Down.gif",
      "MarthDancingBlade3Up.gif",
      "MarthDancingBlade4.gif",
      "MarthDancingBlade4Down.gif",
      "MarthDancingBlade4Up.gif",
      "MarthDashAttack.gif",
      "MarthDashGrab.gif",
      "MarthDolphinSlashG.gif",
      "MarthDSmash.gif",
      "MarthDThrow.gif",
      "MarthDTilt.gif",
      "MarthFAir.gif",
      "MarthFSmash.gif",
      "MarthFThrow.gif",
      "MarthFTilt.gif",
      "MarthGrab.gif",
      "MarthJab1.gif",
      "MarthJab2.gif",
      "MarthNAir.gif",
      "MarthPivotGrab.gif",
      "MarthPummel.gif",
      "MarthShieldbreaker.gif",
      "MarthShieldbreakerDown.gif",
      "MarthShieldbreakerUp.gif",
      "MarthUAir.gif",
      "MarthUSmash.gif",
      "MarthUThrow.gif",
      "MarthUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_marth);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Marthmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/marth/" + marthMoves[position];
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

