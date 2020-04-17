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

/** This class sets the content view to Ike's xml
 * file when the respective button is pushed.*/

public class Ike extends AppCompatActivity {

  //Array of Ike's Framedata files
  transient String [] ikeMoves = {
      "IkeAetherA.gif",
      "IkeAetherFall.gif",
      "IkeAetherG.gif",
      "IkeAetherLanding.gif",
      "IkeAetherSword.gif",
      "IkeBAir.gif",
      "IkeBThrow.gif",
      "IkeCounter.gif",
      "IkeCounterHit.gif",
      "IkeDAir.gif",
      "IkeDashAttack.gif",
      "IkeDashGrab.gif",
      "IkeDSmash.gif",
      "IkeDThrow.gif",
      "IkeDTilt.gif",
      "IkeEruption.gif",
      "IkeEruptionMax.gif",
      "IkeEruptionMid.gif",
      "IkeFAir.gif",
      "IkeFSmash.gif",
      "IkeFThrow.gif",
      "IkeFTilt.gif",
      "IkeFTiltDown.gif",
      "IkeFTiltUp.gif",
      "IkeGrab.gif",
      "IkeJab1.gif",
      "IkeJab2.gif",
      "IkeJab3.gif",
      "IkeNAir.gif",
      "IkePivotGrab.gif",
      "IkePummel.gif",
      "IkeQuickDraw.gif",
      "IkeUAir.gif",
      "IkeUSmash.gif",
      "IkeUThrow.gif",
      "IkeUTilt.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_ike);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Ikemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/ike/" + ikeMoves[position];
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
