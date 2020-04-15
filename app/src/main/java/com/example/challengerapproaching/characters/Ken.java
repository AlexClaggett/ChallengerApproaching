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

/** This class sets the content view to Ken's xml
 * file when the respective button is pushed.*/

public class Ken extends AppCompatActivity {

  String [] Kenmoves = {
          "KenBAir.gif",
          "KenBThrow.gif",
          "KenDAir.gif",
          "KenDashAttack.gif",
          "KenDashGrab.gif",
          "KenDSmash.gif",
          "KenDThrow.gif",
          "KenDTiltHeavy.gif",
          "KenDTiltLight.gif",
          "KenFAir.gif",
          "KenFocusAttackLv1.gif",
          "KenFocusAttackLv2.gif",
          "KenFocusAttackLv3.gif",
          "KenFSmash.gif",
          "KenFThrow.gif",
          "KenFTiltHeavy.gif",
          "KenFTiltLight.gif",
          "KenFTiltProximity.gif",
          "KenGrab.gif",
          "KenJab1.gif",
          "KenJab2.gif",
          "KenJab3.gif",
          "KenJabHeavy.gif",
          "KenJabProximity.gif",
          "KenNAir.gif",
          "KenNataOtoshiGeri.gif",
          "KenOosotoMawashiGeri.gif",
          "KenPivotGrab.gif",
          "KenPummel.gif",
          "KenShoryukenHeavy.gif",
          "KenShoryukenHeavyInput.gif",
          "KenShoryukenLight.gif",
          "KenShoryukenLightInput.gif",
          "KenShoryukenMedium.gif",
          "KenShoryukenMediumInput.gif",
          "KenTatsumakiSenpukyakuStart.gif",
          "KenTatsumakiSenpukyakuStrong.gif",
          "KenTatsumakiSenpukyakuStrongGrounded.gif",
          "KenTatsumakiSenpukyakuWeak.gif",
          "KenTatsumakiSenpukyakuWeakGrounded.gif",
          "KenUAir.gif",
          "KenUSmash.gif",
          "KenUThrow.gif",
          "KenUTiltHeavy.gif",
          "KenUTiltLight.gif",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ken);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Kenmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ken/" + Kenmoves[position];
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
