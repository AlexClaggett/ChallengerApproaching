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
import java.net.MalformedURLException;
import java.net.URL;

/** This class sets the content view to Captain Falcon's xml
 * file when the respective button is pushed.*/

public class CaptainFalcon extends AppCompatActivity {

  String [] CaptainFalconmoves2 = {
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
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_captain_falcon);


    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.CaptainFalconmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/captain_falcon/" + CaptainFalconmoves2[position];
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