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

/** This class sets the content view to Toon Link's xml
 * file when the respective button is pushed.*/

public class ToonLink extends AppCompatActivity {

  String [] toonLinkMoves = {
      "ToonLinkArrow.png",
      "ToonLinkBAir.gif",
      "ToonLinkBoomerang.png",
      "ToonLinkBThrow.gif",
      "ToonLinkDAir.gif",
      "ToonLinkDAirLanding.gif",
      "ToonLinkDashAttack.gif",
      "ToonLinkDashGrab.gif",
      "ToonLinkDSmash.gif",
      "ToonLinkDThrow.gif",
      "ToonLinkDTilt.gif",
      "ToonLinkFAir.gif",
      "ToonLinkFSmash.gif",
      "ToonLinkFThrow.gif",
      "ToonLinkFTilt.gif",
      "ToonLinkGrab.gif",
      "ToonLinkJab1.gif",
      "ToonLinkJab2.gif",
      "ToonLinkJab3.gif",
      "ToonLinkNAir.gif",
      "ToonLinkPivotGrab.gif",
      "ToonLinkPummel.gif",
      "ToonLinkSpinAttackA.gif",
      "ToonLinkSpinAttackG.gif",
      "ToonLinkUAir.gif",
      "ToonLinkUSmash.gif",
      "ToonLinkUThrow.gif",
      "ToonLinkUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_toon__link);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.ToonLinkmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/toon_link/" + toonLinkMoves[position];
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
