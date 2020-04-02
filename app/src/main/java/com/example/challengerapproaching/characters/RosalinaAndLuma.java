package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Rosalina and Luma's xml
 * file when the respective button is pushed.*/

public class RosalinaAndLuma extends AppCompatActivity {

  String [] Rosalinamoves = {
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
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rosalina_and__luma);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/rosalina_and_luma/" + Rosalinamoves[position];
        try {
          gifImageView.setGifImageURL(toURL);
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
