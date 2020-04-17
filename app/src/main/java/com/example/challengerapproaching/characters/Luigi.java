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

/** This class sets the content view to Luigi's xml
 * file when the respective button is pushed.*/

public class Luigi extends AppCompatActivity {

  //Array of Luigi's Framedata files
  transient String [] luigiMoves = {
      "LuigiBAir.gif",
      "LuigiBThrow.gif",
      "LuigiCycloneA.gif",
      "LuigiCycloneG.gif",
      "LuigiDAir.gif",
      "LuigiDashAttack.gif",
      "LuigiDashGrab.gif",
      "LuigiDSmash.gif",
      "LuigiDTaunt.png",
      "LuigiDThrow.gif",
      "LuigiDTilt.gif",
      "LuigiFAir.gif",
      "LuigiFireball.gif",
      "LuigiFSmash.gif",
      "LuigiFSmashDown.gif",
      "LuigiFSmashUp.gif",
      "LuigiFThrow.gif",
      "LuigiFTilt.gif",
      "LuigiFTiltDown.gif",
      "LuigiFTiltUp.gif",
      "LuigiGrab.gif",
      "LuigiGreenMissile.gif",
      "LuigiGreenMissileMisfire.gif",
      "LuigiJab1.gif",
      "LuigiJab2.gif",
      "LuigiJab3.gif",
      "LuigiNAir.gif",
      "LuigiPivotGrab.gif",
      "LuigiPummel.gif",
      "LuigiSuperJumpPunchA.gif",
      "LuigiSuperJumpPunchG.gif",
      "LuigiUAir.gif",
      "LuigiUSmash.gif",
      "LuigiUThrow.gif",
      "LuigiUTilt.gif",
      "LuigiZAirHitbox.png"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_luigi);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Luigimoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/luigi/" + luigiMoves[position];
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
