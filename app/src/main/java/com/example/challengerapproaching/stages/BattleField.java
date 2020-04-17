package com.example.challengerapproaching.stages;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;

/** This class sets the content view to Battlefields's xml
 * file when the respective button is pushed.*/

public class BattleField extends AppCompatActivity {

  @Override
  protected void onCreate(final Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_battle_field);
  }
}
