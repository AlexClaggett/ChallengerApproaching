package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Pichu's xml
 * file when the respective button is pushed.*/

public class Pichu extends AppCompatActivity {

  String [] Pichumoves = {
          "PichuBAir.gif",
          "PichuBThrow.gif",
          "PichuDAir.gif",
          "PichuDAirLanding.gif",
          "PichuDashAttack.gif",
          "PichuDashGrab.gif",
          "PichuDSmash.gif",
          "PichuDThrow.gif",
          "PichuDTilt.gif",
          "PichuFAir.gif",
          "PichuFSmash.gif",
          "PichuFThrow.gif",
          "PichuFTilt.gif",
          "PichuGrab.gif",
          "PichuJab.gif",
          "PichuNAir.gif",
          "PichuPivotGrab.gif",
          "PichuPummel.gif",
          "PichuSkullBash.gif",
          "PichuThunderHit.gif",
//          "PichuThunderJoltA.png",
//          "PichuThunderJoltG.png",
          "PichuUAir.gif",
          "PichuUSmash.gif",
          "PichuUThrow.gif",
          "PichuUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pichu);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Pichumoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/pichu/" + Pichumoves[position];
        try {
          gifImageView.setGifImageURL(toURL);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

  }
}