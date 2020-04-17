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

/** This class sets the content view to Banjo Kazooie's xml
 * file when the respective button is pushed.*/

public class BanjoKazooie extends AppCompatActivity {

  transient String [] banjoKazooiemoves = {
      "Banjo_KazooieBAir.gif",
      "Banjo_KazooieBThrow.gif",
      "Banjo_KazooieDAir.gif",
      "Banjo_KazooieDAirLanding.gif",
      "Banjo_KazooieDashAttack.gif",
      "Banjo_KazooieDashGrab.gif",
      "Banjo_KazooieDSmash.gif",
      "Banjo_KazooieDThrow.gif",
      "Banjo_KazooieDTilt.gif",
      "Banjo_KazooieFAir.gif",
      "Banjo_KazooieFSmash.gif",
      "Banjo_KazooieFThrow.gif",
      "Banjo_KazooieFTilt.gif",
      "Banjo_KazooieFTiltDown.gif",
      "Banjo_KazooieFTiltUp.gif",
      "Banjo_KazooieGrab.gif",
      "Banjo_KazooieJab1.gif",
      "Banjo_KazooieJab2.gif",
      "Banjo_KazooieJab3.gif",
      "Banjo_KazooieJabRapid.gif",
      "Banjo_KazooieJabRapidEnd.gif",
      "Banjo_KazooieNAir.gif",
      "Banjo_KazooiePivotGrab.gif",
      "Banjo_KazooiePummel.gif",
      "Banjo_KazooieShockSpringJump.gif",
      "Banjo_KazooieUAir.gif",
      "Banjo_KazooieUSmash.gif",
      "Banjo_KazooieUThrow.gif",
      "Banjo_KazooieUTilt.gif",
      "Banjo_KazooieWonderwing.gif",
      "BanjoKazooieBreegullBlaster1-6.png",
      "BanjoKazooieBreegullBlaster13.png",
      "BanjoKazooieBreegullBlaster7-12.png",
      "BanjoKazooieEggFiring.png",
      "Rear20Egg.png"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_banjo__kazooie);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Banjo_Kazooiemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);

    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/banjo_and_kazooie/" + banjoKazooiemoves[position];
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