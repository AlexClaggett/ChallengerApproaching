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

/** This class sets the content view to Diddy Kong's xml
 * file when the respective button is pushed.*/

public class DiddyKong extends AppCompatActivity {

  //Array of Diddy Kong's Framedata files
  transient String [] diddyKongMoves = {
      "DiddyKongBAir.gif",
      "DiddyKongBThrow.gif",
      "DiddyKongDAir.gif",
      "DiddyKongDashAttack.gif",
      "DiddyKongDashGrab.gif",
      "DiddyKongDSmash.gif",
      "DiddyKongDThrow.gif",
      "DiddyKongDTilt.gif",
      "DiddyKongFAir.gif",
      "DiddyKongFSmash.gif",
      "DiddyKongFThrow.gif",
      "DiddyKongFTilt.gif",
      "DiddyKongFTiltDown.gif",
      "DiddyKongFTiltUp.gif",
      "DiddyKongGrab.gif",
      "DiddyKongJab1.gif",
      "DiddyKongJab2.gif",
      "DiddyKongJab3.gif",
      "DiddyKongMonkeyFlip.gif",
      "DiddyKongMonkeyFlipKick.gif",
      "DiddyKongMonkeyFlipStick.gif",
      "DiddyKongMonkeyFlipStickAttack.gif",
      "DiddyKongNAir.gif",
      "DiddyKongPeanutPopgunBoom.gif",
      "DiddyKongPivotGrab.gif",
      "DiddyKongPummel.gif",
      "DiddyKongRocketBarrels.gif",
      "DiddyKongRocketBarrels.png",
      "DiddyKongRocketBarrelsExplosion.png",
      "DiddyKongUAir.gif",
      "DiddyKongUSmash.gif",
      "DiddyKongUThrow.gif",
      "DiddyKongUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_diddy_kong);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.DiddyKongmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/diddy_kong/" + diddyKongMoves[position];
        final ImageView imageView = findViewById(R.id.imageView3);
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
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