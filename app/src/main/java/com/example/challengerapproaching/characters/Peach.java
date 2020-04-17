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

/** This class sets the content view to Peach's xml
 * file when the respective button is pushed.*/

public class Peach extends AppCompatActivity {

  /** Array of Peach's Framedata files */
  transient String [] peachMoves = {
      "PeachBAir.gif",
      "PeachBThrow.gif",
      "PeachDAir.gif",
      "PeachDashAttack.gif",
      "PeachDashGrab.gif",
      "PeachDSmash.gif",
      "PeachDThrow.gif",
      "PeachDTilt.gif",
      "PeachFAir.gif",
      "PeachFSmashFryingPan.gif",
      "PeachFSmashGolfClub.gif",
      "PeachFSmashTennisRacket.gif",
      "PeachFThrow.gif",
      "PeachFTilt.gif",
      "PeachGrab.gif",
      "PeachJab1.gif",
      "PeachJab2.gif",
      "PeachNAir.gif",
      "PeachPeachBomber.png",
      "PeachPeachBomberHit.gif",
      "PeachPeachParasol.gif",
      "PeachPeachParasolFall.gif",
      "PeachPivotGrab.gif",
      "PeachPummel.gif",
      "PeachUAir.gif",
      "PeachUSmash.gif",
      "PeachUThrow.gif",
      "PeachUTilt.gif"
  };

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_peach);

    final ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            R.layout.selectmove_spinner_design,
            getResources().getStringArray(R.array.Peachmoves)
    );
    adapter.setDropDownViewResource(R.layout.selectmove_spinner_dropdown);

    final Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setAdapter(adapter);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long idName) {
        final GifImageView gifImageView = findViewById(R.id.GifImageView);
        final ImageView imageView = findViewById(R.id.imageView3);
        final String toUrl = "https://ultimateframedata.com/hitboxes/peach/" + peachMoves[position];
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
