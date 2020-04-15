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

/** This class sets the content view to Isabelle's xml
 * file when the respective button is pushed.*/

public class Isabelle extends AppCompatActivity {

  String [] Isabellemoves = {
          "IsabelleBAir.gif",
//          "IsabelleBalloonHurtbox.png",
          "IsabelleBThrow.gif",
          "IsabelleDAir.gif",
//          "IsabelleDashAttack.png",
          "IsabelleDashGrab.gif",
          "IsabelleDSmash.gif",
          "IsabelleDThrow.gif",
          "IsabelleDTilt.gif",
          "IsabelleFAir.gif",
          "IsabelleFishingRodBThrow.gif",
          "IsabelleFishingRodDThrow.gif",
          "IsabelleFishingRodFThrow.gif",
          "IsabelleFishingRodUThrow.gif",
          "IsabelleFSmash.gif",
          "IsabelleFThrow.gif",
          "IsabelleFTilt.gif",
          "IsabelleGrab.gif",
          "IsabelleJab.gif",
          "IsabelleNAir.gif",
          "IsabellePivotGrab.gif",
          "IsabellePocket.gif",
          "IsabellePummel.gif",
          "IsabelleUAir.gif",
          "IsabelleUSmash.gif",
          "IsabelleUThrow.gif",
          "IsabelleUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_isabelle);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Isabellemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/isabelle/" + Isabellemoves[position];
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
