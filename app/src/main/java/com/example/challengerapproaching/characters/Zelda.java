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

  String [] zeldaMoves = {
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
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zelda);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Zeldamoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/zelda/" + zeldaMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            InputStream inputStream = new java.net.URL(toUrl).openStream();
            Bitmap bm = BitmapFactory.decodeStream(inputStream);
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