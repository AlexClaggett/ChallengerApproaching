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

/** This class sets the content view to Link's xml
 * file when the respective button is pushed.*/

public class Link extends AppCompatActivity {

  String [] Linkmoves = {
//          "LinkArrow.png",
          "LinkBAir.gif",
//          "LinkBoomerang.png",
          "LinkBThrow.gif",
          "LinkDAir.gif",
          "LinkDashAttack.gif",
          "LinkDashGrab.gif",
          "LinkDSmash.gif",
          "LinkDThrow.gif",
          "LinkDTilt.gif",
          "LinkFAir.gif",
          "LinkFSmash1.gif",
          "LinkFSmash2.gif",
          "LinkFThrow.gif",
          "LinkFTilt.gif",
          "LinkGrab.gif",
          "LinkJab1.gif",
          "LinkJab2.gif",
          "LinkJab3.gif",
          "LinkNAir.gif",
          "LinkPivotGrab.gif",
          "LinkPummel.gif",
          "LinkSpinAttackA.gif",
          "LinkSpinAttackG.gif",
          "LinkUAir.gif",
          "LinkUSmash.gif",
          "LinkUThrow.gif",
          "LinkUTilt.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_link);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Linkmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/link/" + Linkmoves[position];
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

