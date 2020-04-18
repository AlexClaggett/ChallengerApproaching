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

/** This class sets the content view to Young Link's xml
 * file when the respective button is pushed.*/

public class YoungLink extends AppCompatActivity {

  /** Array of Young Link's Framedata files */
  /* default */ transient String [] youngLinkMoves = {
      "YoungLinkArrow.png",
      "YoungLinkBAir.gif",
      "YoungLinkBoomerang.png",
      "YoungLinkBThrow.gif",
      "YoungLinkDAir.gif",
      "YoungLinkDashAttack.gif",
      "YoungLinkDashGrab.gif",
      "YoungLinkDSmash.gif",
      "YoungLinkDThrow.gif",
      "YoungLinkDTilt.gif",
      "YoungLinkFAir.gif",
      "YoungLinkFSmash1.gif",
      "YoungLinkFSmash2.gif",
      "YoungLinkFThrow.gif",
      "YoungLinkFTilt.gif",
      "YoungLinkGrab.gif",
      "YoungLinkJab1.gif",
      "YoungLinkJab2.gif",
      "YoungLinkJab3.gif",
      "YoungLinkJabRapid.gif",
      "YoungLinkJabRapidEnd.gif",
      "YoungLinkNAir.gif",
      "YoungLinkPivotGrab.gif",
      "YoungLinkPummel.gif",
      "YoungLinkSpinAttackA.gif",
      "YoungLinkSpinAttackG.gif",
      "YoungLinkUAir.gif",
      "YoungLinkUSmash.gif",
      "YoungLinkUThrow.gif",
      "YoungLinkUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_young__link);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.YoungLinkmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/young_link/" + youngLinkMoves[position];
        final ImageView imageView = findViewById(R.id.imageView3);
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