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

/** This class sets the content view to Ryu's xml
 * file when the respective button is pushed.*/

public class Ryu extends AppCompatActivity {

  String [] ryuMoves = {
      "RyuBAir.gif",
      "RyuBThrow.gif",
      "RyuDAir.gif",
      "RyuDashAttack.gif",
      "RyuDashGrab.gif",
      "RyuDSmash.gif",
      "RyuDThrow.gif",
      "RyuDTiltHeavy.gif",
      "RyuDTiltLight.gif",
      "RyuFAir.gif",
      "RyuFocusAttackLvl1.gif",
      "RyuFocusAttackLvl2.gif",
      "RyuFocusAttackLvl3.gif",
      "RyuFSmash.gif",
      "RyuFThrow.gif",
      "RyuFTiltHeavy.gif",
      "RyuFTiltLight.gif",
      "RyuFTiltLightClose.gif",
      "RyuGrab.gif",
      "RyuJab1.gif",
      "RyuJab2.gif",
      "RyuJab3.gif",
      "RyuJabHeavy.gif",
      "RyuJabHeavyClose.gif",
      "RyuNAir.gif",
      "RyuPivotGrab.gif",
      "RyuPummel.gif",
      "RyuShoryukenHeavy.gif",
      "RyuShoryukenHeavyInput.gif",
      "RyuShoryukenLight.gif",
      "RyuShoryukenLightInput.gif",
      "RyuShoryukenMedium.gif",
      "RyuShoryukenMediumInput.gif",
      "RyuTatsumakiSenpukyakuHeavy.gif",
      "RyuTatsumakiSenpukyakuHeavyGrounded.gif",
      "RyuTatsumakiSenpukyakuLight.gif",
      "RyuTatsumakiSenpukyakuLightGrounded.gif",
      "RyuTatsumakiSenpukyakuMedium.gif",
      "RyuTatsumakiSenpukyakuMediumGrounded.gif",
      "RyuUAir.gif",
      "RyuUSmash.gif",
      "RyuUThrow.gif",
      "RyuUTiltHeavy.gif",
      "RyuUTiltLight.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ryu);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Ryumoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/ryu/" + ryuMoves[position];
        try {
          gifImageView.setGifImageUrl(toURL);
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
