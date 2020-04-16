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

  String [] corrinMoves = {
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
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_corrin);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Corrinmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);
    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);

    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/corrin/" + corrinMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            InputStream inputStream = new java.net.URL(toUrl).openStream();
            Bitmap bm = BitmapFactory.decodeStream(inputStream);
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