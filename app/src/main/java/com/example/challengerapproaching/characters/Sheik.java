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

/** This class sets the content view to Sheik's xml
 * file when the respective button is pushed.*/

public class Sheik extends AppCompatActivity { //NOPMD

  /** Array of Sheik's Framedata files. */
  /* default */ transient String [] sheikMoves = {//NOPMD
      "SheikBAir.gif",
      "SheikBouncingFish.gif",
      "SheikBThrow.gif",
      "SheikDAir.gif",
      "SheikDAirLanding.gif",
      "SheikDashAttack.gif",
      "SheikDashGrab.gif",
      "SheikDSmash.gif",
      "SheikDThrow.gif",
      "SheikDTilt.gif",
      "SheikFAir.gif",
      "SheikFSmash.gif",
      "SheikFThrow.gif",
      "SheikFTilt.gif",
      "SheikGrab.gif",
      "SheikJab1.gif",
      "SheikJab2.gif",
      "SheikJabRapid.gif",
      "SheikJabRapidEnd.gif",
      "SheikNAir.gif",
      "SheikNeedle.png",
      "SheikPivotGrab.gif",
      "SheikPummel.gif",
      "SheikUAir.gif",
      "SheikUSmash.gif",
      "SheikUThrow.gif",
      "SheikUTilt.gif",
      "SheikVanishA.gif",
      "SheikVanishG.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_sheik);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Sheikmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent,
                                 final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/sheik/" + sheikMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmMap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmMap);
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
