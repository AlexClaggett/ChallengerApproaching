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

/** This class sets the content view to Ivysaur's xml
 * file when the respective button is pushed.*/

public class Ivysaur extends AppCompatActivity {

  String [] ivysaurMoves = {
      "IvysaurBAir.gif",
      "IvysaurBThrow.gif",
      "IvysaurBulletSeedA.gif",
      "IvysaurBulletSeedG.gif",
      "IvysaurDAir.gif",
      "IvysaurDashAttack.gif",
      "IvysaurDashGrab.gif",
      "IvysaurDSmash.gif",
      "IvysaurDThrow.gif",
      "IvysaurDTilt.gif",
      "IvysaurFAir.gif",
      "IvysaurFSmash.gif",
      "IvysaurFSmashDown.gif",
      "IvysaurFSmashUp.gif",
      "IvysaurFThrow.gif",
      "IvysaurFTilt.gif",
      "IvysaurGrab.gif",
      "IvysaurJab1.gif",
      "IvysaurJab2.gif",
      "IvysaurJabRapid.gif",
      "IvysaurJabRapidEnd.gif",
      "IvysaurNAir.gif",
      "IvysaurPivotGrab.gif",
      "IvysaurPummel.gif",
      "IvysaurUAir.gif",
      "IvysaurUSmash.gif",
      "IvysaurUThrow.gif",
      "IvysaurUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_ivysaur);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Ivysaurmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/pt_ivysaur/" + ivysaurMoves[position];
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

