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

/** This class sets the content view to Jigglypuff's xml
 * file when the respective button is pushed.*/

public class Jigglypuff extends AppCompatActivity {

  /** Array of Jigglypuff's Framedata files */
  transient String [] jigglypuffMoves = {
      "JigglypuffBAir.gif",
      "JigglypuffBThrow.gif",
      "JigglypuffDAir.gif",
      "JigglypuffDashAttack.gif",
      "JigglypuffDashGrab.gif",
      "JigglypuffDSmash.gif",
      "JigglypuffDThrow.gif",
      "JigglypuffDTilt.gif",
      "JigglypuffFAir.gif",
      "JigglypuffFSmash.gif",
      "JigglypuffFThrow.gif",
      "JigglypuffFTilt.gif",
      "JigglypuffFTiltDown.gif",
      "JigglypuffFTiltUp.gif",
      "JigglypuffGrab.gif",
      "JigglypuffJab1.gif",
      "JigglypuffJab2.gif",
      "JigglypuffNAir.gif",
      "JigglypuffPivotGrab.gif",
      "JigglypuffPound.gif",
      "JigglypuffPummel.gif",
      "JigglypuffRest.gif",
      "JigglypuffRolloutA.png",
      "JigglypuffRolloutG.png",
      "JigglypuffSing.gif",
      "JigglypuffUAir.gif",
      "JigglypuffUSmash.gif",
      "JigglypuffUThrow.gif",
      "JigglypuffUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_jigglypuff);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Jigglypuffmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);
    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/jigglypuff/" + jigglypuffMoves[position];
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
