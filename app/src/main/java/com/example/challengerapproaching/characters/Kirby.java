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

/** This class sets the content view to Kirby's xml
 * file when the respective button is pushed.*/

public class Kirby extends AppCompatActivity {

  //Array of Kirby's Framedata files
  transient String [] kirbyMoves = {
      "KirbyBAir.gif",
      "KirbyBThrow.gif",
      "KirbyDAir.gif",
      "KirbyDashAttack.gif",
      "KirbyDashGrab.gif",
      "KirbyDSmash.gif",
      "KirbyDThrow.gif",
      "KirbyDTilt.gif",
      "KirbyFAir.gif",
      "KirbyFinalCutter.gif",
      "KirbyFSmash.gif",
      "KirbyFSmashDown.gif",
      "KirbyFSmashUp.gif",
      "KirbyFThrow.gif",
      "KirbyFTilt.gif",
      "KirbyFTiltDown.gif",
      "KirbyFTiltUp.gif",
      "KirbyGrab.gif",
      "KirbyHammerFlipA.gif",
      "KirbyHammerFlipAMax.gif",
      "KirbyHammerFlipG.gif",
      "KirbyHammerFlipGMax.gif",
      "KirbyInhale.gif",
      "KirbyInhaleStar.gif",
      "KirbyJab1.gif",
      "KirbyJab2.gif",
      "KirbyJabRapid.gif",
      "KirbyJabRapidEnd.gif",
      "KirbyNAir.gif",
      "KirbyPivotGrab.gif",
      "KirbyPummel.gif",
      "KirbyStone.png",
      "KirbyStoneLanding.png",
      "KirbyUAir.gif",
      "KirbyUSmash.gif",
      "KirbyUThrow.gif",
      "KirbyUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_kirby);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Kirbymoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/kirby/" + kirbyMoves[position];
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

