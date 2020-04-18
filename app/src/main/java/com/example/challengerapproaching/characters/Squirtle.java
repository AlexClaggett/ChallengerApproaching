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

/** This class sets the content view to Squirtle's xml
 * file when the respective button is pushed.*/

public class Squirtle extends AppCompatActivity {

  /** Array of Squirtle's Framedata files */
  /* default */ transient String [] squirtleMoves = {
      "SquirtleBAir.gif",
      "SquirtleBAirLanding.gif",
      "SquirtleBThrow.gif",
      "SquirtleDAir.gif",
      "SquirtleDashAttack.gif",
      "SquirtleDashGrab.gif",
      "SquirtleDSmash.gif",
      "SquirtleDThrow.gif",
      "SquirtleDTilt.gif",
      "SquirtleFAir.gif",
      "SquirtleFSmash.gif",
      "SquirtleFSmashDown.gif",
      "SquirtleFSmashUp.gif",
      "SquirtleFThrow.gif",
      "SquirtleFTilt.gif",
      "SquirtleFTiltDown.gif",
      "SquirtleFTiltUp.gif",
      "SquirtleGrab.gif",
      "SquirtleJab1.gif",
      "SquirtleJab2.gif",
      "SquirtleJab3.gif",
      "SquirtleNAir.gif",
      "SquirtlePivotGrab.gif",
      "SquirtlePummel.gif",
      "SquirtleUAir.gif",
      "SquirtleUSmash.gif",
      "SquirtleUThrow.gif",
      "SquirtleUTilt.gif",
      "SquirtleWaterfall.gif",
      "SquirtleWithdraw.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_squirtle);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Squirtlemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/pt_squirtle/" + squirtleMoves[position];
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
