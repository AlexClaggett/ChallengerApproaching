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

  /**Array of Bowser's Framedata files*/
  /* default */ transient String [] bowserMoves = {
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
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_bowser);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Bowsermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/bowser/" + bowserMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e){
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

      }
    });

  }
}
