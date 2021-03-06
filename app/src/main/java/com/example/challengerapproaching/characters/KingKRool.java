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

/** This class sets the content view to King K Rool's xml
 * file when the respective button is pushed.*/

public class KingKRool extends AppCompatActivity { //NOPMD

  /** Array of K Rool's Framedata files. */
  /* default */ transient String [] kingKRoolMoves = { //NOPMD
      "KingKRoolBAir.gif",
      "KingKRoolBlunderbuss.gif",
      "KingKRoolBlunderbussKannonballDetection.gif",
      "KingKRoolBThrow.gif",
      "KingKRoolCrownerang.gif",
      "KingKRoolCrownerangThrow.gif",
      "KingKRoolDAir.gif",
      "KingKRoolDashAttack.gif",
      "KingKRoolDashGrab.gif",
      "KingKRoolDSmash.gif",
      "KingKRoolDThrow.gif",
      "KingKRoolDTilt.gif",
      "KingKRoolFAir.gif",
      "KingKRoolFSmash.gif",
      "KingKRoolFSmashDown.gif",
      "KingKRoolFSmashUp.gif",
      "KingKRoolFThrow.gif",
      "KingKRoolFTilt.gif",
      "KingKRoolFTiltDown.gif",
      "KingKRoolFTiltUp.gif",
      "KingKRoolGrab.gif",
      "KingKRoolGutCheck.gif",
      "KingKRoolGutCheckHit.gif",
      "KingKRoolGutCheckHitTurn.gif",
      "KingKRoolJab1.gif",
      "KingKRoolJab2.gif",
      "KingKRoolJab3.gif",
      "KingKRoolKannonball.png",
      "KingKRoolNAir.gif",
      "KingKRoolPivotGrab.gif",
      "KingKRoolPropellerpack.gif",
      "KingKRoolPummel.gif",
      "KingKRoolUAir.gif",
      "KingKRoolUSmash.gif",
      "KingKRoolUThrow.gif",
      "KingKRoolUTilt.gif"
  };


  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_king__k__rool);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.KingKRoolmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent,
                                 final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/king_k_rool/" + kingKRoolMoves[position];
        final ImageView imageView = findViewById(R.id.imageView3);
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            imageView.setVisibility(View.INVISIBLE);
          }
        } else {
          imageView.setVisibility(View.INVISIBLE);
          try {
            gifImageView.setGifImageUrl(toUrl);
            gifImageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            gifImageView.setVisibility(View.INVISIBLE);
          }
        }
      }


      @Override
      public void onNothingSelected(final AdapterView<?> parent) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setVisibility(View.INVISIBLE);
        final ImageView imageView = findViewById(R.id.imageView3);
        imageView.setVisibility(View.INVISIBLE);
      }
    });

  }
}
