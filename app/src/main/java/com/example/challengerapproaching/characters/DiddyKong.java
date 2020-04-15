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

/** This class sets the content view to Diddy Kong's xml
 * file when the respective button is pushed.*/

public class DiddyKong extends AppCompatActivity {

  String [] DiddyKongmoves = {
          "DiddyKongBAir.gif",
          "DiddyKongBThrow.gif",
          "DiddyKongDAir.gif",
          "DiddyKongDashAttack.gif",
          "DiddyKongDashGrab.gif",
          "DiddyKongDSmash.gif",
          "DiddyKongDThrow.gif",
          "DiddyKongDTilt.gif",
          "DiddyKongFAir.gif",
          "DiddyKongFSmash.gif",
          "DiddyKongFThrow.gif",
          "DiddyKongFTilt.gif",
          "DiddyKongFTiltDown.gif",
          "DiddyKongFTiltUp.gif",
          "DiddyKongGrab.gif",
          "DiddyKongJab1.gif",
          "DiddyKongJab2.gif",
          "DiddyKongJab3.gif",
          "DiddyKongMonkeyFlip.gif",
          "DiddyKongMonkeyFlipKick.gif",
          "DiddyKongMonkeyFlipStick.gif",
          "DiddyKongMonkeyFlipStickAttack.gif",
          "DiddyKongNAir.gif",
          "DiddyKongPeanutPopgunBoom.gif",
          "DiddyKongPivotGrab.gif",
          "DiddyKongPummel.gif",
          "DiddyKongRocketBarrels.gif",
//          "DiddyKongRocketBarrels.png",
//          "DiddyKongRocketBarrelsExplosion.png",
          "DiddyKongUAir.gif",
          "DiddyKongUSmash.gif",
          "DiddyKongUThrow.gif",
          "DiddyKongUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_diddy_kong);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.DiddyKongmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/diddy_kong/" + DiddyKongmoves[position];
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