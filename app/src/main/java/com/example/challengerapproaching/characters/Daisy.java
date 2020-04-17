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

/** This class sets the content view to Daisy's xml
 * file when the respective button is pushed.*/

public class Daisy extends AppCompatActivity {

  String [] daisyMoves = {
      "DaisyBAir.gif",
      "DaisyBThrow.gif",
      "DaisyDAir.gif",
      "DaisyDaisyBomber.png",
      "DaisyDaisyBomberHit.gif",
      "DaisyDaisyParasol.gif",
      "DaisyDaisyParasolFall.gif",
      "DaisyDashAttack.gif",
      "DaisyDashGrab.gif",
      "DaisyDSmash.gif",
      "DaisyDThrow.gif",
      "DaisyDTilt.gif",
      "DaisyFAir.gif",
      "DaisyFSmashFryingPan.gif",
      "DaisyFSmashGolfClub.gif",
      "DaisyFSmashTennisRacket.gif",
      "DaisyFThrow.gif",
      "DaisyFTilt.gif",
      "DaisyGrab.gif",
      "DaisyJab1.gif",
      "DaisyJab2.gif",
      "DaisyNAir.gif",
      "DaisyPivotGrab.gif",
      "DaisyPummel.gif",
      "DaisyToad.gif",
      "DaisyUAir.gif",
      "DaisyUSmash.gif",
      "DaisyUThrow.gif",
      "DaisyUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_daisy);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Daisymoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/daisy/" + daisyMoves[position];
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
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

  }
}
