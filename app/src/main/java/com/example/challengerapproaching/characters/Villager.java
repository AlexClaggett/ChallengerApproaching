package com.example.challengerapproaching.characters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;
import java.io.IOException;
import java.io.InputStream;

/** This class sets the content view to Villager's xml
 * file when the respective button is pushed.*/

public class Villager extends AppCompatActivity {

  transient String [] villagerMoves = {
      "VillagerBAir.gif",
      "VillagerBalloonHurtbox.png",
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
      "VillagerLloidRocketExplosion.png",
      "VillagerLloidRocketFall.png",
      "VillagerLloidRocketFly.png",
      "VillagerLloidRocketWallExplosion.png",
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
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_villager);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Villagermoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/villager/" + villagerMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bm = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bm);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          imageView.setVisibility(View.INVISIBLE);
          try {
            gifImageView.setGifImageUrl(toUrl);
            gifImageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }


      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

  }
}
