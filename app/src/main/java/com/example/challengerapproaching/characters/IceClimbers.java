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

/** This class sets the content view to Ice Climber's xml
 * file when the respective button is pushed.*/

public class IceClimbers extends AppCompatActivity {

  transient String [] iceClimbersmoves = {
      "IceClimbersIceShot.png",
      "NanaBAir.gif",
      "NanaBelay.gif",
      "NanaDAir.gif",
      "NanaDashAttack.gif",
      "NanaDSmash.gif",
      "NanaDTilt.gif",
      "NanaFAir.gif",
      "NanaFSmash.gif",
      "NanaFTilt.gif",
      "NanaFTiltUp.gif",
      "NanaJab1.gif",
      "NanaJab2.gif",
      "NanaNAir.gif",
      "NanaSqualHammerSolo.gif",
      "NanaSquallHammerDuo.gif",
      "NanaTiltDown.gif",
      "NanaUAir.gif",
      "NanaUSmash.gif",
      "NanaUTilt.gif",
      "PopoBAir.gif",
      "PopoBThrow.gif",
      "PopoDAir.gif",
      "PopoDashAttack.gif",
      "PopoDashGrab.gif",
      "PopoDSmash.gif",
      "PopoDThrow.gif",
      "PopoDTilt.gif",
      "PopoFAir.gif",
      "PopoFSmash.gif",
      "PopoFThrow.gif",
      "PopoFTilt.gif",
      "PopoFTiltDown.gif",
      "PopoFTiltUp.gif",
      "PopoGrab.gif",
      "PopoJab1.gif",
      "PopoJab2.gif",
      "PopoNAir.gif",
      "PopoPivotGrab.gif",
      "PopoPummel.gif",
      "PopoSqualHammerSolo.gif",
      "PopoSquallHammerDuo.gif",
      "PopoUAir.gif",
      "PopoUSmash.gif",
      "PopoUThrow.gif",
      "PopoUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_ice__climbers);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.IceClimbersmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/ice_climbers/" + iceClimbersmoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bm = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bm);
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
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

  }
}
