package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Lucas's xml
 * file when the respective button is pushed.*/

public class Lucas extends AppCompatActivity {

  String [] Lucasmoves = {
          "LucasBAir.gif",
          "LucasBThrow.gif",
          "LucasDAir.gif",
          "LucasDashAttack.gif",
          "LucasDSmash.gif",
          "LucasDThrow.gif",
          "LucasDTilt.gif",
          "LucasFAir.gif",
          "LucasFSmash.gif",
          "LucasFThrow.gif",
          "LucasFTilt.gif",
          "LucasFTiltDown.gif",
          "LucasFTiltUp.gif",
          "LucasJab1.gif",
          "LucasJab2.gif",
          "LucasJab3.gif",
          "LucasNAir.gif",
          "LucasPKFireA.gif",
//          "LucasPKFireBurst.png",
          "LucasPKFireG.gif",
//          "LucasPKFreeze.png",
          "LucasPKThunder2.gif",
          "LucasPSIMagnet.gif",
          "LucasPummel.gif",
          "LucasUAir.gif",
          "LucasUSmash.gif",
          "LucasUThrow.gif",
          "LucasUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lucas);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/lucas/" + Lucasmoves[position];
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

