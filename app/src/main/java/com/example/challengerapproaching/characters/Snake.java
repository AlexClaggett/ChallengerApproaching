package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;

import java.io.IOException;

/** This class sets the content view to Snake's xml
 * file when the respective button is pushed.*/

public class Snake extends AppCompatActivity {

  String [] Snakemoves = {
//          "C420Explosion20Snake20for20Scale.png",
//          "Nikita20Explosion20Strong.png",
//          "Nikita20Explosion20Weak.png",
//          "Nikita20Hurtbox20Weak.png",
          "SnakeBAir.gif",
          "SnakeBThrow.gif",
//          "SnakeC4.png",
//          "SnakeCypher.png",
          "SnakeDAir.gif",
          "SnakeDashAttack.gif",
          "SnakeDashGrab.gif",
          "SnakeDSmash.gif",
          "SnakeDThrow.gif",
          "SnakeDTilt.gif",
          "SnakeFAir.gif",
          "SnakeFSmash.gif",
          "SnakeFThrow.gif",
          "SnakeFTilt1.gif",
          "SnakeFTilt2.gif",
          "SnakeGrab.gif",
          "SnakeJab1.gif",
          "SnakeJab2.gif",
          "SnakeJab3.gif",
          "SnakeNAir.gif",
          "SnakePivotGrab.gif",
          "SnakePummel.gif",
          "SnakeUAir.gif",
          "SnakeUSmash.gif",
//          "SnakeUSmashExplosion.png",
//          "SnakeUSmashSearch.png",
          "SnakeUThrow.gif",
          "SnakeUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_snake);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        String toURL = "https://ultimateframedata.com/hitboxes/snake/" + Snakemoves[position];
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