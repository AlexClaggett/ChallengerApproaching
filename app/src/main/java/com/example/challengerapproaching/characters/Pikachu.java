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

/** This class sets the content view to Pikachu's xml
 * file when the respective button is pushed.*/

public class Pikachu extends AppCompatActivity {

  /** Array of Pikachu's Framedata files */
  transient String [] pikachuMoves = {
      "PikachuBAir.gif",
      "PikachuBThrow.gif",
      "PikachuDAir.gif",
      "PikachuDashAttack.gif",
      "PikachuDashGrab.gif",
      "PikachuDSmash.gif",
      "PikachuDThrow.gif",
      "PikachuDTilt.gif",
      "PikachuFAir.gif",
      "PikachuFSmash.gif",
      "PikachuFThrow.gif",
      "PikachuFTilt.gif",
      "PikachuFTiltDown.gif",
      "PikachuFTiltUp.gif",
      "PikachuGrab.gif",
      "PikachuJab.gif",
      "PikachuNAir.gif",
      "PikachuPivotGrab.gif",
      "PikachuPummel.gif",
      "PikachuQuickAttack.gif",
      "PikachuSkullBash.gif",
      "PikachuThunderHit.gif",
      "PikachuUAir.gif",
      "PikachuUSmash.gif",
      "PikachuUThrow.gif",
      "PikachuUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_pikachu);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Pikachumoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/pikachu/" + pikachuMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });
  }
}