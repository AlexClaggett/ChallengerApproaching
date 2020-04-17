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

/** This class sets the content view to Bowser's xml
 * file when the respective button is pushed.*/

public class Bowser extends AppCompatActivity {

  String [] bowserMoves = {
      "BowserBAir.gif",
      "BowserBowserBomb.png",
      "BowserBowserBombG.gif",
      "BowserBowserBombLanding.gif",
      "BowserBThrow.gif",
      "BowserDAir.gif",
      "BowserDashAttack.gif",
      "BowserDashGrab.gif",
      "BowserDSmash.gif",
      "BowserDThrow.gif",
      "BowserDTilt.gif",
      "BowserFAir.gif",
      "BowserFlyingSlam.gif",
      "BowserFlyingSlamGrabA.gif",
      "BowserFlyingSlamGrabG.gif",
      "BowserFSmash.gif",
      "BowserFThrow.gif",
      "BowserFTilt.gif",
      "BowserFTiltDown.gif",
      "BowserFTiltUp.gif",
      "BowserGrab.gif",
      "BowserJab1.gif",
      "BowserJab2.gif",
      "BowserNAir.gif",
      "BowserPivotrGrab.gif",
      "BowserPummel.gif",
      "BowserUAir.gif",
      "BowserUSmash.gif",
      "BowserUThrow.gif",
      "BowserUTilt.gif",
      "BowserWhirlingFortressA.gif",
      "BowserWhirlingFortressG.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_bowser);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Bowsermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/bowser/" + bowserMoves[position];
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
