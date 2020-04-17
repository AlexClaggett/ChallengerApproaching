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

/** This class sets the content view to Snake's xml
 * file when the respective button is pushed.*/

public class Snake extends AppCompatActivity {

  //Array of Snake's Framedata files
  transient String [] snakeMoves = {
      "SnakeBAir.gif",
      "SnakeBThrow.gif",
      "SnakeC4.png",
      "SnakeCypher.png",
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
      "SnakeUSmashExplosion.png",
      "SnakeUSmashSearch.png",
      "SnakeUThrow.gif",
      "SnakeUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_snake);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Snakemoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/snake/" + snakeMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
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
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });
  }
}