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

/** This class sets the content view to Sonic's xml
 * file when the respective button is pushed.*/

public class Sonic extends AppCompatActivity {

  /** Array of Sonic's Framedata files */
  transient String [] sonicMoves = {
      "SonicBAir.gif",
      "SonicBThrow.gif",
      "SonicDAir.gif",
      "SonicDashAttack.gif",
      "SonicDashGrab.gif",
      "SonicDSmash.gif",
      "SonicDThrow.gif",
      "SonicDTilt.gif",
      "SonicFAir.gif",
      "SonicFSmash.gif",
      "SonicFSmashDown.gif",
      "SonicFSmashUp.gif",
      "SonicFThrow.gif",
      "SonicFTilt.gif",
      "SonicFTiltDown.gif",
      "SonicFTiltUp.gif",
      "SonicGrab.gif",
      "SonicHomingAttack.png",
      "SonicJab1.gif",
      "SonicJab2.gif",
      "SonicJab3.gif",
      "SonicNAir.gif",
      "SonicPivotGrab.gif",
      "SonicPummel.gif",
      "SonicSpinCharge.png",
      "SonicSpinChargeJump.png",
      "SonicSpinDash.png",
      "SonicSpinDashJump.png",
      "SonicSpringJump.png",
      "SonicUAir.gif",
      "SonicUSmash.gif",
      "SonicUThrow.gif",
      "SonicUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_sonic);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Sonicmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/sonic/" + sonicMoves[position];
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
