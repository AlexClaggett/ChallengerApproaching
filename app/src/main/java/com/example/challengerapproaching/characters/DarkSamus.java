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

/** This class sets the content view to Dark Samus's xml
 * file when the respective button is pushed.*/

public class DarkSamus extends AppCompatActivity {

  //Array of Dark Samus's Framedata files
  transient String [] darkSamusMoves = {
      "DarkSamusBAir.gif",
      "DarkSamusBomb.png",
      "DarkSamusBombExplosion.png",
      "DarkSamusBThrow.gif",
      "DarkSamusChargeShotMax.gif",
      "DarkSamusChargeShotMin.gif",
      "DarkSamusDAir.gif",
      "DarkSamusDashAttack.gif",
      "DarkSamusDSmash.gif",
      "DarkSamusDThrow.gif",
      "DarkSamusDTilt.gif",
      "DarkSamusFAir.gif",
      "DarkSamusFSmash.gif",
      "DarkSamusFSmashDown.gif",
      "DarkSamusFSmashUp.gif",
      "DarkSamusFThrow.gif",
      "DarkSamusFTilt.gif",
      "DarkSamusFTiltDown.gif",
      "DarkSamusFTiltUp.gif",
      "DarkSamusJab1.gif",
      "DarkSamusJab2.gif",
      "DarkSamusMissile.png",
      "DarkSamusNAir.gif",
      "DarkSamusPummel.gif",
      "DarkSamusScrewAttackA.gif",
      "DarkSamusScrewAttackG.gif",
      "DarkSamusSuperMissile.png",
      "DarkSamusUAir.gif",
      "DarkSamusUSmash.gif",
      "DarkSamusUThrow.gif",
      "DarkSamusUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_dark_samus);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.DarkSamusmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/dark_samus/" + darkSamusMoves[position];
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