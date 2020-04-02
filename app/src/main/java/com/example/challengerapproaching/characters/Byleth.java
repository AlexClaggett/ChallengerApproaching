package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Byleth's xml
 * file when the respective button is pushed.*/

public class Byleth extends AppCompatActivity {

  String [] Bylethmoves = {
          "BylethAreadbharAerial.gif",
          "BylethAreadbharGrounded.gif",
          "BylethAymr.gif",
          "BylethAymrSuperArmor.gif",
          "BylethBAir.gif",
          "BylethBThrow.gif",
          "BylethDAir.gif",
          "BylethDashAttack.gif",
          "BylethDashGrab.gif",
          "BylethDSmash.gif",
          "BylethDThrow.gif",
          "BylethDTilt.gif",
          "BylethFailnaught.gif",
          "BylethFailnaughtMax.gif",
//          "BylethFailnaughtMax.png",
          "BylethFAir.gif",
          "BylethFSmash.gif",
          "BylethFSmashDown.gif",
          "BylethFSmashUp.gif",
          "BylethFThrow.gif",
          "BylethFTilt.gif",
          "BylethGrab.gif",
          "BylethJab1.gif",
          "BylethJab2.gif",
          "BylethJab3.gif",
          "BylethJabRapid.gif",
          "BylethJapRapidFinisher.gif",
          "BylethNAir.gif",
          "BylethNAirLanding.gif",
          "BylethPivotGrab.gif",
          "BylethPummel.gif",
          "BylethSwordoftheCreatorAerial.gif",
          "BylethSwordoftheCreatorGrounded.gif",
          "BylethUAir.gif",
          "BylethUSmash.gif",
          "BylethUThrow.gif",
          "BylethUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bylthe);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/byleth/" + Bylethmoves[position];
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