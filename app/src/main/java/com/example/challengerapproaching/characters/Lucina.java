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

/** This class sets the content view to Lucina's xml
 * file when the respective button is pushed.*/

public class Lucina extends AppCompatActivity {

  String [] lucinaMoves = {
      "LucinaBAir.gif",
      "LucinaBThrow.gif",
      "LucinaCounter.gif",
      "LucinaCounterHit.gif",
      "LucinaDAir.gif",
      "LucinaDancingBlade1.gif",
      "LucinaDancingBlade2.gif",
      "LucinaDancingBlade2Up.gif",
      "LucinaDancingBlade3.gif",
      "LucinaDancingBlade3Down.gif",
      "LucinaDancingBlade3Up.gif",
      "LucinaDancingBlade4.gif",
      "LucinaDancingBlade4Down.gif",
      "LucinaDancingBlade4Up.gif",
      "LucinaDashAttack.gif",
      "LucinaDashGrab.gif",
      "LucinaDolphinSlashA.gif",
      "LucinaDolphinSlashG.gif",
      "LucinaDSmash.gif",
      "LucinaDThrow.gif",
      "LucinaDTilt.gif",
      "LucinaFAir.gif",
      "LucinaFSmash.gif",
      "LucinaFThrow.gif",
      "LucinaFTilt.gif",
      "LucinaGrab.gif",
      "LucinaJab1.gif",
      "LucinaJab2.gif",
      "LucinaNAir.gif",
      "LucinaPivotGrab.gif",
      "LucinaPummel.gif",
      "LucinaShieldbreaker.gif",
      "LucinaShieldbreakerDown.gif",
      "LucinaShieldbreakerUp.gif",
      "LucinaUAir.gif",
      "LucinaUSmash.gif",
      "LucinaUThrow.gif",
      "LucinaUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lucina);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Lucinamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/lucina/" + lucinaMoves[position];
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
