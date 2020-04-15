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

/** This class sets the content view to Ice Climber's xml
 * file when the respective button is pushed.*/

public class IceClimbers extends AppCompatActivity {

  String [] IceClimbersmoves = {
//          "IceClimbersIceShot.png",
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
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ice__climbers);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.IceClimbersmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ice_climbers/" + IceClimbersmoves[position];
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
