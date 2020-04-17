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

/** This class sets the content view to Mewtwo's xml
 * file when the respective button is pushed.*/

public class Mewtwo extends AppCompatActivity {

  /** Array of Mewtwo's Framedata files */
  transient String [] mewtwoMoves = {
      "MewtwoBAir.gif",
      "MewtwoBThrow.gif",
      "MewtwoConfusion.gif",
      "MewtwoDAir.gif",
      "MewtwoDashAttack.gif",
      "MewtwoDashGrab.gif",
      "MewtwoDisable.gif",
      "MewtwoDSmash.gif",
      "MewtwoDThrow.gif",
      "MewtwoDTilt.gif",
      "MewtwoFAir.gif",
      "MewtwoFSmash.gif",
      "MewtwoFSmashDown.gif",
      "MewtwoFSmashUp.gif",
      "MewtwoFThrow.gif",
      "MewtwoFTilt.gif",
      "MewtwoFTiltDown.gif",
      "MewtwoFTiltUp.gif",
      "MewtwoGrab.gif",
      "MewtwoJab.gif",
      "MewtwoJabRapid.gif",
      "MewtwoJabRapidEnd.gif",
      "MewtwoNAir.gif",
      "MewtwoPivotGrab.gif",
      "MewtwoPummel.gif",
      "MewtwoUAir.gif",
      "MewtwoUSmash.gif",
      "MewtwoUThrow.gif",
      "MewtwoUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_mewtwo);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Mewtwomoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/mewtwo/" + mewtwoMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          gifImageView.setVisibility(View.INVISIBLE);
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });

  }
}

