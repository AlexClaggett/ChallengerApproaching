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

/** This class sets the content view to Little Mac's xml
 * file when the respective button is pushed.*/

public class LittleMac extends AppCompatActivity {

  /** Array of LittleMac's Framedata files */
  transient String [] littleMacMoves = {
      "LittleMacBAir.gif",
      "LittleMacBThrow.gif",
      "LittleMacDAir.gif",
      "LittleMacDashAttack.gif",
      "LittleMacDashGrab.gif",
      "LittleMacDSmash.gif",
      "LittleMacDThrow.gif",
      "LittleMacDTilt.gif",
      "LittleMacFAir.gif",
      "LittleMacFSmash.gif",
      "LittleMacFSmashDown.gif",
      "LittleMacFSmashUp.gif",
      "LittleMacFThrow.gif",
      "LittleMacFTilt.gif",
      "LittleMacGrab.gif",
      "LittleMacJab1.gif",
      "LittleMacJab2.gif",
      "LittleMacJab3.gif",
      "LittleMacJabRapid.gif",
      "LittleMacJabRapidEnd.gif",
      "LittleMacJoltHaymakerA.gif",
      "LittleMacJoltHaymakerG.gif",
      "LittleMacKOPunchA.gif",
      "LittleMacKOPunchG.gif",
      "LittleMacNAir.gif",
      "LittleMacPivotGrab.gif",
      "LittleMacPummel.gif",
      "LittleMacRisingUppercut.gif",
      "LittleMacSlipCounter.gif",
      "LittleMacSlipCounterHitA.gif",
      "LittleMacSlipCounterHitG.gif",
      "LittleMacStraightLungeA.gif",
      "LittleMacStraightLungeMaxA.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_little__mac);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.LittleMacmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/little_mac/" + littleMacMoves[position];
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
