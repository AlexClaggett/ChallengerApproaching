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

/** This class sets the content view to Greninja's xml
 * file when the respective button is pushed.*/

public class Greninja extends AppCompatActivity {

  /** Array of Greninja's Framedata files */
  transient String [] greninjaMoves = {
      "GreninjaBAir.gif",
      "GreninjaBThrow.gif",
      "GreninjaDAir.gif",
      "GreninjaDashAttack.gif",
      "GreninjaDashGrab.gif",
      "GreninjaDSmash.gif",
      "GreninjaDThrow.gif",
      "GreninjaDTilt.gif",
      "GreninjaFAir.gif",
      "GreninjaFSmash.gif",
      "GreninjaFThrow.gif",
      "GreninjaFTilt.gif",
      "GreninjaFTiltDown.gif",
      "GreninjaFTiltUp.gif",
      "GreninjaGrab.gif",
      "GreninjaJab1.gif",
      "GreninjaJab2.gif",
      "GreninjaJab3.gif",
      "GreninjaJabRapid.gif",
      "GreninjaJabRapidEnd.gif",
      "GreninjaNAir.gif",
      "GreninjaPivotGrab.gif",
      "GreninjaPummel.gif",
      "GreninjaShadowSneakB.gif",
      "GreninjaShadowSneakF.gif",
      "GreninjaSubstitute.gif",
      "GreninjaSubstituteHitDiagonalDown.gif",
      "GreninjaSubstituteHitDiagonalUp.gif",
      "GreninjaSubstituteHitDown.gif",
      "GreninjaSubstituteHitSide.gif",
      "GreninjaSubstituteHitUp.gif",
      "GreninjaUAir.gif",
      "GreninjaUSmash.gif",
      "GreninjaUThrow.gif",
      "GreninjaUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_greninja);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Greninjamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/greninja/" + greninjaMoves[position];
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
