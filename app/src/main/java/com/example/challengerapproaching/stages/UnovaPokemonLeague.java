package com.example.challengerapproaching.stages;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;

/** This class sets the content view to Unova Pokemon League's xml
 * file when the respective button is pushed.*/

public class UnovaPokemonLeague extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_unova_pokemon_league);
  }
}
