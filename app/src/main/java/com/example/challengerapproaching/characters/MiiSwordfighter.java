package com.example.challengerapproaching.characters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;
import java.io.IOException;
import java.io.InputStream;

/** This class sets the content view to Mii Swordfighter's xml
 * file when the respective button is pushed.*/

public class MiiSwordfighter extends AppCompatActivity {

  /** Array of MiiSwordfighter's Framedata files. */
  /* default */ transient String [] miiFightMoves = {
      "MiiSwordfighterAirborneAssault.gif",
      "MiiSwordfighterAirborneAssaultHit.gif",
      "MiiSwordfighterBAir.gif",
      "MiiSwordfighterBladeCounter.gif",
      "MiiSwordfighterBladeCounterHit.gif",
      "MiiSwordfighterBlurringBlade.gif",
      "MiiSwordfighterBThrow.gif",
      "MiiSwordfighterChakram.png",
      "MiiSwordfighterDAir.gif",
      "MiiSwordfighterDashAttack.gif",
      "MiiSwordfighterDashGrab.gif",
      "MiiSwordfighterDSmash.gif",
      "MiiSwordfighterDThrow.gif",
      "MiiSwordfighterDTilt.gif",
      "MiiSwordfighterFAir.gif",
      "MiiSwordfighterFSmash.gif",
      "MiiSwordfighterFThrow.gif",
      "MiiSwordfighterFTilt.gif",
      "MiiSwordfighterGaleStabHit.gif",
      "MiiSwordfighterGrab.gif",
      "MiiSwordfighterHerosSpinA.gif",
      "MiiSwordfighterHerosSpinG.gif",
      "MiiSwordfighterJab1.gif",
      "MiiSwordfighterJab2.gif",
      "MiiSwordfighterJab3.gif",
      "MiiSwordfighterNAir.gif",
      "MiiSwordfighterPivotGrab.gif",
      "MiiSwordfighterPowerThrustA.gif",
      "MiiSwordfighterPowerThrustALanding.gif",
      "MiiSwordfighterPowerThrustG.gif",
      "MiiSwordfighterPummel.gif",
      "MiiSwordfighterReversalSlash.gif",
      "MiiSwordfighterSkywardSlashDash.gif",
      "MiiSwordfighterStoneScabbard.gif",
      "MiiSwordfighterStoneScabbardLanding.gif",
      "MiiSwordfighterUAir.gif",
      "MiiSwordfighterUSmash.gif",
      "MiiSwordfighterUThrow.gif",
      "MiiSwordfighterUTilt.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_mii__swordfighter);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MiiSwordfightermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view,
                                 final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/mii_swordfighte/"
            + miiFightMoves[position];
        final ImageView imageView = findViewById(R.id.imageView3);
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            imageView.setVisibility(View.INVISIBLE);
          }
        } else {
          imageView.setVisibility(View.INVISIBLE);
          try {
            gifImageView.setGifImageUrl(toUrl);
            gifImageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            gifImageView.setVisibility(View.INVISIBLE);
          }
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setVisibility(View.INVISIBLE);
        final ImageView imageView = findViewById(R.id.imageView3);
        imageView.setVisibility(View.INVISIBLE);
      }
    });

  }
}
