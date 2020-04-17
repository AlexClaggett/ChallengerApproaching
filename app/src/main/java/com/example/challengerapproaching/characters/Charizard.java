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

/** This class sets the content view to Charizard's xml
 * file when the respective button is pushed.*/

public class Charizard extends AppCompatActivity {

  /** Array of Charizard's Framedata files */
  transient String [] charizardMoves = {
      "charitardBAir.gif",
      "charitardBThrow.gif",
      "charitardDAir.gif",
      "charitardDashAttack.gif",
      "charitardDashGrab.gif",
      "charitardDSmash.gif",
      "charitardDThrow.gif",
      "charitardDTilt.gif",
      "charitardFAir.gif",
      "charitardFlareBlitz.gif",
      "charitardFly.gif",
      "charitardFSmash.gif",
      "charitardFThrow.gif",
      "charitardFTilt.gif",
      "charitardFTiltDown.gif",
      "charitardFTiltUp.gif",
      "charitardGrab.gif",
      "charitardJab1.gif",
      "charitardJab2.gif",
      "charitardJab3.gif",
      "charitardNAir.gif",
      "charitardPivotGrab.gif",
      "charitardPummel.gif",
      "charitardUAir.gif",
      "charitardUSmash.gif",
      "charitardUThrow.gif",
      "charitardUTilt.gif"
  };


  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_charizard);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Charizardmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/pt_charizard/" + charizardMoves[position];
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