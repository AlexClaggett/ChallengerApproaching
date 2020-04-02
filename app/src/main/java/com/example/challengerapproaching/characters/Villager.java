package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Villager's xml
 * file when the respective button is pushed.*/

public class Villager extends AppCompatActivity {

  String [] Villagermoves = {
          "VillagerBAir.gif",
//          "VillagerBalloonHurtbox.png",
          "VillagerBThrow.gif",
          "VillagerDAir1.gif",
          "VillagerDAir2.gif",
          "VillagerDAir3.gif",
          "VillagerDashAttack.gif",
          "VillagerDashGrab.gif",
          "VillagerDSmash.gif",
          "VillagerDThrow.gif",
          "VillagerDTilt.gif",
          "VillagerFAir.gif",
          "VillagerFSmash.gif",
          "VillagerFThrow.gif",
          "VillagerFTilt.gif",
          "VillagerGrab.gif",
          "VillagerJab1.gif",
          "VillagerJab1End.gif",
          "VillagerJab2.gif",
          "VillagerJab2End.gif",
//          "VillagerLloidRocketExplosion.png",
//          "VillagerLloidRocketFall.png",
//          "VillagerLloidRocketFly.png",
//          "VillagerLloidRocketWallExplosion.png",
          "VillagerNAir.gif",
          "VillagerPivotGrab.gif",
          "VillagerPocket.gif",
          "VillagerPummel.gif",
          "VillagerTimberAxe.gif",
          "VillagerTimberFall.gif",
          "VillagerTimberGrowth.gif",
          "VillagerUAir1.gif",
          "VillagerUAir2.gif",
          "VillagerUAir3.gif",
          "VillagerUSmash.gif",
          "VillagerUThrow.gif",
          "VillagerUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_villager);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/villager/" + Villagermoves[position];
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
