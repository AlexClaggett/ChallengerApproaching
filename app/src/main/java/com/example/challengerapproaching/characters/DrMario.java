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

/** This class sets the content view to Dr Mario's xml
 * file when the respective button is pushed.*/

public class DrMario extends AppCompatActivity {

  String [] DrMariomoves = {
          "DrMarioBAir.gif",
          "DrMarioBThrow.gif",
          "DrMarioDAir.gif",
          "DrMarioDashAttack.gif",
          "DrMarioDashGrab.gif",
          "DrMarioDrTornadoA.gif",
          "DrMarioDrTornadoG.gif",
          "DrMarioDSmash.gif",
          "DrMarioDThrow.gif",
          "DrMarioDTilt.gif",
          "DrMarioFAir.gif",
          "DrMarioFSmash.gif",
          "DrMarioFSmashDown.gif",
          "DrMarioFSmashUp.gif",
          "DrMarioFThrow.gif",
          "DrMarioFTilt.gif",
          "DrMarioFTiltDown.gif",
          "DrMarioFTiltUp.gif",
          "DrMarioGrab.gif",
          "DrMarioJab1.gif",
          "DrMarioJab2.gif",
          "DrMarioJab3.gif",
          "DrMarioMegavitamin.png",
          "DrMarioNAir.gif",
          "DrMarioPivotGrab.gif",
          "DrMarioPummel.gif",
          "DrMarioSuperJumpPunch.gif",
          "DrMarioSuperSheet.gif",
          "DrMarioUAir.gif",
          "DrMarioUSmash.gif",
          "DrMarioUThrow.gif",
          "DrMarioUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dr_mario);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.DrMariomoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/dr_mario/" + DrMariomoves[position];
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
