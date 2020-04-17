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

/** This class sets the content view to Fox's xml
 * file when the respective button is pushed.*/

public class Fox extends AppCompatActivity {


  transient String [] foxMoves = {
      "FoxBAir.gif",
      "FoxBlaster.gif",
      "FoxBThrow.gif",
      "FoxDAir.gif",
      "FoxDashAttack.gif",
      "FoxDashGrab.gif",
      "FoxDSmash.gif",
      "FoxDThrow.gif",
      "FoxDTilt.gif",
      "FoxFAir.gif",
      "FoxFireFox.gif",
      "FoxFoxIllusion.png",
      "FoxFSmash.gif",
      "FoxFThrow.gif",
      "FoxFTilt.gif",
      "FoxFTiltDown.gif",
      "FoxFTiltUp.gif",
      "FoxGrab.gif",
      "FoxJab1.gif",
      "FoxJab2.gif",
      "FoxJabRapid.gif",
      "FoxJabRapidEnd.gif",
      "FoxNAir.gif",
      "FoxPivotGrab.gif",
      "FoxPummel.gif",
      "FoxReflector.gif",
      "FoxReflectorStart.gif",
      "FoxUAir.gif",
      "FoxUSmash.gif",
      "FoxUTHrow.gif",
      "FoxUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_fox);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Foxmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);

    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/fox/" + foxMoves[position];
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
