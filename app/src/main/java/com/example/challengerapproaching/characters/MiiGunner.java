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

/** This class sets the content view to Mii Gunner's xml
 * file when the respective button is pushed.*/

public class MiiGunner extends AppCompatActivity {

  /** Array of MiiGunner's Framedata files */
  /* default */ transient String [] miiGunnerMoves = {
      "MiiGunnerBombDrop.png",
      "MiiGunnerBombDropExplosion.png",
      "MiiGunnerGrenadeLauncher.png",
      "MiiGunnerGrenadeLauncherExplosion.png",
      "MiiGunnerMiiMissile.png",
      "MiiGunnerSuperMissile.png",
      "SansAbsorbingVortex.gif",
      "SansBAir.gif",
      "SansBThrow.gif",
      "SansCannonJumpKick.gif",
      "SansDAir.gif",
      "SansDashAttack.gif",
      "SansDashGrab.gif",
      "SansDSmash.gif",
      "SansDThrow.gif",
      "SansDTilt.gif",
      "SansEchoReflector.gif",
      "SansEchoReflectorStart.gif",
      "SansFAir.gif",
      "SansFSmash.gif",
      "SansFThrow.gif",
      "SansFTilt.gif",
      "SansGrab.gif",
      "SansJab1.gif",
      "SansJab2.gif",
      "SansJab3.gif",
      "SansNAir.gif",
      "SansPivotGrab.gif",
      "SansPummel.gif",
      "SansUAir.gif",
      "SansUSmash.gif",
      "SansUThrow.gif",
      "SansUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_mii__gunner);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MiiGunnermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/mii_gunner/" + miiGunnerMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e){
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

      }
    });

  }
}