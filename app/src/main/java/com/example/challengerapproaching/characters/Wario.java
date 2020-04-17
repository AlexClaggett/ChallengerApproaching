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

/** This class sets the content view to Wario's xml
 * file when the respective button is pushed.*/

public class Wario extends AppCompatActivity {

  String [] warioMoves = {
      "WarioBAir.gif",
      "WarioBikeDrive.gif",
      "WarioBikeTurn.gif",
      "WarioBikeWheelie.gif",
      "WarioBThrow.gif",
      "WarioChomp.gif",
      "WarioChompBite.gif",
      "WarioChompBomb.gif",
      "WarioCorkscrew.gif",
      "WarioDAir.gif",
      "WarioDashAttack.gif",
      "WarioDashGrab.gif",
      "WarioDSmash.gif",
      "WarioDThrow.gif",
      "WarioDTilt.gif",
      "WarioFAir.gif",
      "WarioFSmash.gif",
      "WarioFThrow.gif",
      "WarioFTilt.gif",
      "WarioFTiltDown.gif",
      "WarioFTiltUp.gif",
      "WarioGrab.gif",
      "WarioJab1.gif",
      "WarioJab2.gif",
      "WarioNAir.gif",
      "WarioPivotGrab.gif",
      "WarioPummel.gif",
      "WarioUAir.gif",
      "WarioUSmash.gif",
      "WarioUThrow.gif",
      "WarioUTilt.gif",
      "WarioWarioWaftFull.gif",
      "WarioWarioWaftHalf.gif",
      "WarioWarioWaftLow.gif",
      "WarioWarioWaftToot.gif",
  };


  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_wario);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Wariomoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/wario/" + warioMoves[position];
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