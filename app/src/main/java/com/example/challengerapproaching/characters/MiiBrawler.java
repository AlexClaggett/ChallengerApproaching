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

/** This class sets the content view to Mii Brawler's xml
 * file when the respective button is pushed.*/

public class MiiBrawler extends AppCompatActivity {

  String [] miiBrawlerMoves = {
      "MiiBrawlerBAir.gif",
      "MiiBrawlerBThrow.gif",
      "MiiBrawlerBurningDropkick.gif",
      "MiiBrawlerCounterThrow.gif",
      "MiiBrawlerCounterThrowGrabA.gif",
      "MiiBrawlerCounterThrowGrabG.gif",
      "MiiBrawlerCounterThrowThrow.gif",
      "MiiBrawlerDAir.gif",
      "MiiBrawlerDashAttack.gif",
      "MiiBrawlerDashGrab.gif",
      "MiiBrawlerDSmash.gif",
      "MiiBrawlerDThrow.gif",
      "MiiBrawlerDTilt.gif",
      "MiiBrawlerExplodingSideKick.gif",
      "MiiBrawlerFAir.gif",
      "MiiBrawlerFeintJump.gif",
      "MiiBrawlerFeintJumpAutoKick.gif",
      "MiiBrawlerFeintJumpKick.gif",
      "MiiBrawlerFlashingMachPunch.gif",
      "MiiBrawlerFlashingMachPunchMiss.gif",
      "MiiBrawlerFSmash.gif",
      "MiiBrawlerFSmashDown.gif",
      "MiiBrawlerFSmashUp.gif",
      "MiiBrawlerFThrow.gif",
      "MiiBrawlerFTilt.gif",
      "MiiBrawlerFTiltDown.gif",
      "MiiBrawlerFTiltUp.gif",
      "MiiBrawlerGrab.gif",
      "MiiBrawlerHead-OnAssault.gif",
      "MiiBrawlerHead-OnAssaultFall.gif",
      "MiiBrawlerHead-OnAssaultLanding.gif",
      "MiiBrawlerHelicopterKickA.gif",
      "MiiBrawlerHelicopterKickG.gif",
      "MiiBrawlerJab1.gif",
      "MiiBrawlerJab2.gif",
      "MiiBrawlerJabRapid.gif",
      "MiiBrawlerJabRapidEnd.gif",
      "MiiBrawlerNAir.gif",
      "MiiBrawlerOnslaughtA.gif",
      "MiiBrawlerOnslaughtG.gif",
      "MiiBrawlerOnslaughtHitA.gif",
      "MiiBrawlerOnslaughtHitG.gif",
      "MiiBrawlerPivotGrab.gif",
      "MiiBrawlerPummel.gif",
      "MiiBrawlerSoaringAxeKickFall.png",
      "MiiBrawlerSoaringAxeKickLanding.gif",
      "MiiBrawlerSoaringAxeKickRise.gif",
      "MiiBrawlerSuplexA.gif",
      "MiiBrawlerSuplexG.gif",
      "MiiBrawlerSuplexHit.gif",
      "MiiBrawlerThrustUppercut.gif",
      "MiiBrawlerUAir.gif",
      "MiiBrawlerUSmash.gif",
      "MiiBrawlerUThrow.gif",
      "MiiBrawlerUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mii__brawler);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MiiBrawlermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/mii_brawler/" + miiBrawlerMoves[position];
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
