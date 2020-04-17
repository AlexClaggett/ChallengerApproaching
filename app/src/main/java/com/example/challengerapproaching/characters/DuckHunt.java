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

/** This class sets the content view to Duck Hunt's xml
 * file when the respective button is pushed.*/

public class DuckHunt extends AppCompatActivity {

  //Array of Duck Hunt's Framedata files
  transient String [] duckHuntMoves = {
      "DuckHuntBAir.gif",
      "DuckHuntBThrow.gif",
      "DuckHuntClayShooting.png",
      "DuckHuntClayShootingBurst.png",
      "DuckHuntDAir.gif",
      "DuckHuntDashAttack.gif",
      "DuckHuntDashGrab.gif",
      "DuckHuntDSmash.gif",
      "DuckHuntDThrow.gif",
      "DuckHuntDTilt.gif",
      "DuckHuntFAir.gif",
      "DuckHuntFSmash.gif",
      "DuckHuntFThrow.gif",
      "DuckHuntFTilt.gif",
      "DuckHuntFTiltDown.gif",
      "DuckHuntFTiltUp.gif",
      "DuckHuntGrab.gif",
      "DuckHuntJab1.gif",
      "DuckHuntJab2.gif",
      "DuckHuntJab3.gif",
      "DuckHuntJabRapid.gif",
      "DuckHuntJabRapidEnd.gif",
      "DuckHuntNAir.gif",
      "DuckHuntPivotGrab.gif",
      "DuckHuntPummel.gif",
      "DuckHuntTrickShotExplosion.png",
      "DuckHuntTrickShotFly.png",
      "DuckHuntTrickShotStand.png",
      "DuckHuntUAir.gif",
      "DuckHuntUSmash.gif",
      "DuckHuntUThrow.gif",
      "DuckHuntUTilt.gif"
  };


  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_duck__hunt);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.DuckHuntmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/duck_hunt/" + duckHuntMoves[position];
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