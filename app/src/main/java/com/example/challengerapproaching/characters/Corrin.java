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

/** This class sets the content view to Corrin's xml
 * file when the respective button is pushed.*/

public class Corrin extends AppCompatActivity {

  /** Array of Corrin's Framedata files */
  /* default */ transient String [] corrinMoves = {
      "CorrinBAir.gif",
      "CorrinBThrow.gif",
      "CorrinCounterSurge.gif",
      "CorrinCounterSurgeHit.gif",
      "CorrinDAir.gif",
      "CorrinDAirLanding.gif",
      "CorrinDashAttack.gif",
      "CorrinDashGrab.gif",
      "CorrinDragonAscent.gif",
      "CorrinDragonLunge.png",
      "CorrinDragonLungeKick.gif",
      "CorrinDragonLungeKickBack.gif",
      "CorrinDSmash.gif",
      "CorrinDThrow.gif",
      "CorrinDTilt.gif",
      "CorrinFAir.gif",
      "CorrinFSmash.png",
      "CorrinFSmashCharge.gif",
      "CorrinFThrow.gif",
      "CorrinFTilt.gif",
      "CorrinGrab.gif",
      "CorrinJab1.gif",
      "CorrinJab2.gif",
      "CorrinJab3.gif",
      "CorrinJabRapid.gif",
      "CorrinJabRapidEnd.gif",
      "CorrinNAir.gif",
      "CorrinPivotGrab.gif",
      "CorrinPummel.gif",
      "CorrinUAir.gif",
      "CorrinUSmash.gif",
      "CorrinUThrow.gif",
      "CorrinUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_corrin);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Corrinmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);
    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);

    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/corrin/" + corrinMoves[position];
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