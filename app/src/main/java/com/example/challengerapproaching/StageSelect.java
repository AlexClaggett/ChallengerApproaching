package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.stages.BattleField;
import com.example.challengerapproaching.stages.FinalDestination;
import com.example.challengerapproaching.stages.KalosPokemonLeague;
import com.example.challengerapproaching.stages.LylatCruise;
import com.example.challengerapproaching.stages.PokemonStadium;
import com.example.challengerapproaching.stages.PokemonStadium2;
import com.example.challengerapproaching.stages.Smashville;
import com.example.challengerapproaching.stages.TownAndCity;
import com.example.challengerapproaching.stages.UnovaPokemonLeague;
import com.example.challengerapproaching.stages.YoshiIsland;
import com.example.challengerapproaching.stages.YoshisStory;

/**********************************************************************
 * This class generates the stage select screen by
 * setting the contentview, instantiating buttons, and setting
 * their listeners to their respective classes.
 *********************************************************************/

public class StageSelect extends AppCompatActivity {

  /** Button For Battle Field. */
  ImageButton battleField;

  /** Button For Final Destination. */
  ImageButton finalDestination;

  /** Button For Kalos Pokemon League. */
  ImageButton kalosPokemonLeague;

  /** Button For Lylat Cruise. */
  ImageButton lylatCruise;

  /** Button For Pokemon Stadium. */
  ImageButton pokemonStadium;

  /** Button For Pokemon Stadium 2. */
  ImageButton pokemonStadium2;

  /** Button For Smashville. */
  ImageButton smashville;

  /** Button For Town and City. */
  ImageButton townAndCity;

  /** Button For Unova Pokemon League. */
  ImageButton unovaPokemonLeague;

  /** Button For Yoshi's Island.*/
  ImageButton yoshiIsland;

  /** Button For Yoshi's Story. */
  ImageButton yoshisStory;

  /** Button array of the stage buttons. */
  ImageButton [] buttons = {battleField, finalDestination, kalosPokemonLeague,
      lylatCruise, pokemonStadium, pokemonStadium2,
      smashville, townAndCity, unovaPokemonLeague,
      yoshiIsland, yoshisStory};

  /** Array of integers of the stage ids found in the XML. */
  int [] ids = {R.id.BattleField, R.id.FinalDestination, R.id.KalosPokemonStadium,
    R.id.LylatCruise, R.id.PokemonStadium, R.id.PokemonStadium2,
    R.id.Smashville, R.id.TownAndCity, R.id.UnovaPokemonLeague,
    R.id.YoshiIsland, R.id.YoshisStory};

  /** Array of Classes for each stage. */
  Class [] charClasses = {BattleField.class, FinalDestination.class,
    KalosPokemonLeague.class, LylatCruise.class, PokemonStadium.class,
    PokemonStadium2.class, Smashville.class, TownAndCity.class,
    UnovaPokemonLeague.class, YoshiIsland.class, YoshisStory.class};

  /********************************************************************
   * Upon app start up this method sets the content view to main
   * activity which is then used to create all the buttons for the
   * stages and the button for events.
   *******************************************************************/
  @RequiresApi(api = Build.VERSION_CODES.M)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_stages);

    int i = 0;

    for (ImageButton b: buttons) {
      b = findViewById(ids[i]);
      final Intent tosend = new Intent(StageSelect.this,
              charClasses[i]);
      b.setOnClickListener(v -> startActivity(tosend));
      i++;
    }
  }
}
