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

/** This class sets the content view to Robin's xml
 * file when the respective button is pushed.*/

public class Robin extends AppCompatActivity {

  /** Array of Robin's Framedata files */
  transient String [] robinMoves = {
      "RobinBAirBronze.gif",
      "RobinBAirLevin.gif",
      "RobinBThrow.gif",
      "RobinDAirBronze.gif",
      "RobinDAirLevin.gif",
      "RobinDashAttack.gif",
      "RobinDashGrab.gif",
      "RobinDSmashBronze.gif",
      "RobinDSmashLevin.gif",
      "RobinDThrow.gif",
      "RobinDTilt.gif",
      "RobinFAirBronze.gif",
      "RobinFAirLevin.gif",
      "RobinFSmashBronze.gif",
      "RobinFSmashLevin.gif",
      "RobinFThrow.gif",
      "RobinFTilt.gif",
      "RobinGrab.gif",
      "RobinJab1.gif",
      "RobinJab2.gif",
      "RobinJab3.gif",
      "RobinJabRapid.gif",
      "RobinJabRapidEnd.gif",
      "RobinNAirBronze.gif",
      "RobinNAirLevin.gif",
      "RobinNosferatu.gif",
      "RobinNosferatuAir.gif",
      "RobinPivotGrab.gif",
      "RobinPummel.gif",
      "RobinUAirBronze.gif",
      "RobinUAirLevin.gif",
      "RobinUSmashBronze.gif",
      "RobinUSmashLevin.gif",
      "RobinUThrow.gif",
      "RobinUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_robin);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Robinmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/robin/" + robinMoves[position];
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
