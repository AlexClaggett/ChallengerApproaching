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

/** This class sets the content view to Chrom's xml
 * file when the respective button is pushed.*/

public class Chrom extends AppCompatActivity {//NOPMD

  /** Array of Chrom's Framedata files */
  /* default */ transient String [] chromMoves = {//NOPMD
      "ChromBAir.gif",
      "ChromBThrow.gif",
      "ChromCounter.gif",
      "ChromCounterHit.gif",
      "ChromDAir.gif",
      "ChromDashAttack.gif",
      "ChromDashGrab.gif",
      "ChromDoubleEdgedDance1.gif",
      "ChromDoubleEdgedDance2.gif",
      "ChromDoubleEdgedDance2Up.gif",
      "ChromDoubleEdgedDance3.gif",
      "ChromDoubleEdgedDance3Down.gif",
      "ChromDoubleEdgedDance3Up.gif",
      "ChromDoubleEdgedDance4.gif",
      "ChromDoubleEdgedDance4Down.gif",
      "ChromDoubleEdgedDance4Up.gif",
      "ChromDSmash.gif",
      "ChromDThrow.gif",
      "ChromDTilt.gif",
      "ChromFAir.gif",
      "ChromFlareBlade.gif",
      "ChromFlareBladeMax.gif",
      "ChromFSmash.gif",
      "ChromFThrow.gif",
      "ChromFTilt.gif",
      "CHromGrab.gif",
      "ChromJab.gif",
      "ChromNAir.gif",
      "ChromPivotGrab.gif",
      "ChromPummel.gif",
      "ChromSoaringSlash.gif",
      "ChromSoaringSlashDescent.gif",
      "ChromSoaringSlashLanding.gif",
      "ChromUAir.gif",
      "ChromUSmash.gif",
      "ChromUThrow.gif",
      "ChromUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_chrom);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Chrommoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/chrom/" + chromMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          gifImageView.setVisibility(View.INVISIBLE);
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setVisibility(View.INVISIBLE);
      }
    });

  }
}