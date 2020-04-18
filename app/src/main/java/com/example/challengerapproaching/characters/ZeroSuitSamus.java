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

/** This class sets the content view to Zero Suit Samus's xml
 * file when the respective button is pushed.*/

public class ZeroSuitSamus extends AppCompatActivity {//NOPMD

  /** Array of Zero Suit Samus's Framedata files */
  /* default */ transient String [] zzsMoves = {//NOPMD
      "ZeroSuitSamusBAir.gif",
      "ZeroSuitSamusBoostKickA.gif",
      "ZeroSuitSamusBoostKickG.gif",
      "ZeroSuitSamusBThrow.gif",
      "ZeroSuitSamusDAir.gif",
      "ZeroSuitSamusDAirLanding.gif",
      "ZeroSuitSamusDashAttack.gif",
      "ZeroSuitSamusDSmash.gif",
      "ZeroSuitSamusDThrow.gif",
      "ZeroSuitSamusDTilt.gif",
      "ZeroSuitSamusFAir.gif",
      "ZeroSuitSamusFlipJumpFootstool.gif",
      "ZeroSuitSamusFlipJumpKick.gif",
      "ZeroSuitSamusFSmash.gif",
      "ZeroSuitSamusFSmashDown.gif",
      "ZeroSuitSamusFSmashUp.gif",
      "ZeroSuitSamusFThrow.gif",
      "ZeroSuitSamusFTilt.gif",
      "ZeroSuitSamusFTiltDown.gif",
      "ZeroSuitSamusFTiltUp.gif",
      "ZeroSuitSamusJab1.gif",
      "ZeroSuitSamusJab2.gif",
      "ZeroSuitSamusJab3.gif",
      "ZeroSuitSamusNAir.gif",
      "ZeroSuitSamusPlasmaWhip.gif",
      "ZeroSuitSamusPlasmaWhipUp.gif",
      "ZeroSuitSamusPummel.gif",
      "ZeroSuitSamusUAir.gif",
      "ZeroSuitSamusUSmash.gif",
      "ZeroSuitSamusUThrow.gif",
      "ZeroSuitSamusUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_zero__suit__samus);


    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.ZeroSuitSamusmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/zero_suit_samus/" + zzsMoves[position];
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
