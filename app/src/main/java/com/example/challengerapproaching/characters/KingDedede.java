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

/** This class sets the content view to King Dedede's xml
 * file when the respective button is pushed.*/

public class KingDedede extends AppCompatActivity {

  String [] kingDededeMoves = {
      "KingDededeBAir.gif",
      "KingDededeBThrow.gif",
      "KingDededeDAir.gif",
      "KingDededeDashAttack.gif",
      "KingDededeDashGrab.gif",
      "KingDededeDSmash.gif",
      "KingDededeDThrow.gif",
      "KingDededeDTilt.gif",
      "KingDededeFAir.gif",
      "KingDededeFSmash.gif",
      "KingDededeFthrow.gif",
      "KingDededeFTilt.gif",
      "KingDededeGordo.gif",
      "KingDededeGordoThrow.gif",
      "KingDededeGordoWall.gif",
      "KingDededeGrab.gif",
      "KingDededeInhale.gif",
      "KingDededeInhaleStart.gif",
      "KingDededeJab1.gif",
      "KingDededeJab2.gif",
      "KingDededeJabRapid.gif",
      "KingDededeJabRapidEnd.gif",
      "KingDededeJet20HammerAMax.gif",
      "KingDededeJet20HammerGMax.gif",
      "KingDededeJetHammerA.gif",
      "KingDededeJetHammerG.gif",
      "KingDededeNAir.gif",
      "KingDededePivotGrab.gif",
      "KingDededePummel.gif",
      "KingDededeSuperDededeJump1.gif",
      "KingDededeSuperDededeJumpLanding.gif",
      "KingDededeUAir.gif",
      "KingDededeUSmash.gif",
      "KingDededeUThrow.gif",
      "KingDededeUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_king__dedede);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.KingDededemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/king_dedede/" + kingDededeMoves[position];
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
