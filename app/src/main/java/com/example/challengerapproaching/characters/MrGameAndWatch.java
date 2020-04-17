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

/** This class sets the content view to Mr Game and Watch's xml
 * file when the respective button is pushed.*/

public class MrGameAndWatch extends AppCompatActivity {

  String [] mrGameWatchmoves = {
      "MrGame_WatchBair.gif",
      "MrGame_WatchBairLanding.gif",
      "MrGame_WatchBThrow.gif",
      "MrGame_WatchChef.gif",
      "MrGame_WatchChef.png",
      "MrGame_WatchDair.gif",
      "MrGame_WatchDairLanding.gif",
      "MrGame_WatchDashAttack.gif",
      "MrGame_WatchDashGrab.gif",
      "MrGame_WatchDSmash.gif",
      "MrGame_WatchDThrow.gif",
      "MrGame_WatchDTilt.gif",
      "MrGame_WatchFAir.gif",
      "MrGame_WatchFireA.gif",
      "MrGame_WatchFSmash.gif",
      "MrGame_WatchFThrow.gif",
      "MrGame_WatchFTilt.gif",
      "MrGame_WatchGrab.gif",
      "MrGame_WatchJab.gif",
      "MrGame_WatchJabRapid.gif",
      "MrGame_WatchJabRapidEnd.gif",
      "MrGame_WatchJudge1.gif",
      "MrGame_WatchJudge2.gif",
      "MrGame_WatchJudge3.gif",
      "MrGame_WatchJudge4.gif",
      "MrGame_WatchJudge5.gif",
      "MrGame_WatchJudge6.gif",
      "MrGame_WatchJudge7.gif",
      "MrGame_WatchJudge8.gif",
      "MrGame_WatchJudge9.gif",
      "MrGame_WatchNAir.gif",
      "MrGame_WatchOilPanic.gif",
      "MrGame_WatchOilPanic.png",
      "MrGame_WatchPivotGrab.gif",
      "MrGame_WatchPummel.gif",
      "MrGame_WatchUAir.gif",
      "MrGame_WatchUSmash.gif",
      "MrGame_WatchUThrow.gif",
      "MrGame_WatchUTilt.gif"
  };


  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_mr__game_and__watch);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.MrGame_Watchmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/mr_game_and_watch/" + mrGameWatchmoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            InputStream inputStream = new java.net.URL(toUrl).openStream();
            Bitmap bm = BitmapFactory.decodeStream(inputStream);
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