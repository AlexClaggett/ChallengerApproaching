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


/** This class sets the content view to Bayonetta's xml
 * file when the respective button is pushed.*/

public class Bayonetta extends AppCompatActivity {

  //Array of Bayonetta's Framedata files
  transient String [] bayonettaMoves = {
      "BayonettaAfterburnerKickDown.gif",
      "BayonettaAfterburnerKickLanding.gif",
      "BayonettaAfterburnerKickUp.gif",
      "BayonettaBAir.gif",
      "BayonettaBThrow.gif",
      "BayonettaDAir.gif",
      "BayonettaDAirLanding.gif",
      "BayonettaDashAttack.gif",
      "BayonettaDashGrab.gif",
      "BayonettaDSmash.gif",
      "BayonettaDSmashStomp.gif",
      "BayonettaDThrow.gif",
      "BayonettaDTilt.gif",
      "BayonettaFAir2.gif",
      "BayonettaFAir201.gif",
      "BayonettaFAir3.gif",
      "BayonettaFSmash.gif",
      "BayonettaFThrow.gif",
      "BayonettaFTilt1.gif",
      "BayonettaFTilt2.gif",
      "BayonettaFTilt3.gif",
      "BayonettaGrab.gif",
      "BayonettaHeelSlide.gif",
      "BayonettaHeelSlideEnd.gif",
      "BayonettaJab1.gif",
      "BayonettaJab2.gif",
      "BayonettaJab3.gif",
      "BayonettaJabRapid.gif",
      "BayonettaJabRapidEnd.gif",
      "BayonettaNAir.gif",
      "BayonettaPivotGrab.gif",
      "BayonettaPummel.gif",
      "BayonettaUAir.gif",
      "BayonettaUSmash.gif",
      "BayonettaUThrow.gif",
      "BayonettaUTilt.gif",
      "BayonettaWitchTime.gif",
      "BayonettaWitchTwistA.gif",
      "BayonettaWitchTwistG.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_bayonetta);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Bayonettamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);
    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);

    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/bayonetta/" + bayonettaMoves[position];
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
