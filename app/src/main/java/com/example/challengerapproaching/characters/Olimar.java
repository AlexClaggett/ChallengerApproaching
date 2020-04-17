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

/** This class sets the content view to Olimar's xml
 * file when the respective button is pushed.*/

public class Olimar extends AppCompatActivity {

  /** Array of Olimar's Framedata files */
  transient String [] olimarMoves = {
      "OlimarBThrow.gif",
      "OlimarDashAttack.gif",
      "OlimarDThrow.gif",
      "OlimarDTilt.gif",
      "OlimarFThrow.gif",
      "OlimarFTilt.gif",
      "OlimarJab1.gif",
      "OlimarJab2.gif",
      "OlimarNAir.gif",
      "OlimarPikminOrder.gif",
      "OlimarPummel.gif",
      "OlimarUThrow.gif",
      "OlimarUTilt.gif",
      "BlueBAir.gif",
      "BlueDAir.gif",
      "BlueDSmash.gif",
      "BlueFAir.gif",
      "BlueFSmash.png",
      "BlueGrab.gif",
      "BluePikminThrow.gif",
      "BlueUAir.gif",
      "BlueUSmash.gif",
      "BlueUThrow.gif",
      "PurpleBAir.gif",
      "PurpleDAir.gif",
      "PurpleDSmash.gif",
      "PurpleFAir.gif",
      "PurpleFSmash.png",
      "PurpleGrab.gif",
      "PurplePikminThrow.gif",
      "PurpleUAir.gif",
      "PupleUThrow.gif",
      "PurpleUSmash.gif",
      "RedBAir.gif",
      "RedDAir.gif",
      "RedDSmash.gif",
      "RedFAir.gif",
      "RedFSmash.png",
      "RedGrab.gif",
      "RedPikminThrow.gif",
      "RedUAir.gif",
      "RedUSmash.gif",
      "RedUThrow.gif",
      "WhiteBAir.gif",
      "WhiteDAir.gif",
      "WhiteDSmash.gif",
      "WhiteFAir.gif",
      "WhiteFSmash.png",
      "WhiteGrab.gif",
      "WhitePikminThrow.gif",
      "WhiteUAir.gif",
      "WhiteUSmash.gif",
      "WhiteUThrow.gif",
      "YellowBAir.gif",
      "YellowDAir.gif",
      "YellowDSmash.gif",
      "YellowFAir.gif",
      "YellowFSmash.png",
      "YellowGrab.gif",
      "YellowPikminThrow.gif",
      "YellowUAir.gif",
      "YellowUSmash.gif",
      "YellowUThrow.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_olimar);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Olimarmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/olimar/" + olimarMoves[position];
        if (toUrl.endsWith("png")) {
          gifImageView.setVisibility(View.INVISIBLE);
          try {
            final InputStream inputStream = new java.net.URL(toUrl).openStream();
            final Bitmap bmmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bmmap);
            imageView.setVisibility(View.VISIBLE);
          } catch (IOException e){
            imageView.setVisibility(View.INVISIBLE);
          }
        } else {
          imageView.setVisibility(View.INVISIBLE);
          try {
            gifImageView.setGifImageUrl(toUrl);
            gifImageView.setVisibility(View.VISIBLE);
          } catch (IOException e) {
            gifImageView.setVisibility(View.INVISIBLE);
          }
        }
      }

      @Override
      public void onNothingSelected(final AdapterView<?> parent) {

      }
    });

  }
}
