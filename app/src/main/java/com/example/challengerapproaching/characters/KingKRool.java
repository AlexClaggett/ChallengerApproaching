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

/** This class sets the content view to King K Rool's xml
 * file when the respective button is pushed.*/

public class KingKRool extends AppCompatActivity {

  String [] kingKRoolMoves = {
      "KingKRoolBAir.gif",
      "KingKRoolBlunderbuss.gif",
      "KingKRoolBlunderbussKannonballDetection.gif",
      "KingKRoolBThrow.gif",
      "KingKRoolCrownerang.gif",
      "KingKRoolCrownerangThrow.gif",
      "KingKRoolDAir.gif",
      "KingKRoolDashAttack.gif",
      "KingKRoolDashGrab.gif",
      "KingKRoolDSmash.gif",
      "KingKRoolDThrow.gif",
      "KingKRoolDTilt.gif",
      "KingKRoolFAir.gif",
      "KingKRoolFSmash.gif",
      "KingKRoolFSmashDown.gif",
      "KingKRoolFSmashUp.gif",
      "KingKRoolFThrow.gif",
      "KingKRoolFTilt.gif",
      "KingKRoolFTiltDown.gif",
      "KingKRoolFTiltUp.gif",
      "KingKRoolGrab.gif",
      "KingKRoolGutCheck.gif",
      "KingKRoolGutCheckHit.gif",
      "KingKRoolGutCheckHitTurn.gif",
      "KingKRoolJab1.gif",
      "KingKRoolJab2.gif",
      "KingKRoolJab3.gif",
      "KingKRoolKannonball.png",
      "KingKRoolNAir.gif",
      "KingKRoolPivotGrab.gif",
      "KingKRoolPropellerpack.gif",
      "KingKRoolPummel.gif",
      "KingKRoolUAir.gif",
      "KingKRoolUSmash.gif",
      "KingKRoolUThrow.gif",
      "KingKRoolUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_king__k__rool);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.KingKRoolmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/king_k_rool/" + kingKRoolMoves[position];
        ImageView imageView = findViewById(R.id.imageView3);
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
