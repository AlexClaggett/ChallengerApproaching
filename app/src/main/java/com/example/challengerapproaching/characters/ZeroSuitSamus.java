package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Zero Suit Samus's xml
 * file when the respective button is pushed.*/

public class ZeroSuitSamus extends AppCompatActivity {

  String [] ZeroSuitSamusmoves = {
          "ZeroSuitSamusBAir.gif",
          "ZeroSuitSamusBoostKickA.gif",
          "ZeroSuitSamusBoostKickG.gif",
          "ZeroSuitSamusBThrow.gif",
          "ZeroSuitSamusDAir.gif",
          "ZeroSuitSamusDAirLanding.gif",
          "ZeroSuitSamusDashAttack.gif",
          "ZeroSuitSamusDSmash.gif",
          "ZeroSuitSamusDThrow.gif",
          "ZeroSuitSamusDTilt.gif",
          "ZeroSuitSamusFAir.gif",
          "ZeroSuitSamusFlipJumpFootstool.gif",
          "ZeroSuitSamusFlipJumpKick.gif",
          "ZeroSuitSamusFSmash.gif",
          "ZeroSuitSamusFSmashDown.gif",
          "ZeroSuitSamusFSmashUp.gif",
          "ZeroSuitSamusFThrow.gif",
          "ZeroSuitSamusFTilt.gif",
          "ZeroSuitSamusFTiltDown.gif",
          "ZeroSuitSamusFTiltUp.gif",
          "ZeroSuitSamusJab1.gif",
          "ZeroSuitSamusJab2.gif",
          "ZeroSuitSamusJab3.gif",
          "ZeroSuitSamusNAir.gif",
          "ZeroSuitSamusPlasmaWhip.gif",
          "ZeroSuitSamusPlasmaWhipUp.gif",
          "ZeroSuitSamusPummel.gif",
          "ZeroSuitSamusUAir.gif",
          "ZeroSuitSamusUSmash.gif",
          "ZeroSuitSamusUThrow.gif",
          "ZeroSuitSamusUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zero__suit__samus);


    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/zero_suit_samus/" + ZeroSuitSamusmoves[position];
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
