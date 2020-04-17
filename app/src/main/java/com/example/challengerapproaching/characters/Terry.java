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

/** This class sets the content view to Terry's xml
 * file when the respective button is pushed.*/

public class Terry extends AppCompatActivity {

  /** Array of Terry's Framedata files */
  transient String [] terryMoves = {
      "TerryBAir.gif",
      "TerryBThrow.gif",
      "TerryBurningKnuckleAirStrong.gif",
      "TerryBurningKnuckleAirStrongInput.gif",
      "TerryBurningKnuckleAirWeak.gif",
      "TerryBurningKnuckleAirWeakInput.gif",
      "TerryBurningKnuckleGroundStrong.gif",
      "TerryBurningKnuckleGroundStrongInput.gif",
      "TerryBurningKnuckleGroundWeak.gif",
      "TerryBurningKnuckleGroundWeakInput.gif",
      "TerryBusterWolf.gif",
      "TerryBusterWolfThrow.gif",
      "TerryCrackShootStrong.gif",
      "TerryCrackShootWeak.gif",
      "TerryDAir.gif",
      "TerryDashAttack.gif",
      "TerryDashGrab.gif",
      "TerryDSmash.gif",
      "TerryDThrow.gif",
      "TerryDTilt.gif",
      "TerryFAir.gif",
      "TerryFSmash.gif",
      "TerryFThrow.gif",
      "TerryFTilt.gif",
      "TerryGrab.gif",
      "TerryJab1.gif",
      "TerryJab2.gif",
      "TerryJab3.gif",
      "TerryNAir.gif",
      "TerryPivotGrab.gif",
      "TerryPowerDunkRiseStrong.gif",
      "TerryPowerDunkRiseStrongInput.gif",
      "TerryPowerDunkRiseWeak.gif",
      "TerryPowerDunkRiseWeakInput.gif",
      "TerryPowerDunkSpike.gif",
      "TerryPowerDunkStrong.gif",
      "TerryPowerDunkWeak.gif",
      "TerryPowerGeyser.gif",
      "TerryPowerWaveAStrong.gif",
      "TerryPowerWaveAWeak.gif",
      "TerryPowerWaveGStrong.gif",
      "TerryPowerWaveGWeak.gif",
      "TerryPummel.gif",
      "TerryRisingTackle.gif",
      "TerryRisingTackleCharged.gif",
      "TerryUAir.gif",
      "TerryUSmash.gif",
      "TerryUThrow.gif",
      "TerryUTilt.gif",
      "TerryUTiltBullshit.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_terry);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Terrymoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/terry/" + terryMoves[position];
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
