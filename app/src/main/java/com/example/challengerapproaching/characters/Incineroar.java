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

/** This class sets the content view to Incineroar's xml
 * file when the respective button is pushed.*/

public class Incineroar extends AppCompatActivity {

  //Array of Incineroar's Framedata files
  transient String [] incineroarMoves = {
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
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_incineroar);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Incineroarmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final String toUrl = "https://ultimateframedata.com/hitboxes/incineroar/" + incineroarMoves[position];
        try {
          gifImageView.setGifImageUrl(toUrl);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });

  }


}
