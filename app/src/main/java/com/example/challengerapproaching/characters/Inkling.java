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

/** This class sets the content view to Inkling's xml
 * file when the respective button is pushed.*/

public class Inkling extends AppCompatActivity { //NOPMD

  /** Array of Inkling's Framedata files. */
  /* default */ transient String [] inklingMoves = { //NOPMD
      "InklingBAir.gif",
      "InklingBThrow.gif",
      "InklingDAir.gif",
      "InklingDashAttack.gif",
      "InklingDashGrab.gif",
      "InklingDSmash.gif",
      "InklingDThrow.gif",
      "InklingDTilt.gif",
      "InklingFAir.gif",
      "InklingFSmash.gif",
      "InklingFThrow.gif",
      "InklingFTilt.gif",
      "InklingGrab.gif",
      "InklingJab1.gif",
      "InklingJab2.gif",
      "InklingJab3.gif",
      "InklingJabRapid.gif",
      "InklingJabRapidEnd.gif",
      "InklingNAir.gif",
      "InklingPivotGrab.gif",
      "InklingPummel.gif",
      "InklingSplatBomb.gif",
      "InklingSplatBombExplosion.gif",
      "InklingSplatRollerA.png",
      "InklingSplatRollerG.png",
      "InklingSplatRollerNoInk.png",
      "InklingSuperJump.gif",
      "InklingUAir.gif",
      "InklingUSmash.gif",
      "InklingUSmashNoInk.gif",
      "InklingUThrow.gif",
      "InklingUTilt_.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_inkling);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Inklingmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent,
                                 final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/inkling/" + inklingMoves[position];
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

