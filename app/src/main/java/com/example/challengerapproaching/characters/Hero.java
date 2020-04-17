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

/** This class sets the content view to Hero's xml
 * file when the respective button is pushed.*/

public class Hero extends AppCompatActivity {

  /** Array of Hero's Framedata files */
  transient String [] heroMoves = {
      "HeroBAir.gif",
      "HeroBThrow.gif",
      "HeroDAir.gif",
      "HeroDashAttack.gif",
      "HeroDashGrab.gif",
      "HeroDSmash.gif",
      "HeroDThrow.gif",
      "HeroDTilt.gif",
      "HeroFAir.gif",
      "HeroFlameSlash.gif",
      "HeroFSmash.gif",
      "HeroFThrow.gif",
      "HeroFTilt1.gif",
      "HeroFTilt2.gif",
      "HeroGrab.gif",
      "HeroHatchetMan.gif",
      "HeroJab1.gif",
      "HeroJab2.gif",
      "HeroJab3.gif",
      "Kaboom.gif",
      "HeroKaclang.png",
      "Kamikazee.gif",
      "HeroKacrackleSlash.gif",
      "HeroKazap.gif",
      "Magic20Burst.gif",
      "HeroMetalSlash.gif",
      "HeroNAir.gif",
      "HeroPivotGrab.gif",
      "HeroPummel.gif",
      "Sizzle.gif",
      "Thwack.png",
      "HeroUAir.gif",
      "HeroUSmash.gif",
      "HeroUThrow.gif",
      "HeroUTilt.gif",
      "HeroZap.gif",
      "HeroZapple.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_hero);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Heromoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/hero/" + heroMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bm = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bm);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          imageView.setVisibility(View.INVISIBLE);
          try {
            gifImageView.setGifImageUrl(toUrl);
            gifImageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });
  }
}

