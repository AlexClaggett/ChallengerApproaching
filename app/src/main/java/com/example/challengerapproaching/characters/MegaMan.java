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

/** This class sets the content view to MegaMan's xml
 * file when the respective button is pushed.*/

public class MegaMan extends AppCompatActivity { //NOPMD

  /** Array of MegaMan's Framedata files. */
  /* default */ transient String [] megaManMoves = { //NOPMD
      "MegaManBAir.gif",
      "MegaManBThrow.gif",
      "MegaManCrashBomber.png",
      "MegaManCrashBomberExplosion.gif",
      "MegaManDAir.gif",
      "MegaManDashAttack.gif",
      "MegaManDashGrab.gif",
      "MegaManDSmash.gif",
      "MegaManDThrow.gif",
      "MegaManDTilt.gif",
      "MegaManFAir.gif",
      "MegaManFSmashMaximum.gif",
      "MegaManFSmashMinimum.gif",
      "MegaManFThrow.gif",
      "MegaManGrab.gif",
      "MegaManJab.gif",
      "MegaManLeafShield.gif",
      "MegaManLeafShieldFly.gif",
      "MegaManNAir.gif",
      "MegaManPivotGrab.gif",
      "MegaManPummel.gif",
      "MegaManUAir.gif",
      "MegaManUSmash.gif",
      "MegaManUThrow.gif",
      "MegaManUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_mega__man);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MegaManmoves)
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
        final String toUrl = "https://ultimateframedata.com/hitboxes/mega_man/" + megaManMoves[position];
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

