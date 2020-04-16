package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  /** Image Button for Young Link. */
  ImageButton characters;

  /** Image Button for Zelda. */
  ImageButton stages;

  /** Image Button for Zero Suit Samus. */
  ImageButton events;

  /** Array of integers of the character ids found in the XML. */
  int [] ids = {R.id.characters, R.id.events, R.id.stages};

  /** Array of Classes for each character. */
  Class [] charClasses = {CharacterSelect.class, EventsActivity.class,
    StageSelect.class};

  /********************************************************************
   * Upon app start up this method sets the content view to main
   * activity which is then used to create all the buttons for the
   * characters and the button for events.
   *******************************************************************/
  @RequiresApi(api = Build.VERSION_CODES.M)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    setContentView(R.layout.activity_main);

    characters = findViewById(R.id.characters);
    characters.setOnClickListener(v -> {
      final Intent toCharacters = new Intent(MainActivity.this, CharacterSelect.class);
      startActivity(toCharacters);
    });

    stages = findViewById(R.id.stages);
    stages.setOnClickListener(v -> {
      final Intent toStages = new Intent(MainActivity.this, StageSelect.class);
      startActivity(toStages);
    });

    events = findViewById(R.id.events);
    events.setOnClickListener(v -> {
      final Intent toEvents = new Intent(MainActivity.this, EventsActivity.class);
      startActivity(toEvents);
    });
  }
}