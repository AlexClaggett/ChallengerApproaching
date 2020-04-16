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

/** This class sets the content view to Bowser Jr's xml
 * file when the respective button is pushed.*/

public class BowserJr extends AppCompatActivity {

  String [] bowserJrMoves = {
      "BowserJrAbandonShip.gif",
      "BowserJrAbandonShipExplosion.png",
      "BowserJrAbandonShipHammer.gif",
      "BowserJrBAir.gif",
      "BowserJrBThrow.gif",
      "BowserJrClownCannon.gif",
      "BowserJrClownKartDashA.gif",
      "BowserJrClownKartDashG.gif",
      "BowserJrClownKartDashSpinout.gif",
      "BowserJrDAir.gif",
      "BowserJrDAirLanding.gif",
      "BowserJrDashAttack.gif",
      "BowserJrDashGrab.gif",
      "BowserJrDSmash.gif",
      "BowserJrDThrow.gif",
      "BowserJrDTilt.gif",
      "BowserJrFAir.gif",
      "BowserJrFAirLanding.gif",
      "BowserJrFSmash.gif",
      "BowserJrFSmashDown.gif",
      "BowserJrFSmashUp.gif",
      "BowserJrFThrow.gif",
      "BowserJrFTilt.gif",
      "BowserJrFTiltDown.gif",
      "BowserJrFTiltUp.gif",
      "BowserJrGrab.gif",
      "BowserJrJab1.gif",
      "BowserJrJab2.gif",
      "BowserJrJabRapid.gif",
      "BowserJrJabRapidEnd.gif",
      "BowserJrNAir.gif",
      "BowserJrPivotGrab.gif",
      "BowserJrPummel.gif",
      "BowserJrUAir.gif",
      "BowserJrUSmash.gif",
      "BowserJrUThrow.gif",
      "BowserJrUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bowser_jr);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.BowserJrmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/bowser_jr/" + bowserJrMoves[position];
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