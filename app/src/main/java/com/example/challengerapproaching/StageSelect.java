package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.Stages.*;

/**********************************************************************
 * This class generates the stage select screen by
 * setting the contentview, instantiating buttons, and setting
 * their listeners to their respective classes.
 *********************************************************************/

public class StageSelect extends AppCompatActivity {

    /** Button For Battle Field. */
    Button BattleField;

    /** Button For Final Destination. */
    Button FinalDestination;

    /** Button For Kalos Pokemon League. */
    Button KalosPokemonLeague;

    /** Button For Lylat Cruise. */
    Button LylatCruise;

    /** Button For Pokemon Stadium. */
    Button PokemonStadium;

    /** Button For Pokemon Stadium 2. */
    Button PokemonStadium2;

    /** Button For Smashville. */
    Button Smashville;

    /** Button For Town and City. */
    Button TownAndCity;

    /** Button For Unova Pokemon League. */
    Button UnovaPokemonLeague;

    /** Button For Yoshi's Island.*/
    Button YoshiIsland;

    /** Button For Yoshi's Story. */
    Button YoshisStory;

    /** Button array of the stage buttons. */
    Button [] buttons = {BattleField, FinalDestination, KalosPokemonLeague
            , LylatCruise, PokemonStadium, PokemonStadium2,
            Smashville, TownAndCity, UnovaPokemonLeague,
            YoshiIsland, YoshisStory};

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
     * characters and the button for events.
     *******************************************************************/
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages);

        int i = 0;

        for (Button b: buttons) {
            b = findViewById(ids[i]);
            final Intent tosend = new Intent(StageSelect.this,
                    charClasses[i]);
            b.setOnClickListener(v -> startActivity(tosend));
            i++;
        }
    }
}
