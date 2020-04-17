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

/** This class sets the content view to Wii Fit Trainer's xml
 * file when the respective button is pushed.*/

public class WiiFitTrainer extends AppCompatActivity {

  String [] wiiFitmoves = {
      "WiiFitTrainerBAir.gif",
      "WiiFitTrainerBThrow.gif",
      "WiiFitTrainerDAir.gif",
      "WiiFitTrainerDashAttack.gif",
      "WiiFitTrainerDashGrab.gif",
      "WiiFitTrainerDSmash.gif",
      "WiiFitTrainerDThrow.gif",
      "WiiFitTrainerDTilt.gif",
      "WiiFitTrainerFAir.gif",
      "WiiFitTrainerFSmash.gif",
      "WiiFitTrainerFThrow.gif",
      "WiiFitTrainerFTilt.gif",
      "WiiFitTrainerGrab.gif",
      "WiiFitTrainerHeader.gif",
      "WiiFitTrainerJab1.gif",
      "WiiFitTrainerJab2.gif",
      "WiiFitTrainerJab3.gif",
      "WiiFitTrainerNAir.gif",
      "WiiFitTrainerPivotGrab.gif",
      "WiiFitTrainerPummel.gif",
      "Soccerball.png",
      "WiiFitTrainerSunSalutationMax.png",
      "WiiFitTrainerSunSalutationMin.png",
      "WiiFitTrainerSuperHoop.gif",
      "WiiFitTrainerUAir.gif",
      "WiiFitTrainerUSmash.gif",
      "WiiFitTrainerUThrow.gif",
      "WiiFitTrainerUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_wii__fit__trainer);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.WiiFitTrainermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/wii_fit_trainer/" + wiiFitmoves[position];
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
