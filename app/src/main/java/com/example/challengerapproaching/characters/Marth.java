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

/** This class sets the content view to Marth's xml
 * file when the respective button is pushed.*/

public class Marth extends AppCompatActivity {

  String [] marthMoves = {
      "MarthBAir.gif",
      "MarthBThrow.gif",
      "MarthCounter.gif",
      "MarthCounterHit.gif",
      "MarthDAir.gif",
      "MarthDancingBlade1.gif",
      "MarthDancingBlade2.gif",
      "MarthDancingBlade2Up.gif",
      "MarthDancingBlade3.gif",
      "MarthDancingBlade3Down.gif",
      "MarthDancingBlade3Up.gif",
      "MarthDancingBlade4.gif",
      "MarthDancingBlade4Down.gif",
      "MarthDancingBlade4Up.gif",
      "MarthDashAttack.gif",
      "MarthDashGrab.gif",
      "MarthDolphinSlashG.gif",
      "MarthDSmash.gif",
      "MarthDThrow.gif",
      "MarthDTilt.gif",
      "MarthFAir.gif",
      "MarthFSmash.gif",
      "MarthFThrow.gif",
      "MarthFTilt.gif",
      "MarthGrab.gif",
      "MarthJab1.gif",
      "MarthJab2.gif",
      "MarthNAir.gif",
      "MarthPivotGrab.gif",
      "MarthPummel.gif",
      "MarthShieldbreaker.gif",
      "MarthShieldbreakerDown.gif",
      "MarthShieldbreakerUp.gif",
      "MarthUAir.gif",
      "MarthUSmash.gif",
      "MarthUThrow.gif",
      "MarthUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_marth);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Marthmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/marth/" + marthMoves[position];
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

