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

/** This class sets the content view to Joker's xml
 * file when the respective button is pushed.*/

public class Joker extends AppCompatActivity {

  //Array of Joker's Framedata files
  transient String [] jokerMoves = {
      "JokerBAir.gif",
      "JokerBAirArsene.gif",
      "JokerBThrow.gif",
      "JokerDAir.gif",
      "JokerDAirArsene.gif",
      "JokerDashAttack.gif",
      "JokerDashAttackArsene.gif",
      "JokerDashGrab.gif",
      "JokerDSmash.gif",
      "JokerDSmashArsene.gif",
      "JokerDThrow.gif",
      "JokerDTilt.gif",
      "JokerDTiltArsene.gif",
      "JokerEigaon.gif",
      "JokerEiha.gif",
      "JokerFAir.gif",
      "JokerFAirArsene.gif",
      "JokerFSmash.gif",
      "JokerFSmashArsene.gif",
      "JokerFThrow.gif",
      "JokerFTilt.gif",
      "JokerFTiltArsene.gif",
      "JokerFTiltDown.gif",
      "JokerFTiltDownArsene.gif",
      "JokerFtiltUp.gif",
      "JokerFTiltUpArsene.gif",
      "JokerGrab.gif",
      "JokerGun.gif",
      "JokerGunArsene.gif",
      "JokerGunBack.gif",
      "JokerGunBackArsene.gif",
      "JokerGunDown.gif",
      "JokerGunDownArsene.gif",
      "JokerGunForward.gif",
      "JokerGunForwardArsene.gif",
      "JokerGunJump.gif",
      "JokerGunJumpArsene.gif",
      "JokerGunUp.gif",
      "JokerGunUpArsene.gif",
      "JokerJab1.gif",
      "JokerJab1Arsene.gif",
      "JokerJab2.gif",
      "JokerJab2Arsene.gif",
      "JokerJab3.gif",
      "JokerJab3Arsene.gif",
      "JokerMakarakarn.gif",
      "JokerNAir.gif",
      "JokerNAirArsene.gif",
      "JokerPivotGrab.gif",
      "JokerPummel.gif",
      "JokerRebelsGuardAttack.gif",
      "JokerTetrakarn.gif",
      "JokerTetrakarn_Makarakarn.gif",
      "JokerUAir.gif",
      "JokerUAirArsene.gif",
      "JokerUSmash.gif",
      "JokerUSmashArsene.gif",
      "JokerUThrow.gif",
      "JokerUTilt.gif",
      "JokerUTiltArsene.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_joker);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Jokermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/joker/" + jokerMoves[position];
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
