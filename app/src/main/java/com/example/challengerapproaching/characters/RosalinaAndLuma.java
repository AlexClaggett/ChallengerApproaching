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

/** This class sets the content view to Rosalina and Luma's xml
 * file when the respective button is pushed.*/

public class RosalinaAndLuma extends AppCompatActivity {

  /** Array of Rosalina's Framedata files. */
  /* default */ transient String [] rosalinaMoves = {
      "RosalinaBAir.gif",
      "RosalinaBThrow.gif",
      "RosalinaDAir.gif",
      "RosalinaDashAttack.gif",
      "RosalinaDashGrab.gif",
      "RosalinaDSmash.gif",
      "RosalinaDThrow.gif",
      "RosalinaDTilt.gif",
      "RosalinaFAir.gif",
      "RosalinaFSmash.gif",
      "RosalinaFSmashDown.gif",
      "RosalinaFSmashUp.gif",
      "RosalinaFThrow.gif",
      "RosalinaFTilt.gif",
      "RosalinaGrab.gif",
      "RosalinaGravitationalPull.gif",
      "RosalinaJab1.gif",
      "RosalinaJab2.gif",
      "RosalinaJab3.gif",
      "RosalinaJabRapid.gif",
      "RosalinaJabRapidEnd.gif",
      "RosalinaNAir.gif",
      "RosalinaPivotGrab.gif",
      "RosalinaPummel.gif",
      "RosalinaUAir.gif",
      "RosalinaUSmash.gif",
      "RosalinaUThrow.gif",
      "RosalinaUTilt.gif",
      "LumaBAir.gif",
      "LumaDAir.gif",
      "LumaDashAttack.gif",
      "LumaDSmash.gif",
      "LumaDTilt.gif",
      "LumaFAir.gif",
      "LumaFSmash.gif",
      "LumaFSmashDown.gif",
      "LumaFSmashUp.gif",
      "LumaFTilt.gif",
      "LumaJab1.gif",
      "LumaJab2.gif",
      "LumaJab3.gif",
      "LumaJabRapid.gif",
      "LumaJabRapidEnd.gif",
      "LumaLumaShot.gif",
      "LumaNAir.gif",
      "LumaUAir.gif",
      "LumaUSmash.gif",
      "LumaUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_rosalina_and__luma);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Rosalinamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view,
                                 final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/rosalina_and_luma/"
            + rosalinaMoves[position];
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
