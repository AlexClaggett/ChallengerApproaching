package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Incineroar's xml
 * file when the respective button is pushed.*/

public class Incineroar extends AppCompatActivity {

  String [] Incineroarmoves = {
          "IncineroarAlolanWhipA.gif",
          "IncineroarAlolanWhipEarly.gif",
          "IncineroarAlolanWhipFailure.gif",
          "IncineroarAlolanWhipG.gif",
          "IncineroarAlolanWhipLariat.gif",
          "IncineroarBAir.gif",
          "IncineroarBThrow.gif",
          "IncineroarCrossChopFall.gif",
          "IncineroarCrossChopLanding.gif",
          "IncineroarCrossChopRise.gif",
          "IncineroarDAir.gif",
          "IncineroarDarkestLariatA.gif",
          "IncineroarDarkestLariatG.gif",
          "IncineroarDashAttack.gif",
          "IncineroarDashGrab.gif",
          "IncineroarDSmash.gif",
          "IncineroarDThrow.gif",
          "IncineroarDTilt.gif",
          "IncineroarFAir.gif",
          "IncineroarFSmash.gif",
          "IncineroarFThrow.gif",
          "IncineroarFTilt.gif",
          "IncineroarFTiltDown.gif",
          "IncineroarFTiltUp.gif",
          "IncineroarGrab.gif",
          "IncineroarJab1.gif",
          "IncineroarJab2.gif",
          "IncineroarJab3.gif",
          "IncineroarNAir.gif",
          "IncineroarPivotGrab.gif",
          "IncineroarPummel.gif",
          "IncineroarRevenge.gif",
          "IncineroarUAir.gif",
          "IncineroarUSmash.gif",
          "IncineroarUThrow.gif",
          "IncineroarUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_incineroar);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/incineroar/" + Incineroarmoves[position];
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
