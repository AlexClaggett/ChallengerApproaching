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

/** This class sets the content view to Link's xml
 * file when the respective button is pushed.*/

public class Link extends AppCompatActivity {

  String [] linkMoves = {
      "LinkArrow.png",
      "LinkBAir.gif",
      "LinkBoomerang.png",
      "LinkBThrow.gif",
      "LinkDAir.gif",
      "LinkDashAttack.gif",
      "LinkDashGrab.gif",
      "LinkDSmash.gif",
      "LinkDThrow.gif",
      "LinkDTilt.gif",
      "LinkFAir.gif",
      "LinkFSmash1.gif",
      "LinkFSmash2.gif",
      "LinkFThrow.gif",
      "LinkFTilt.gif",
      "LinkGrab.gif",
      "LinkJab1.gif",
      "LinkJab2.gif",
      "LinkJab3.gif",
      "LinkNAir.gif",
      "LinkPivotGrab.gif",
      "LinkPummel.gif",
      "LinkSpinAttackA.gif",
      "LinkSpinAttackG.gif",
      "LinkUAir.gif",
      "LinkUSmash.gif",
      "LinkUThrow.gif",
      "LinkUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_link);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Linkmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/link/" + linkMoves[position];
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

