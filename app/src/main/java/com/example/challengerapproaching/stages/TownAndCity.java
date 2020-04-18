package com.example.challengerapproaching.stages;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;

/** This class sets the content view to Town and City's xml
 * file when the respective button is pushed.*/

public class TownAndCity extends AppCompatActivity {//NOPMD

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_town_and_city);
  }
}
