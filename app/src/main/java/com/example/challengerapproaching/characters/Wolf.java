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

/** This class sets the content view to Wolf's xml
 * file when the respective button is pushed.*/

public class Wolf extends AppCompatActivity { //NOPMD

  /** Array of Wolf's Framedata files. */
  /* default */ transient String [] wolfMoves = {//NOPMD
      "WolfBAir.gif",
      "WolfBlaster.gif",
      "WolfBThrow.gif",
      "WolfDAir.gif",
      "WolfDashAttack.gif",
      "WolfDashGrab.gif",
      "WolfDSmash.gif",
      "WolfDThrow.gif",
      "WolfDTilt.gif",
      "WolfFAir.gif",
      "WolfFireWolf.gif",
      "WolfFSmash.gif",
      "WolfFThrow.gif",
      "WolfFTilt.gif",
      "WolfFTiltDown.gif",
      "WolfFTiltUp.gif",
      "WolfGrab.gif",
      "WolfJab1.gif",
      "WolfJab2.gif",
      "WolfJab3.gif",
      "WolfNAir.gif",
      "WolfPivotGrab.gif",
      "WolfPummel.gif",
      "WolfReflector.gif",
      "WolfReflectorStart.gif",
      "WolfUAir.gif",
      "WolfUSmash.gif",
      "WolfUThrow.gif",
      "WolfUTilt.gif",
      "WolfWolfFlash.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_wolf);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Wolfmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent,
                                 final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/wolf/" + wolfMoves[position];
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