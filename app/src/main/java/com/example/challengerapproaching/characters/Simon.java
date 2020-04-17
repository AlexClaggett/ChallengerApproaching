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

/** This class sets the content view to Simon's xml
 * file when the respective button is pushed.*/

public class Simon extends AppCompatActivity {

  String [] simonMoves = {
      "SimonAxe.gif",
      "SimonBAir.gif",
      "SimonBAirDown.gif",
      "SimonBAirUp.gif",
      "SimonBThrow.gif",
      "SimonCross.png",
      "SimonDAir.gif",
      "SimonDashAttack.gif",
      "SimonDashGrab.gif",
      "SimonDSmash.gif",
      "SimonDThrow.gif",
      "SimonDTilt1.gif",
      "SimonDTilt2.gif",
      "SimonFAir.gif",
      "SimonFAirDown.gif",
      "SimonFAirUp.gif",
      "SimonFSmash.gif",
      "SimonFSmashDown.gif",
      "SimonFSmashUp.gif",
      "SimonFThrow.gif",
      "SimonFTilt.gif",
      "SimonGrab.gif",
      "SimonJab1.gif",
      "SimonJab2.gif",
      "SimonJabRapid.gif",
      "SimonJabRapidEnd.gif",
      "SimonNAir.gif",
      "SimonPivotGrab.gif",
      "SimonPummel.gif",
      "SimonUAir.gif",
      "SimonUppercut.gif",
      "SimonUSmash.gif",
      "SimonUThrow.gif",
      "SimonUTilt.gif"
  };

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_simon);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Simonmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        ImageView imageView = findViewById(R.id.imageView3);
        String toUrl = "https://ultimateframedata.com/hitboxes/simon/" + simonMoves[position];
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
