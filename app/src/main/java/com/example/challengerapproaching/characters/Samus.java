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

/** This class sets the content view to Samus's xml
 * file when the respective button is pushed.*/

public class Samus extends AppCompatActivity { //NOPMD

  /** Array of Samus's Framedata files. */
  /* default */ transient String [] samusMoves = { //NOPMD
      "SamusBAir.gif",
      "SamusBomb.png",
      "SamusBombExplosion.png",
      "SamusBThrow.gif",
      "SamusChargeShotMax.gif",
      "SamusChargeShotMin.gif",
      "SamusDAir.gif",
      "SamusDashAttack.gif",
      "SamusDSmash.gif",
      "SamusDThrow.gif",
      "SamusDTilt.gif",
      "SamusFAir.gif",
      "SamusFSmash.gif",
      "SamusFSmashDown.gif",
      "SamusFSmashUp.gif",
      "SamusFThrow.gif",
      "SamusFTilt.gif",
      "SamusFTiltDown.gif",
      "SamusFTiltUp.gif",
      "SamusJab1.gif",
      "SamusJab2.gif",
      "SamusMissile.png",
      "SamusNAir.gif",
      "SamusPummel.gif",
      "SamusScrewAttackA.gif",
      "SamusScrewAttackG.gif",
      "SamusSuperMissile.png",
      "SamusUAir.gif",
      "SamusUSmash.gif",
      "SamusUThrow.gif",
      "SamusUTilt.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_samus);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Samusmoves)
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
        final String toUrl = "https://ultimateframedata.com/hitboxes/samus/" + samusMoves[position];
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
