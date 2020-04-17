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

/** This class sets the content view to Palutena's xml
 * file when the respective button is pushed.*/

public class Palutena extends AppCompatActivity {

  //Array of Palutena's Framedata files
  transient String [] palutenaMoves = {
      "PalutenaAutoreticle.gif",
      "PalutenaBAir.gif",
      "PalutenaBThrow.gif",
      "PalutenaCounter.gif",
      "PalutenaCounterHit.gif",
      "PalutenaDAir.gif",
      "PalutenaDashAttack.gif",
      "PalutenaDashGrab.gif",
      "PalutenaDSmash.gif",
      "PalutenaDThrow.gif",
      "PalutenaDTilt.gif",
      "PalutenaExplosiveFlame.gif",
      "PalutenaFAir.gif",
      "PalutenaFSmash.gif",
      "PalutenaFThrow.gif",
      "PalutenaFTilt.gif",
      "PalutenaGrab.gif",
      "PalutenaJab1.gif",
      "PalutenaJabRapid.gif",
      "PalutenaJabRapidEnd.gif",
      "PalutenaNAir.gif",
      "PalutenaPivotGrab.gif",
      "PalutenaPummel.gif",
      "PalutenaReflectBarrier.gif",
      "PalutenaUAir.gif",
      "PalutenaUSmash.gif",
      "PalutenaUThrow.gif",
      "PalutenaUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_palutena);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Palutenamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/palutena/" + palutenaMoves[position];
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
