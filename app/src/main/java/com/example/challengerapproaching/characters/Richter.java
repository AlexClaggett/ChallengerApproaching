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

/** This class sets the content view to Richter's xml
 * file when the respective button is pushed.*/

public class Richter extends AppCompatActivity {

  /** Array of Richter's Framedata files */
  /* default */ transient String [] richterMoves = {
      "RichterAxe.gif",
      "RichterBAir.gif",
      "RichterBAirDown.gif",
      "RichterBAirUp.gif",
      "RichterBThrow.gif",
      "RichterCross.png",
      "RichterDAir.gif",
      "RichterDashAttack.gif",
      "RichterDashGrab.gif",
      "RichterDSmash.gif",
      "RichterDThrow.gif",
      "RichterDTilt1.gif",
      "RichterDTilt2.gif",
      "RichterFAir.gif",
      "RichterFAirDown.gif",
      "RichterFAirUp.gif",
      "RichterFSmash.gif",
      "RichterFSmashDown.gif",
      "RichterFSmashUp.gif",
      "RichterFThrow.gif",
      "RichterFTilt.gif",
      "RichterGrab.gif",
      "RichterJab1.gif",
      "RichterJab2.gif",
      "RichterJabRapid.gif",
      "RichterJabRapidEnd.gif",
      "RichterNAir.gif",
      "RichterPivotGrab.gif",
      "RichterPummel.gif",
      "RichterUAir.gif",
      "RichterUppercut.gif",
      "RichterUSmash.gif",
      "RichterUThrow.gif",
      "RichterUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_richter);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Richtermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/richter/" + richterMoves[position];
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
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setVisibility(View.INVISIBLE);
        final ImageView imageView = findViewById(R.id.imageView3);
        imageView.setVisibility(View.INVISIBLE);
      }
    });

  }
}
