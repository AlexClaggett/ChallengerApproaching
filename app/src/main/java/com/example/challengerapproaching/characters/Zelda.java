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

/** This class sets the content view to Zelda's xml
 * file when the respective button is pushed.*/

public class Zelda extends AppCompatActivity {

  /** Array of Zelda's Framedata files */
  /* default */ transient String [] zeldaMoves = {
      "ZeldaBAir.gif",
      "ZeldaBThrow.gif",
      "ZeldaDAir.gif",
      "ZeldaDashAttack.gif",
      "ZeldaDashGrab.gif",
      "ZeldaDinsFire.png",
      "ZeldaDSmash.gif",
      "ZeldaDThrow.gif",
      "ZeldaDTilt.gif",
      "ZeldaFAir.gif",
      "ZeldaFSmash.gif",
      "ZeldaFThrow.gif",
      "ZeldaFTilt.gif",
      "ZeldaFTiltDown.gif",
      "ZeldaFTiltUp.gif",
      "ZeldaGrab.gif",
      "ZeldaJab.gif",
      "ZeldaJabRapid.gif",
      "ZeldaJabRapidEnd.gif",
      "ZeldaNAir.gif",
      "ZeldaNayrusLove.gif",
      "ZeldaNFaroresWindA.gif",
      "ZeldaNFaroresWindG.gif",
      "PhantomKick.gif",
      "PhantomPunch.gif",
      "PhantomSwing1.gif",
      "PhantomSwing2.gif",
      "PhantomSwing3.gif",
      "ZeldaPivotGrab.gif",
      "ZeldaPummel.gif",
      "ZeldaUAir.gif",
      "ZeldaUSmash.gif",
      "ZeldaUThrow.gif",
      "ZeldaUTilt.gif",
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_zelda);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Zeldamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/zelda/" + zeldaMoves[position];
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