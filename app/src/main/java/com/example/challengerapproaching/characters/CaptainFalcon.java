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

/** This class sets the content view to Captain Falcon's xml
 * file when the respective button is pushed.*/

public class CaptainFalcon extends AppCompatActivity {

  /** Array of Captain Falcon's Framedata files */
  transient String [] cptnFalconMoves = {
      "CaptainFalconBAir.gif",
      "CaptainFalconBThrow.gif",
      "CaptainFalconDAir.gif",
      "CaptainFalconDashAttack.gif",
      "CaptainFalconDashGrab.gif",
      "CaptainFalconDSmash.gif",
      "CaptainFalconDThrow.gif",
      "CaptainFalconDTilt.gif",
      "CaptainFalconFAir.gif",
      "CaptainFalconFalconDiveA.gif",
      "CaptainFalconFalconDiveCatch.gif",
      "CaptainFalconFalconDiveG.gif",
      "CaptainFalconFalconKickA.gif",
      "CaptainFalconFalconKickALanding.gif",
      "CaptainFalconFalconKickG.gif",
      "CaptainFalconFalconPunchA.gif",
      "CaptainFalconFalconPunchAR.gif",
      "CaptainFalconFalconPunchG.gif",
      "CaptainFalconFalconPunchGR.gif",
      "CaptainFalconFSmash.gif",
      "CaptainFalconFSmashDown.gif",
      "CaptainFalconFSmashUp.gif",
      "CaptainFalconFThrow.gif",
      "CaptainFalconFTilt.gif",
      "CaptainFalconGrab.gif",
      "CaptainFalconJab1.gif",
      "CaptainFalconJab2.gif",
      "CaptainFalconJab3.gif",
      "CaptainFalconJabRapid.gif",
      "CaptainFalconJabRapidEnd.gif",
      "CaptainFalconNAir.gif",
      "CaptainFalconPivotGrab.gif",
      "CaptainFalconPummel.gif",
      "CaptainFalconRaptorBoostA.gif",
      "CaptainFalconRaptorBoostG.gif",
      "CaptainFalconRaptorBoostHitA.gif",
      "CaptainFalconRaptorBoostHitG.gif",
      "CaptainFalconUAir.gif",
      "CaptainFalconUSmash.gif",
      "CaptainFalconUThrow.gif",
      "CaptainFalconUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_captain_falcon);


    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.CaptainFalconmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/captain_falcon/" + cptnFalconMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          gifImageView.setVisibility(View.INVISIBLE);
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });
  }
}