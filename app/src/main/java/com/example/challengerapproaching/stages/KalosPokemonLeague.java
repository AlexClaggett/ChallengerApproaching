package com.example.challengerapproaching.stages;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;

/** This class sets the content view to Kalos Pokemon League's xml
 * file when the respective button is pushed.*/

public class KalosPokemonLeague extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_kalos_pokemon_league);
  }
}
