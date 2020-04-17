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

/** This class sets the content view to Cloud's xml
 * file when the respective button is pushed.*/

public class Cloud extends AppCompatActivity {

  /** Array of Cloud's Framedata files */
  transient String [] cloudMoves = {
      "CloudBAir.gif",
      "CloudBladeBeam.gif",
      "CloudBladeBeamLimit.gif",
      "CloudBThrow.gif",
      "CloudClimhazzard.gif",
      "CloudClimhazzardFall.gif",
      "CloudClimhazzardLanding.gif",
      "CloudClimhazzardLimit.gif",
      "CloudCrossSlash1Left.gif",
      "CloudCrossSlash1Right.gif",
      "CloudCrossSlash2Left.gif",
      "CloudCrossSlash2Right.gif",
      "CloudCrossSlash3Left.gif",
      "CloudCrossSlash3Right.gif",
      "CloudCrossSlashLimitLeft.gif",
      "CloudCrossSlashLimitRight.gif",
      "CloudDAir.gif",
      "CloudDashAttack.gif",
      "CloudDashGrab.gif",
      "CloudDSmash.gif",
      "CloudDThrow.gif",
      "CloudDTilt.gif",
      "CloudFAir.gif",
      "CloudFinishingTouchA.gif",
      "CloudFinishingTouchG.gif",
      "CloudFSmash.gif",
      "CloudFThrow.gif",
      "CloudFTilt.gif",
      "CloudGrab.gif",
      "CloudJab1.gif",
      "CloudJab2.gif",
      "CloudJab3.gif",
      "CloudNAir.gif",
      "CloudPivotGrab.gif",
      "CloudPummel.gif",
      "CloudUAir.gif",
      "CloudUSmash.gif",
      "CloudUThrow.gif",
      "CloudUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_cloud);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Cloudmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/cloud/" + cloudMoves[position];
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
