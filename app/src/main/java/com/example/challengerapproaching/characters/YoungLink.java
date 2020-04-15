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

/** This class sets the content view to Young Link's xml
 * file when the respective button is pushed.*/

public class YoungLink extends AppCompatActivity {

  String [] YoungLinkmoves = {
//          "YoungLinkArrow.png",
          "YoungLinkBAir.gif",
//          "YoungLinkBoomerang.png",
          "YoungLinkBThrow.gif",
          "YoungLinkDAir.gif",
          "YoungLinkDashAttack.gif",
          "YoungLinkDashGrab.gif",
          "YoungLinkDSmash.gif",
          "YoungLinkDThrow.gif",
          "YoungLinkDTilt.gif",
          "YoungLinkFAir.gif",
          "YoungLinkFSmash1.gif",
          "YoungLinkFSmash2.gif",
          "YoungLinkFThrow.gif",
          "YoungLinkFTilt.gif",
          "YoungLinkGrab.gif",
          "YoungLinkJab1.gif",
          "YoungLinkJab2.gif",
          "YoungLinkJab3.gif",
          "YoungLinkJabRapid.gif",
          "YoungLinkJabRapidEnd.gif",
          "YoungLinkNAir.gif",
          "YoungLinkPivotGrab.gif",
          "YoungLinkPummel.gif",
          "YoungLinkSpinAttackA.gif",
          "YoungLinkSpinAttackG.gif",
          "YoungLinkUAir.gif",
          "YoungLinkUSmash.gif",
          "YoungLinkUThrow.gif",
          "YoungLinkUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_young__link);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.YoungLinkmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/young_link/" + YoungLinkmoves[position];
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