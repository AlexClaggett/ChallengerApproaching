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

/** This class sets the content view to Mario's xml
 * file when the respective button is pushed.*/

public class Mario extends AppCompatActivity {

  String [] marioMoves = {
      "MarioBAir.gif",
      "MarioBThrow.gif",
      "MarioCape.gif",
      "MarioDAir.gif",
      "MarioDAirLanding.gif",
      "MarioDashAttack.gif",
      "MarioDashGrab.gif",
      "MarioDSmash.gif",
      "MarioDThrow.gif",
      "MarioDTilt.gif",
      "MarioFAir.gif",
      "MarioFSmash.gif",
      "MarioFSmashDown.gif",
      "MarioFSmashUp.gif",
      "MarioFThrow.gif",
      "MarioFTilt.gif",
      "MarioFTiltDown.gif",
      "MarioFTiltUp.gif",
      "MarioGrab.gif",
      "MarioJab1.gif",
      "MarioJab2.gif",
      "MarioJab3.gif",
      "MarioNAir.gif",
      "MarioPivotGrab.gif",
      "MarioPummel.gif",
      "MarioSuperJumpPunch.gif",
      "MarioUAir.gif",
      "MarioUSmash.gif",
      "MarioUThrow.gif",
      "MarioUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mario);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Mariomoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toUrl = "https://ultimateframedata.com/hitboxes/mario/" + marioMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
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

