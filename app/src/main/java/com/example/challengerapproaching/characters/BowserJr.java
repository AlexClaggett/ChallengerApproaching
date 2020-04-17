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

  /**Array of BowserJr's Framedata files*/
  transient String [] bowserJrMoves = {
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
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_bowser_jr);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.BowserJrmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/bowser_jr/" + bowserJrMoves[position];
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
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });
  }
}