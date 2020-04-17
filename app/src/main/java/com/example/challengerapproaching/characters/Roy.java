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

/** This class sets the content view to Roy's xml
 * file when the respective button is pushed.*/

public class Roy extends AppCompatActivity {

  transient String [] royMoves = {
      "RoyBAir.gif",
      "RoyBlazerA.gif",
      "RoyBlazerG.gif",
      "RoyBThrow.gif",
      "RoyCounter.gif",
      "RoyCounterHit.gif",
      "RoyDAir.gif",
      "RoyDashAttack.gif",
      "RoyDashGrab.gif",
      "RoyDoubledEdgeDance4Side.gif",
      "RoyDoubleEdgedDance1.gif",
      "RoyDoubleEdgedDance2Side.gif",
      "RoyDoubleEdgedDance2Up.gif",
      "RoyDoubleEdgedDance3Down.gif",
      "RoyDoubleEdgedDance3Side.gif",
      "RoyDoubleEdgedDance3Up.gif",
      "RoyDoubleEdgedDance4Down.gif",
      "RoyDoubleEdgedDance4Up.gif",
      "RoyDSmash.gif",
      "RoyDThrow.gif",
      "RoyDTilt.gif",
      "RoyFAir.gif",
      "RoyFlareBlade.gif",
      "RoyFlareBladeMax.gif",
      "RoyFSmash.gif",
      "RoyFThrow.gif",
      "RoyFTilt.gif",
      "RoyGrab.gif",
      "RoyJab.gif",
      "RoyNAir.gif",
      "RoyPivotGrab.gif",
      "RoyPummel.gif",
      "RoyUAir.gif",
      "RoyUSmash.gif",
      "RoyUThrow.gif",
      "RoyUTilt.gif",
  };


  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_roy);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Roymoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/roy/" + royMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

  }
}
