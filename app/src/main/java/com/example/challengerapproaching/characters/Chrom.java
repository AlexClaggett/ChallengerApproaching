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

/** This class sets the content view to Chrom's xml
 * file when the respective button is pushed.*/

public class Chrom extends AppCompatActivity {

  String [] Chrommoves2 = {
          "ChromBAir.gif",
          "ChromBThrow.gif",
          "ChromCounter.gif",
          "ChromCounterHit.gif",
          "ChromDAir.gif",
          "ChromDashAttack.gif",
          "ChromDashGrab.gif",
          "ChromDoubleEdgedDance1.gif",
          "ChromDoubleEdgedDance2.gif",
          "ChromDoubleEdgedDance2Up.gif",
          "ChromDoubleEdgedDance3.gif",
          "ChromDoubleEdgedDance3Down.gif",
          "ChromDoubleEdgedDance3Up.gif",
          "ChromDoubleEdgedDance4.gif",
          "ChromDoubleEdgedDance4Down.gif",
          "ChromDoubleEdgedDance4Up.gif",
          "ChromDSmash.gif",
          "ChromDThrow.gif",
          "ChromDTilt.gif",
          "ChromFAir.gif",
          "ChromFlareBlade.gif",
          "ChromFlareBladeMax.gif",
          "ChromFSmash.gif",
          "ChromFThrow.gif",
          "ChromFTilt.gif",
          "CHromGrab.gif",
          "ChromJab.gif",
          "ChromNAir.gif",
          "ChromPivotGrab.gif",
          "ChromPummel.gif",
          "ChromSoaringSlash.gif",
          "ChromSoaringSlashDescent.gif",
          "ChromSoaringSlashLanding.gif",
          "ChromUAir.gif",
          "ChromUSmash.gif",
          "ChromUThrow.gif",
          "ChromUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chrom);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Chrommoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/chrom/" + Chrommoves2[position];
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