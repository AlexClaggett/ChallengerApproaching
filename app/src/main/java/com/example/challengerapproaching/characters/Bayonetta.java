package com.example.challengerapproaching.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import com.example.challengerapproaching.utils.GifImageView;


/** This class sets the content view to Bayonetta's xml
 * file when the respective button is pushed.*/

public class Bayonetta extends AppCompatActivity {

  int [] images = {R.drawable.afterburnerkickdown, R.drawable.afterburnerkicklanding, R.drawable.afterburnerkickup,
          R.drawable.bair, R.drawable.bthrow, R.drawable.dair,R.drawable.dairlanding,R.drawable.dashattack, R.drawable.dashgrab,
          R.drawable.dsmash, R.drawable.dsmashstomp, R.drawable.dthrow, R.drawable.dtilt, R.drawable.fair2,R.drawable.fair3,
          R.drawable.fair201, R.drawable.fsmash,R.drawable.fthrow, R.drawable.ftilt1, R.drawable.ftilt2,
          R.drawable.ftilt3, R.drawable.grab, R.drawable.heelslide, R.drawable.heelslideend, R.drawable.jab1,
          R.drawable.jab2, R.drawable.jab3, R.drawable.jabrapid, R.drawable.jabrapidend, R.drawable.nair,
          R.drawable.pivotgrab, R.drawable.pummel, R.drawable.uair, R.drawable.usmash, R.drawable.uthrow,
          R.drawable.utilt, R.drawable.witchtime, R.drawable.witchtwista,R.drawable.witchtwistg};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bayonetta);



    Spinner spnLocale = findViewById(R.id.spinner2);
    spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GifImageView gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setGifImageResource(images[position]);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }
}