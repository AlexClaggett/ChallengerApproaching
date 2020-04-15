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

/** This class sets the content view to Olimar's xml
 * file when the respective button is pushed.*/

public class Olimar extends AppCompatActivity {

  String [] Olimarmoves = {
          "OlimarBThrow.gif",
          "OlimarDashAttack.gif",
          "OlimarDThrow.gif",
          "OlimarDTilt.gif",
          "OlimarFThrow.gif",
          "OlimarFTilt.gif",
          "OlimarJab1.gif",
          "OlimarJab2.gif",
          "OlimarNAir.gif",
          "OlimarPikminOrder.gif",
          "OlimarPummel.gif",
          "OlimarUThrow.gif",
          "OlimarUTilt.gif",
          "BlueBAir.gif",
          "BlueDAir.gif",
          "BlueDSmash.gif",
          "BlueFAir.gif",
//          "BlueFSmash.png",
          "BlueGrab.gif",
          "BluePikminThrow.gif",
          "BlueUAir.gif",
          "BlueUSmash.gif",
          "BlueUThrow.gif",
          "PupleUThrow.gif",
          "PurpleBAir.gif",
          "PurpleDAir.gif",
          "PurpleDSmash.gif",
          "PurpleFAir.gif",
//          "PurpleFSmash.png",
          "PurpleGrab.gif",
          "PurplePikminThrow.gif",
          "PurpleUAir.gif",
          "PurpleUSmash.gif",
          "RedBAir.gif",
          "RedDAir.gif",
          "RedDSmash.gif",
          "RedFAir.gif",
//          "RedFSmash.png",
          "RedGrab.gif",
          "RedPikminThrow.gif",
          "RedUAir.gif",
          "RedUSmash.gif",
          "RedUThrow.gif",
          "WhiteBAir.gif",
          "WhiteDAir.gif",
          "WhiteDSmash.gif",
          "WhiteFAir.gif",
//          "WhiteFSmash.png",
          "WhiteGrab.gif",
          "WhitePikminThrow.gif",
          "WhiteUAir.gif",
          "WhiteUSmash.gif",
          "WhiteUThrow.gif",
          "YellowBAir.gif",
          "YellowDAir.gif",
          "YellowDSmash.gif",
          "YellowFAir.gif",
//          "YellowFSmash.png",
          "YellowGrab.gif",
          "YellowPikminThrow.gif",
          "YellowUAir.gif",
          "YellowUSmash.gif",
          "YellowUThrow.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_olimar);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Olimarmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/olimar/" + Olimarmoves[position];
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
