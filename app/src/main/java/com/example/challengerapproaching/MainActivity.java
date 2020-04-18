package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/********************************************************************
 * This class creates the main page of the app displaying buttons to
 * navigate to the events menu, character or stage pages.
 *******************************************************************/

public class MainActivity extends AppCompatActivity { //NOPMD

  /** Image Button for Characters. */
  /* default */ transient ImageButton characters;//NOPMD

  /** Image Button for Stages. */
  /* default */ transient ImageButton stages;//NOPMD

  /** Image Button for Events. */
  /* default */ transient ImageButton events;//NOPMD

  /********************************************************************
   * Upon app start up this method sets the content view to main
   * activity which is then used to create all the buttons for the
   * characters and the button for events.
   *******************************************************************/
  @RequiresApi(api = Build.VERSION_CODES.M)
  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);

    final StrictMode.ThreadPolicy policy =
        new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    setContentView(R.layout.activity_main);

    characters = findViewById(R.id.characters);
    characters.setOnClickListener(v -> {
      final Intent toCharacters = new Intent(this, CharacterSelect.class);
      startActivity(toCharacters);
    });

    stages = findViewById(R.id.stages);
    stages.setOnClickListener(v -> {
      final Intent toStages = new Intent(this, StageSelect.class);
      startActivity(toStages);
    });

    events = findViewById(R.id.events);
    events.setOnClickListener(v -> {
      final Intent toEvents = new Intent(this, EventsActivity.class);
      startActivity(toEvents);
    });
  }
}