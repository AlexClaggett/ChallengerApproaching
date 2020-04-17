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

/** This class sets the content view to Byleth's xml
 * file when the respective button is pushed.*/

public class Byleth extends AppCompatActivity {

  /** Array of Byleth's Framedata files */
  /* default */ transient String [] bylethMoves = {
      "BylethAreadbharAerial.gif",
      "BylethAreadbharGrounded.gif",
      "BylethAymr.gif",
      "BylethAymrSuperArmor.gif",
      "BylethBAir.gif",
      "BylethBThrow.gif",
      "BylethDAir.gif",
      "BylethDashAttack.gif",
      "BylethDashGrab.gif",
      "BylethDSmash.gif",
      "BylethDThrow.gif",
      "BylethDTilt.gif",
      "BylethFailnaught.gif",
      "BylethFailnaughtMax.gif",
      "BylethFailnaughtMax.png",
      "BylethFAir.gif",
      "BylethFSmash.gif",
      "BylethFSmashDown.gif",
      "BylethFSmashUp.gif",
      "BylethFThrow.gif",
      "BylethFTilt.gif",
      "BylethGrab.gif",
      "BylethJab1.gif",
      "BylethJab2.gif",
      "BylethJab3.gif",
      "BylethJabRapid.gif",
      "BylethJapRapidFinisher.gif",
      "BylethNAir.gif",
      "BylethNAirLanding.gif",
      "BylethPivotGrab.gif",
      "BylethPummel.gif",
      "BylethSwordoftheCreatorAerial.gif",
      "BylethSwordoftheCreatorGrounded.gif",
      "BylethUAir.gif",
      "BylethUSmash.gif",
      "BylethUThrow.gif",
      "BylethUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_bylthe);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Bylethmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/byleth/" + bylethMoves[position];
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